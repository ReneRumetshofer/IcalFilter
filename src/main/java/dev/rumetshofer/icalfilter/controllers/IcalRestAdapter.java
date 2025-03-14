package dev.rumetshofer.icalfilter.controllers;

import dev.rumetshofer.icalfilter.core.ports.in.ForFilterIcalSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/ical")
public class IcalRestAdapter {

    private final ForFilterIcalSource forFilterIcalSource;

    public IcalRestAdapter(ForFilterIcalSource forFilterIcalSource) {
        this.forFilterIcalSource = forFilterIcalSource;
    }

    @GetMapping
    public ResponseEntity<byte[]> testEndpoint(@RequestParam UUID calendarUuid) {
        try {
            byte[] filteredIcal = forFilterIcalSource.filter(calendarUuid);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"calendar.ics\"");
            headers.add(HttpHeaders.CONTENT_TYPE, "text/calendar; charset=UTF-8");

            return new ResponseEntity<>(filteredIcal, headers, HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
