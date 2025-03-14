package com.example.tacoroman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tacoroman.domain.Taco;

public interface TacoRepository extends JpaRepository<Taco, Long>{
}
