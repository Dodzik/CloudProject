package com.cloud.cloudproject.Controller;

import com.cloud.cloudproject.Controller.request.CreateUser;
import com.cloud.cloudproject.Controller.request.RatingGame;
import com.cloud.cloudproject.entity.User;
import com.cloud.cloudproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {
    private UserRepository userRepository;

    @PostMapping("/api/createUser")
    public void createUser(@RequestBody CreateUser createUser){
        log.info(createUser.login);
        userRepository.saveUser(createUser.login, createUser.pass);
    }

    @PostMapping("/api/getAllUsers")
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }
}
