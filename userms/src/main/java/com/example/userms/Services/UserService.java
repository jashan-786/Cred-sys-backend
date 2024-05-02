package com.example.userms.Services;


import com.example.userms.Services.Impl.userImpl;
import com.example.userms.clients.PropertyClient;
import com.example.userms.entities.User;
import com.example.userms.repository.UserRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements userImpl {



    @Autowired
    private UserRepository userRepository;

    // will use feign clients to get data from related properties



    public UserService(UserRepository userRepository ) {
        this.userRepository = userRepository;

    }


    @CircuitBreaker( name = "propertyBreaker" , fallbackMethod = "propertyBreakerFallback")
    @Retry( name = "propertyBreaker" , fallbackMethod = "propertyBreakerFallback")

    @RateLimiter( name = "propertyBreaker" , fallbackMethod = "propertyBreakerFallback")
    public ResponseEntity<List<User>> getUser() {
        List<User> users = userRepository.findAll();

        return new ResponseEntity<List<User>>(users, HttpStatus.OK);




    }

    public List<String> propertyBreakerFallback(Exception e) {

        List<String> users = new ArrayList<>();

        users.add(e.getMessage().toString());

        return users;
    }

    public  ResponseEntity<String>  addUser(User user) {

            try {


                 userRepository.save(user);
                 return new ResponseEntity<>("User inserted",HttpStatus.OK );
            }
            catch (Exception e) {

                return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please check user details");
            }
    }

//    @Override
//    public ResponseEntity<List<User>> getUsersByPropertyId(String id) {
//
//        return new ResponseEntity<List<User>>(userRepository.findByRentalHistoryListContaining(Integer.parseInt(id)), HttpStatus.OK);
//
//
//    }


    public ResponseEntity<User> getUserById(String id) {

            User user = userRepository.findById(id).get();

            return new ResponseEntity<>(user, HttpStatus.OK);

    }

    public ResponseEntity<String> updateUser(User user) {
         User currUser= userRepository.findById(user.getPerosnID()).orElse(null);
         if(currUser != null) {

              currUser.setPerosnID(user.getPerosnID());
              currUser.setDob(user.getDob().toString());
              currUser.setFirstName(user.getFirstName());
              currUser.setLastName(user.getLastName());
              currUser.setSin(user.getSin());
              currUser.setCreditScore(user.getCreditScore());
              currUser.setRentalHistory(user.getRentalHistory());
              currUser.setEmploymentStatus(user.getEmploymentStatus());
              currUser.setImmigrationStatus(user.getImmigrationStatus());

              userRepository.save(currUser);

              return  new ResponseEntity<String>("User updated", HttpStatus.CREATED);

         }

        return  new ResponseEntity<String>("User not updated", HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<String> deleteUser(String id) {

        User currUser= userRepository.findById(id).orElse(null);

        if (currUser != null){

            userRepository.delete(currUser);

            return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
        }

        return  new ResponseEntity<String >( "User not deleted", HttpStatus.BAD_REQUEST);


    }

}
