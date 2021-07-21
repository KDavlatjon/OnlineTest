package com.example.Test.repository;

import com.example.Test.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findById(Integer id);

    boolean existsByPhone(String phone);

    Optional<Users> findByPhone(String phone);

}
