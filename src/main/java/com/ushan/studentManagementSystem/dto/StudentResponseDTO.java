package com.ushan.studentManagementSystem.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponseDTO {

    private String id;
    private String name;
    private String email;
    private String address;
    private String role;

}
