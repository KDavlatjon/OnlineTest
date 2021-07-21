package com.example.Test.repository;

import com.example.Test.model.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Results, Integer> {

    List<Results> findAllByUserGroup(String group);

    List<Results> findAllByUserNameAndUserLastName(String name, String lastName);
}
