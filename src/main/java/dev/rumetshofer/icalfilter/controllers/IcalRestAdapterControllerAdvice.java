package dev.rumetshofer.icalfilter.controllers;

import dev.rumetshofer.icalfilter.core.ports.exceptions.CalendarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {IcalRestAdapter.class})
public class IcalRestAdapterControllerAdvice {

    @ExceptionHandler(CalendarNotFoundException.class)
    public ResponseEntity<String> handleCalendarNotFoundException(CalendarNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
