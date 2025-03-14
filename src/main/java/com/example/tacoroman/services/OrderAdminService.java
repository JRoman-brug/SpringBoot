package com.example.tacoroman.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tacoroman.repository.OrderRepository;

@Service
public class OrderAdminService {

    @Autowired
    private OrderRepository repo;

    public void deleteAllOrders() {
        repo.deleteAll();
    }
}
