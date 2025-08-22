package com.example.nagoyameshi1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi1.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // メールアドレスで検索したい場合
    Optional<User> findByEmail(String email);
}
