package com.example.tacoroman.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.tacoroman.domain.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long>{

}
