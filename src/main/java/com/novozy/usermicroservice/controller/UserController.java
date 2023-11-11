package com.novozy.usermicroservice.controller;

import com.novozy.usermicroservice.dto.UserDTO;
import com.novozy.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> saveUser (@RequestBody UserDTO userDTO){
        UserDTO saved = userService.sveUser(userDTO);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/fetchAllUsers")
    public ResponseEntity<List<UserDTO>> fetchAllUsers(){
        List<UserDTO> userDTOS = userService.fetchAllUsers();
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

    @GetMapping("/fetchUserById/{userId}")
    public ResponseEntity<UserDTO> fetchUserDetailsById(@PathVariable Integer userId){
      return userService.fetchUserDetailsById(userId);
    }
}
