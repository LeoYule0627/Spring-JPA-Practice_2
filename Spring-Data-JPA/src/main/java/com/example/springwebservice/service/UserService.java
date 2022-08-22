package com.example.springwebservice.service;

import com.example.springwebservice.controller.dto.request.CreateUserRequest;
import com.example.springwebservice.controller.dto.request.UpdateUserRequest;
import com.example.springwebservice.controller.dto.response.StatusResponse;
import com.example.springwebservice.model.UserRepository;
import com.example.springwebservice.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> response = userRepository.findAll();
        return response;
    }

    public User getUser(int id) {
        User user = userRepository.findById(id);
        return user;
    }

    public String createUser(CreateUserRequest request) {
        User check = userRepository.findById(request.getId());
        if (check == null && request.getId() != 0 && request.getName() != "" && request.getAge() != 0) {
            User createUser = new User();
            createUser.setId(request.getId());
            createUser.setAge(request.getAge());
            createUser.setName(request.getName());
            userRepository.save(createUser);
            return StatusResponse.setResponse("OK", createUser);
        } else
            return StatusResponse.setResponse("FAIL", null);

    }

    public String updateUser(int id, UpdateUserRequest request) {
        User updateUser = userRepository.findById(id);
        if (request.getName() != "" && request.getAge() != 0) {
            updateUser.setAge(request.getAge());
            updateUser.setName(request.getName());
            userRepository.save(updateUser);
            return StatusResponse.setResponse("OK", updateUser);
        } else
            return StatusResponse.setResponse("FAIL", null);

    }

    public String deleteUser(int id) {
        User deletedUser = userRepository.findById(id);
        if (null == deletedUser) {
            return StatusResponse.setResponse("FAIL", null);
        }
        Long count = userRepository.deleteById(id);
        return StatusResponse.setResponse("OK", null);
    }
} // Class end
