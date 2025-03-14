package dev.rumetshofer.icalfilter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class ShowcaseAdapter {

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World!");
    }
}
