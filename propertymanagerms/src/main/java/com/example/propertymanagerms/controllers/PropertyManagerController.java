package com.example.propertymanagerms.controllers;


import com.example.propertymanagerms.entities.PropertyManager;
import com.example.propertymanagerms.services.PropertyManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/PropertyManager")
public class PropertyManagerController {


    @Autowired
    PropertyManagerService propertyManagerService;


    @GetMapping
    public ResponseEntity<List<PropertyManager>> getPropertyManagers() {

        return  propertyManagerService.getPropertyManagers();


    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyManager> getPropertyManagerById(@PathVariable String id) {
        return  propertyManagerService.getPropertyManagerById(id);


    }

    @PostMapping
    public ResponseEntity<PropertyManager> addPropertyManager( @RequestBody PropertyManager propertyManager) {

      return propertyManagerService.createPropertyManager(propertyManager);


    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePropertyManager(@PathVariable String id, @RequestBody PropertyManager propertyManager) {
        return  propertyManagerService.updatePropertyManager(id, propertyManager);

    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deletePropertyManager(@PathVariable String id) {

        return  propertyManagerService.deletePropertyManager(id);

    }
}
