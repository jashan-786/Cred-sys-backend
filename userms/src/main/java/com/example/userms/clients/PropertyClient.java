package com.example.userms.clients;


import com.example.userms.external.Property;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "PROPERTYMS")
public interface PropertyClient {
    @GetMapping("/api/v1/Property/{id}")
    Property getProperty(@PathVariable("id")  String id);

}
