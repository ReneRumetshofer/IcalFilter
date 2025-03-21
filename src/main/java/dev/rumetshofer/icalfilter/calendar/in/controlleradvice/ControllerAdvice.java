package dev.rumetshofer.icalfilter.calendar.in.controlleradvice;

import dev.rumetshofer.icalfilter.calendar.core.ports.exceptions.CalendarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(CalendarNotFoundException.class)
    public ResponseEntity<String> handleCalendarNotFoundException(CalendarNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
