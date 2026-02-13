package com.example.demo;
import org.springframework.data.mongodb.repository.*;

public interface UserRepo extends MongoRepository<User, String> {
}
