package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("ticket")      //    /books/
@CrossOrigin(origins = "http://localhost:8080")
public class TicketController {
}
