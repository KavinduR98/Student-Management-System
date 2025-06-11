package com.ushan.studentManagementSystem.controller;

import com.ushan.studentManagementSystem.dto.StudentRequestDTO;
import com.ushan.studentManagementSystem.dto.StudentResponseDTO;
import com.ushan.studentManagementSystem.dto.validators.CreateStudentValidationGroup;
import com.ushan.studentManagementSystem.service.StudentService;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/students")   //

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getStudents(){
        List<StudentResponseDTO> students = studentService.getStudents();
        return ResponseEntity.ok().body(students);
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@Validated({Default.class, CreateStudentValidationGroup.class})
                                                                            @RequestBody StudentRequestDTO studentRequestDTO){
        StudentResponseDTO studentResponseDTO = studentService.createStudent(studentRequestDTO);
        return ResponseEntity.ok().body(studentResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable UUID id,
                                                            @Validated({Default.class}) @RequestBody StudentRequestDTO studentRequestDTO){

        StudentResponseDTO studentResponseDTO = studentService.updateStudent(id, studentRequestDTO);
        return ResponseEntity.ok().body(studentResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable UUID id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
