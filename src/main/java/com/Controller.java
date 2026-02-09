package com;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "https://flood-relief-frontend-nine.vercel.app/")
public class Controller {

    // inject service class
    private UserService service;


    public Controller(UserService injectableService){
        this.service = injectableService;
    }

    @PostMapping("/makenewuser")
    public Boolean makeNewUser(@RequestBody NewUserRequest request) {
        return this.service.addUser(request.username(), request.password());
    }    

    @PostMapping("/validatelogin")
    public Boolean validatelogin(@RequestBody NewUserRequest request) {
        return this.service.getUser(request.username(), request.password());
    }  
}
