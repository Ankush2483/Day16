package com.govt.govt_project.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;


    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

//    @Column(name = "address_line_1")
//    private String addressLine1;
//
//   @Column(name = "address_line_2")
//    private String addressLine2;
//
//
//    @Column(name = "city")
//    private String city;
//
//    @Column(name = "state")
//    private String state;

//    @Column(name = "postal_code")
//    private Long postalCode;
}