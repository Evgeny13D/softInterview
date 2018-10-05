<#-- @ftlvariable name="participant" type="A402.model.Participant" -->
<#-- @ftlvariable name="event" type="A402.model.Event_NV" -->
<#-- @ftlvariable name="event_date" type="java.util.Date" -->
<#setting time_format="HH:mm">
<#setting date_format="dd/MM/YYYY">
Добрый день ${participant.firstName}.

Вы успешно прошли регистрацию на мероприятие ${event.nameRu}.

Которое состоится ${event_date?date} в ${event.startTime?time}.