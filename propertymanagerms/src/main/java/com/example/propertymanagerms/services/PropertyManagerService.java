package com.example.propertymanagerms.services;

import com.example.propertymanagerms.entities.PropertyManager;
import com.example.propertymanagerms.repository.PropertyManagerRepository;
import com.example.propertymanagerms.services.Impl.PropertyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyManagerService implements PropertyServiceImp {


    @Autowired
    public PropertyManagerRepository propertyManagerRepository;


    @Override
    public ResponseEntity<List<PropertyManager>> getPropertyManagers() {
         List<PropertyManager> propertyManagersList=  propertyManagerRepository.findAll();

         return  new ResponseEntity<>(propertyManagersList , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PropertyManager> getPropertyManagerById(String id) {
        Optional<PropertyManager> propertyManager= propertyManagerRepository.findById(id);

        if(propertyManager.isPresent()){

            return new ResponseEntity<>(propertyManager.get(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<PropertyManager> createPropertyManager(PropertyManager propertyManager) {
        return new ResponseEntity<>(propertyManagerRepository.save(propertyManager),HttpStatus.CREATED);

    }


    @Override
    public ResponseEntity<String> updatePropertyManager(String id, PropertyManager manager) {
        PropertyManager propertyManager= propertyManagerRepository.findById(id).orElse(null);

        if(propertyManager != null){

            propertyManager.setFirstName(manager.getFirstName());
            propertyManager.setLastName(manager.getLastName());
            propertyManager.setId(manager.getId());
            propertyManager.setPropertyManaged(manager.getPropertyManaged());

            propertyManagerRepository.save(propertyManager);
            return new ResponseEntity<>("Successfully updated", HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deletePropertyManager(String id) {
        PropertyManager propertyManager= propertyManagerRepository.findById(id).orElse(null);


        if(propertyManager != null){

            propertyManagerRepository.delete(propertyManager);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
