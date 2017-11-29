package com.dragon.springcloud.microservicesimpleconsumermovie.controller;

import com.dragon.springcloud.microservicesimpleconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable Long id) {
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(userServiceUrl + id, User.class);
        return responseEntity.getBody();
    }
}
