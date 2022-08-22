package com.example.springwebservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// 使用 Lombok 加入 Getter, Setter, Constructor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
public class User {
    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private int age;
}
