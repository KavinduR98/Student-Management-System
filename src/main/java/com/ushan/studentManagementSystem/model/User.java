package com.ushan.studentManagementSystem.model;

import com.ushan.studentManagementSystem.util.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
