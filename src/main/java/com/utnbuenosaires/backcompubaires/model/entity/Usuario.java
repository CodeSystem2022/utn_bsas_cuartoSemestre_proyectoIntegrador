package com.utnbuenosaires.backcompubaires.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(length = 8,unique = true,nullable = false)
    private String dni;

    @Column(length = 11,unique = true,nullable = false)
    private String cuil;

    @Column(length = 100,nullable = false)
    private String name;

    @Column(length = 100,nullable = false)
    private String lastName;

    @Column(length = 20,nullable = false)
    private String telephone;

    @Column(length = 100,nullable = false)
    private String email;

    @Column(length = 100,nullable = false)
    private String neighborhood;

    @Column(length = 100,nullable = false)
    private String province;

    @Column(length = 100,nullable = false)
    private String country;

    public Usuario(String dni, String cuil, String name, String lastName, String telephone, String email, String neighborhood, String province, String country) {
        this.dni = dni;
        this.cuil = cuil;
        this.name = name;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.neighborhood = neighborhood;
        this.province = province;
        this.country = country;
    }

}