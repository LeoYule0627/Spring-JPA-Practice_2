package com.example.springwebservice.service;

import com.example.springwebservice.controller.dto.request.CreateUserRequest;
import com.example.springwebservice.controller.dto.request.UpdateUserRequest;
import com.example.springwebservice.controller.dto.response.StatusResponse;
import com.example.springwebservice.model.UserRepository;
import com.example.springwebservice.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracticeService {
    @Autowired
    private UserRepository userRepository;

    public User practiceGetUser(String name, int age){
        User response = userRepository.getUser(name,age);
        return response;

    }
    public String practiceCreateUser(CreateUserRequest request){
        int res = userRepository.createUser(request.getId(),request.getName(),request.getAge());
        if(res>0) return StatusResponse.setResponse("OK",null);
        else  return StatusResponse.setResponse("FAIL",null);
    }
    public String practiceUpdateUser(int id, UpdateUserRequest request){
        int res = userRepository.updateUser(request.getName(), request.getAge(), id);
        if(res>0) return StatusResponse.setResponse("OK",null);
        else  return StatusResponse.setResponse("FAIL",null);
    }
    public String practiceDeleteUser(String name, int age) {
        int res = userRepository.deleteByNameAndAge(name,age);
        if(res>0) return StatusResponse.setResponse("OK",null);
        else  return StatusResponse.setResponse("FAIL",null);
    }
}
