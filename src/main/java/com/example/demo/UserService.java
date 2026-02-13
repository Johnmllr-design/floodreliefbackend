package com.example.demo;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UserService {

    public UserRepo repo;
    public BCryptPasswordEncoder encoder;

    public UserService(UserRepo injectedRepository){
        this.repo = injectedRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    /* Add a new user to the database */
    public Boolean addUser(String username, String password){
        try{
            String encodedPassowrd = this.encoder.encode(password);
            User newUser = new User(username, encodedPassowrd);
            this.repo.save(newUser);
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /* Get the users information */
    public Boolean getUser(String username, String password){

        Optional<User> possibleUser = this.repo.findById(username); // check if user exists

        if (possibleUser.isPresent()) {
            User user = possibleUser.get(); // get user object
            String storedPassword = user.getPassword();
            if (storedPassword == null || storedPassword.isBlank()) return false;
            return this.encoder.matches(password, storedPassword);
        } else {
            return false; // user doesn't exist
        }
    }

}
