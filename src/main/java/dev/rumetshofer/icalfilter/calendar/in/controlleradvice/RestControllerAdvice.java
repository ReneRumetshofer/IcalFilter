package dev.rumetshofer.icalfilter.calendar.in.controlleradvice;

import dev.rumetshofer.icalfilter.calendar.core.ports.exceptions.CalendarNotFoundException;
import dev.rumetshofer.icalfilter.calendar.core.ports.exceptions.EventFilterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerAdvice {

    @ExceptionHandler(CalendarNotFoundException.class)
    public ResponseEntity<String> handleCalendarNotFoundException(CalendarNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(EventFilterNotFoundException.class)
    public ResponseEntity<String> handleCalendarNotFoundException(EventFilterNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
