package com.example.Swagger.Repo;

import com.example.Swagger.Model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customers,Integer> {
}
