package com.govt.govt_project.model;
import lombok.*;

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
