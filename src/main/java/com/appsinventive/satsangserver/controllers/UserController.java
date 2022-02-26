package com.appsinventive.satsangserver.controllers;


import com.appsinventive.satsangserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/getUsers")
//    public String getUsers(){
//
//        return"her";
//    }

    @GetMapping("/getUsers")
    public ResponseEntity<?> getUsers(){

        return  ResponseEntity.ok(this.userRepository.findAll());
    }



}
