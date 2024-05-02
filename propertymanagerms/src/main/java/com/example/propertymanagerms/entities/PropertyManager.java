package com.example.propertymanagerms.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "PropertyManager")
public class PropertyManager {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String FirstName;

    private String LastName;

    private String Sin;


    private String PropertyManaged;


}
