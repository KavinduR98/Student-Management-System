package com.ushan.studentManagementSystem.mapper;

import com.ushan.studentManagementSystem.dto.StudentRequestDTO;
import com.ushan.studentManagementSystem.dto.StudentResponseDTO;
import com.ushan.studentManagementSystem.model.Student;

import java.time.LocalDate;

public class StudentMapper {
    public static StudentResponseDTO toDTO(Student student){
        StudentResponseDTO studentDTO = new StudentResponseDTO();
        studentDTO.setId(student.getId().toString());
        studentDTO.setName(student.getName());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setDateOfBirth(student.getDateOfBirth().toString());

        return studentDTO;
    }

    public static Student toModel(StudentRequestDTO studentRequestDTO){
        Student newStudent = new Student();
        newStudent.setName(studentRequestDTO.getName());
        newStudent.setAddress(studentRequestDTO.getAddress());
        newStudent.setEmail(studentRequestDTO.getEmail());
        newStudent.setDateOfBirth(LocalDate.parse(studentRequestDTO.getDateOfBirth()));
        newStudent.setRegisteredDate(LocalDate.parse(studentRequestDTO.getRegisteredDate()));

        return newStudent;
    }
}
