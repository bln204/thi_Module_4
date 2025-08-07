package com.thi_m4.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer {
    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
}
