package com.example.springwebservice.controller.dto.response;

import com.example.springwebservice.model.entity.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StatusResponse {

    public static String setResponse(String state, User user) {
        JSONObject object = new JSONObject();
        object.put("state", state);
        if (user != null) {
            JSONArray list = new JSONArray();
            Map userMap = new HashMap();
            userMap.put("id", user.getId());
            userMap.put("name", user.getName());
            userMap.put("age", user.getAge());
            list.put(userMap);
            object.put("user", list);
        }
        return object.toString();
    }
}
