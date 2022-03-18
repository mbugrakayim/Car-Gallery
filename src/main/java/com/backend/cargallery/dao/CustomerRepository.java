package com.backend.cargallery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.cargallery.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
