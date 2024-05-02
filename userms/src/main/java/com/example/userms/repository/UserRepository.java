package com.example.userms.repository;


import com.example.userms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends  JpaRepository<User, String> {

//    List<User> findByRentalHistoryContaining(Integer propertyId);

}
