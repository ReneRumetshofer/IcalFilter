package dev.rumetshofer.icalfilter.out.calendar;

import dev.rumetshofer.icalfilter.core.ports.out.ForFetchIcal;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class IcalFetchingAdapter implements ForFetchIcal {

    public Calendar fetchIcal(String url) {
        try (InputStream icalStream = new URL(url).openStream()) {
            CalendarBuilder builder = new CalendarBuilder();
            return builder.build(icalStream);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserException e) {
            throw new RuntimeException(e);
        }
    }

}
