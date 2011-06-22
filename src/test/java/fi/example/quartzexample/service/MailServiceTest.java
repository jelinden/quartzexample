package fi.example.quartzexample.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import fi.example.quartzexample.service.MailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-test.xml"})
public class MailServiceTest {

  protected final Log log = LogFactory.getLog(getClass());
 
  @Autowired
  private MailService sendMailService;

  @Test
  public void testSendMessage() throws Exception {

    if (sendMailService != null) {

      try {
        sendMailService.sendMail("test subject", "test body");
      }
      catch (Exception e) {
        fail("sendMailService test failed: "+e);
      }
    }
    else
      fail("test failed, service undefined!");
  }
}