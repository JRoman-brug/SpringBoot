package com.example.tacoroman.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.tacoroman.domain.User;

public interface UserRepository  extends CrudRepository<User, Long>{
    public User findByUsername(String username);
}
