package com.example.userms.entities;


import com.example.userms.Utils.EmploymentStatus;
import com.example.userms.Utils.ImmigrationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String PerosnID;

    private String FirstName;

    private String LastName;

    private String Dob;

    private String Sin;

    private ImmigrationStatus ImmigrationStatus;

    private EmploymentStatus EmploymentStatus;

    private String CreditScore;

    private  String LeaseDocumentId;

    private String CurrentBuilding;


    @Column(name = "rental_history" )
    private String rentalHistory;

    public void addToRentalHistory(Long propertyId) {
        if (rentalHistory == null) {
            rentalHistory = String.valueOf(propertyId);
        } else {
            rentalHistory = rentalHistory + "," + propertyId;
        }
    }

    public List<Long> getRentalHistoryAsList() {
        if (rentalHistory == null) {
            return Collections.emptyList();
        }
        return Arrays.stream(rentalHistory.split(","))
                .mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toList());
    }

}





