package fi.example.quartzexample.tools;

import java.util.TimeZone;
import org.joda.time.DateTimeZone;

public class JodaTimeZone {

  public static TimeZone getTimeZone(String timeZoneId) {
    DateTimeZone jodaZone = DateTimeZone.forID(timeZoneId);
    return jodaZone.toTimeZone();
  }
}