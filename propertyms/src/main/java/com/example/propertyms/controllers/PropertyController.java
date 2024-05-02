package com.example.propertyms.controllers;


import com.example.propertyms.entities.Property;
import com.example.propertyms.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Property")
public class PropertyController {


    @Autowired
    PropertyService PropertyService;


    @GetMapping
    public ResponseEntity<List<Property>> getPropertys() {

        return  PropertyService.getPropertys();


    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable String id) {
        return  PropertyService.getPropertyById(id);


    }

    @PostMapping
    public ResponseEntity<Property> addProperty( @RequestBody Property Property) {

      return PropertyService.createProperty(Property);


    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProperty(@PathVariable String id, @RequestBody Property Property) {
        return  PropertyService.updateProperty(id, Property);

    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteProperty(@PathVariable String id) {

        return  PropertyService.deleteProperty(id);

    }
}
