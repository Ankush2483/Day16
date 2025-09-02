package com.govt.govt_project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String password;
}
