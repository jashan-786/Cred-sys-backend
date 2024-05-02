package com.example.propertyms.services.Impl;



import com.example.propertyms.entities.Property;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface PropertyServiceImp {

    public ResponseEntity<List<Property>> getPropertys();


    public  ResponseEntity<Property> getPropertyById(String id);


    public  ResponseEntity<Property> createProperty(Property Property);

    public ResponseEntity<String> updateProperty(String id, Property manager) ;

    public ResponseEntity<String> deleteProperty(String id) ;



}
