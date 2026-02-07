package com;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.*;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
}
