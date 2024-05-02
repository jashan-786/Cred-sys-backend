package com.example.propertyms.entities;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "Properties")
public class Property {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String property_id;


    @Nonnull
    private String address;

    private String city;

    private String province;

    private String country;

    private String pincode;

}