package fi.example.quartzexample.service;

import org.quartz.JobExecutionContext;
import org.quartz.StatefulJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

import fi.example.quartzexample.service.MailService;

public class SendMailJob extends QuartzJobBean implements StatefulJob {
  
  private MailService sendMailService;
  
  public void executeInternal(JobExecutionContext ctx) {
    sendMailService.sendMail("test subject", "test body");
  }

  public void setSendMailService(MailService sendMailService) {
    this.sendMailService = sendMailService;
  }
}