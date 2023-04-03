package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Client;
@Repository
public interface ClientRepo extends JpaRepository<Client,Integer>{

}
