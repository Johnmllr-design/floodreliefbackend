package com.example.demo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins = "*")
public class Controller {

    // inject service class
    private UserService service;


    public Controller(UserService injectableService){
        this.service = injectableService;
    }

    @GetMapping("/")
    public String home() {
        return "Flood Payout API is running. Endpoints: POST /makenewuser, POST /validatelogin";
    }

    @PostMapping("/makenewuser")
    public Boolean makeNewUser(@Valid @RequestBody NewUserRequest request) {
        System.out.println("Controller hit: POST /makenewuser");
        return true;
        //return this.service.addUser(request.username(), request.password());
    }    

    @PostMapping("/validatelogin")
    public Boolean validatelogin(@Valid @RequestBody NewUserRequest request) {
        System.out.println("Controller hit: POST /validatelogin");
        return true;
        //return this.service.getUser(request.username(), request.password());
    }  
}
