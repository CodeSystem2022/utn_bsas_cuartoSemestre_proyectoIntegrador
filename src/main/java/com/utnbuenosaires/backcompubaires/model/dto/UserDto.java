package com.utnbuenosaires.backcompubaires.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    @Size(min = 8, max = 8)
    @NotNull
    @NotEmpty
    @NotBlank
    private String dni;

    @Size(min = 11, max = 11)
    @NotNull
    @NotEmpty
    @NotBlank
    private String cuil;

    @Size(min = 2, max = 150)
    @NotNull
    @NotBlank
    @NotEmpty
    private String name;

    @Size(min = 2, max = 150)
    @NotNull
    @NotBlank
    @NotEmpty
    private String lastName;

    @Size(min = 6,max = 20)
    @NotNull
    @NotBlank
    @NotEmpty
    private String telephone;

    @Email
    @NotNull
    @NotBlank
    @NotEmpty
    private String email;

    @Size(min = 2,max = 150)
    @NotNull
    @NotBlank
    @NotEmpty
    private String neighborhood;

    @Size(min = 2,max = 150)
    @NotNull
    @NotBlank
    @NotEmpty
    private String province;

    @Size(min = 2,max = 150)
    @NotNull
    @NotBlank
    @NotEmpty
    private String country;

}