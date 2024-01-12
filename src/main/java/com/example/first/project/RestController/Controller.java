package com.example.first.project.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Controller {
    //http://localhost:8080/test/hello
    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hello Roy !";
    }
}
