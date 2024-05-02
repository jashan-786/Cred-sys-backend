package com.example.propertymanagerms.services.Impl;


import com.example.propertymanagerms.entities.PropertyManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PropertyServiceImp {

    public ResponseEntity<List<PropertyManager>> getPropertyManagers();


    public  ResponseEntity<PropertyManager> getPropertyManagerById(String id);


    public  ResponseEntity<PropertyManager> createPropertyManager(PropertyManager propertyManager);

    public ResponseEntity<String> updatePropertyManager(String id, PropertyManager manager) ;

    public ResponseEntity<String> deletePropertyManager(String id) ;



}
