package com.springboot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springboot1.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
