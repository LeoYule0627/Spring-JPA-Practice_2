package com.example.springwebservice.model;

import com.example.springwebservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    @Query(value = "SELECT * FROM member ORDER BY age DESC",nativeQuery = true)
    List<User> findAllByAgeDesc();
    @Query(value = "SELECT * FROM member WHERE age >= ?1",nativeQuery = true)
    List<User> findByAgeGreaterThan(int age);
    User findById(int id);
    Long deleteById(int id);

    @Query(value = "SELECT * FROM member WHERE NAME=?1 AND age=?2",nativeQuery = true)
    User getUser(String name,int age);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `user`.`member` (`id`, `name`, `age`) VALUES (?1, ?2, ?3)",nativeQuery = true)
    int createUser(int id,String name,int age);
    @Modifying
    @Transactional
    @Query(value = "UPDATE `user`.`member` SET NAME=?1, `age`=?2 WHERE `id`=?3",nativeQuery = true)
    int updateUser(String name,int age,int id);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `user`.`member` WHERE NAME=?1 AND age=?2",nativeQuery = true)
    int deleteByNameAndAge(String name,int age);
}
