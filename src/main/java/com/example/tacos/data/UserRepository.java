package com.example.tacos.data;

import com.example.tacos.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
