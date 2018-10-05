package A402.email;

import A402.model.Event_NV;
import A402.model.Participant;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.email.EmailPopulatingBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.simplejavamail.util.ConfigLoader;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class EmailSender implements Serializable {
    private Mailer mailer;

    private Configuration templatesConfig;

    private String unsubscribeUrl;

    public EmailSender(Configuration templatesConfig, String unsubscribeUrl) {
        this.templatesConfig = templatesConfig;
        this.unsubscribeUrl = unsubscribeUrl;
        createMailBuilder();
    }

    private void createMailBuilder() {
        ConfigLoader.loadProperties("/A402/email/configs/mail.general.properties", false);
        ConfigLoader.loadProperties("/A402/email/configs/mail.overrides.properties", true);
        mailer = MailerBuilder
//                .withSMTPServer("smtp.gmail.com", 587, "user@host.com", "password")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)

//                .withSessionTimeout(10 * 1000)
//                .clearEmailAddressCriteria() // turns off email validation
                .withProperty("mail.smtp.sendpartial", "true")
//                .withDebugLogging(true)
                .buildMailer();
    }

    private StringWriter buildEmailContent(String templateName, Participant participant, Event_NV event) throws IOException, TemplateException {
        // Create the root hash. We use a Map here, but it could be a JavaBean too.
        Map<String, Object> root = new HashMap<>();

        root.put("participant", participant);
        root.put("event", event);

        LocalDate localDate = LocalDate.of(event.getYear(), event.getMonthNumber(), event.getDayOfMonth());
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        root.put("event_date", date);

        Template template = templatesConfig.getTemplate(templateName);
        StringWriter writer = new StringWriter();
        template.process(root, writer);
        return writer;
    }

    public void sendEmailAboutNewEvents(Event_NV event, String email) throws IOException, ServletException {
        sendEmail("new_event.html.ftlh", "new_event.plain.ftlh", "Invitation to the event", null, event, email);
    }

    private void sendEmail(String htmlTemplateName, String plainTemplateName, String subject, Participant p, Event_NV event, String emailAddress) throws IOException, ServletException {
        try {
            EmailPopulatingBuilder emailBuilder = EmailBuilder.startingBlank();
            if (p == null) {
                emailBuilder.to(null, emailAddress)
                        .withHeader("List-Unsubscribe", String.format("<%s?email=%s>", unsubscribeUrl, emailAddress));
            } else {
                emailBuilder
                        .to(format("%s %s", p.getLastName(), p.getFirstName()),
                                format("<%s>", p.getEmail()))
                        .withHeader("List-Unsubscribe", String.format("<%s?email=%s>", unsubscribeUrl, p.getEmail()));
            }

            Email email = emailBuilder
                    .withHTMLText(buildEmailContent(htmlTemplateName, p, event).toString())
                    .withPlainText(buildEmailContent(plainTemplateName, p, event).toString())
                    .withSubject(subject)
                    .buildEmail();


            mailer.sendMail(email);
        } catch (TemplateException e) {
            throw new ServletException(e);
        }
    }

    public void sendRegistrationEmail(Participant p, Event_NV event) throws ServletException, IOException {
        sendEmail("registration.html.ftlh", "registration.plain.ftlh", "Registration for the event!", p, event, null);
    }
}