package com.example.springwebservice.model.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;

}