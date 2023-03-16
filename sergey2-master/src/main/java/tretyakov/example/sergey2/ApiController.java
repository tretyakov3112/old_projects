package tretyakov.example.sergey2;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    ArrayList<String> messages = new ArrayList<>();
    @GetMapping("messages")
    public List<String> getMessages() {
        return messages;
    }

    @PostMapping("messages")
    public void createMessage(@RequestBody String message){
        messages.add(message);
    }
}