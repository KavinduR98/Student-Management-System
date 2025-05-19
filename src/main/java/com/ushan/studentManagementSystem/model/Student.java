package com.ushan.studentManagementSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;
    private String email;
    private String address;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}
