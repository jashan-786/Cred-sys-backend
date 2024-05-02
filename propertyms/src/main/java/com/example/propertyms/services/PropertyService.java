package com.example.propertyms.services;

import com.example.propertyms.entities.Property;
import com.example.propertyms.repository.PropertyRepository;
import com.example.propertyms.services.Impl.PropertyServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService implements PropertyServiceImp {


    @Autowired
    public PropertyRepository PropertyRepository;


    @Override
    public ResponseEntity<List<Property>> getPropertys() {
         List<Property> PropertysList=  PropertyRepository.findAll();

         return  new ResponseEntity<>(PropertysList , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Property> getPropertyById(String id) {
        Optional<Property> Property= PropertyRepository.findById(id);

        if(Property.isPresent()){

            return new ResponseEntity<>(Property.get(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Property> createProperty(Property Property) {
        return new ResponseEntity<>(PropertyRepository.save(Property),HttpStatus.CREATED);

    }


    @Override
    public ResponseEntity<String> updateProperty(String id, Property property) {
        Property Property= PropertyRepository.findById(id).orElse(null);

        if(Property != null){

            Property.setAddress(property.getAddress());
            Property.setCity(property.getCity());
            Property.setCountry(property.getCountry());
            Property.setPincode(property.getPincode() );
            Property.setCity(property.getPincode() );


            PropertyRepository.save(Property);
            return new ResponseEntity<>("Successfully updated", HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteProperty(String id) {
        Property Property= PropertyRepository.findById(id).orElse(null);


        if(Property != null){

            PropertyRepository.delete(Property);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
