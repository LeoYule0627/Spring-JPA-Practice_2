package com.example.springwebservice.controller;

import com.example.springwebservice.controller.dto.request.CreateUserRequest;
import com.example.springwebservice.controller.dto.request.UpdateUserRequest;
import com.example.springwebservice.controller.dto.response.StatusResponse;
import com.example.springwebservice.model.entity.User;
import com.example.springwebservice.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/practice/user")
public class PracticeController {

    @Autowired
    PracticeService practiceService;

    @GetMapping()
    public User getUser(@RequestParam String name,@RequestParam int age) {
        User user = this.practiceService.practiceGetUser(name,age);
        return user;
    }

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request) {
        String response = practiceService.practiceCreateUser(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id,@RequestBody UpdateUserRequest request) {
        String response = this.practiceService.practiceUpdateUser(id,request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUser(@RequestParam String name,@RequestParam int age)  {
        String response = this.practiceService.practiceDeleteUser(name,age);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
} // Class end
