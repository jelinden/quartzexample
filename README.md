Quartz example with setting timeZone and sending mail
=============

Quartzexample is a simple maven project which shows how to use quartz with Spring framework.
Set java.util.TimeZone to CronTrigger and get the TimeZone using Joda time.

To use it you need to fill out following lines to applicationContext.xml and applicationContext-test.xml

`<property name="host" value=""/> <!-- FILL IN YOUR SMTP HOST -->`

and

`<property name="from" value=""/><!-- FILL IN YOUR MAIL SENDER ADDRESS -->`  
`<property name="to" value=""/><!-- FILL IN THE ADDRESS YOU WANT TO SEND MAIL TO -->`
