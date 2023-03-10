package com.example.BazyDanych2.repository;

import com.example.BazyDanych2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long>{
    public Optional<User> findById(Long id);
    public Optional<User> findByWorkName(String workName);
}
