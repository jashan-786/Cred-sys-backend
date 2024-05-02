package com.example.propertymanagerms.repository;


import com.example.propertymanagerms.entities.PropertyManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyManagerRepository extends JpaRepository<PropertyManager, String> {
}
