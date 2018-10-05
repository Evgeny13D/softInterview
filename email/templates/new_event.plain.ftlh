<#-- @ftlvariable name="participant" type="A402.model.Participant" -->
<#-- @ftlvariable name="event" type="A402.model.Event_NV" -->
<#-- @ftlvariable name="event_date" type="java.util.Date" -->
<#setting time_format="HH:mm">
<#setting date_format="dd/MM/YYYY">
Вас приветсвует А402.

У нас скоро будет проходить новый тренинг. И вот немного информации о нем.

${event.nameRu}
Мероприятие состоится ${event_date?date} по адресу ${event.locationRu}, ${event.addressRu}.
Время проведения ${event.startTime?time} - ${event.endTime?time}.

Больше информации можно узнать перейдя по ссылке http://a402.by/showEvent?eventId=${event.id}.