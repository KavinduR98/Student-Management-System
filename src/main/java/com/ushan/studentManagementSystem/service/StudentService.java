package com.ushan.studentManagementSystem.service;

import com.ushan.studentManagementSystem.dto.StudentRequestDTO;
import com.ushan.studentManagementSystem.dto.StudentResponseDTO;
import com.ushan.studentManagementSystem.exception.EmailAlreadyExistsException;
import com.ushan.studentManagementSystem.exception.StudentNotFoundException;
import com.ushan.studentManagementSystem.mapper.StudentMapper;
import com.ushan.studentManagementSystem.model.Student;
import com.ushan.studentManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponseDTO> getStudents(){
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> StudentMapper.toDTO(student)).toList();
    }

    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO){
        if (studentRepository.existsByEmail(studentRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A student with this email " + studentRequestDTO.getEmail() + " already exists");
        }
        Student student = studentRepository.save(StudentMapper.toModel(studentRequestDTO));
        return StudentMapper.toDTO(student);
    }

    public StudentResponseDTO updateStudent(UUID id, StudentRequestDTO studentRequestDTO){
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new StudentNotFoundException("Student not found with ID: " + id));

        if(studentRepository.existsByEmailAndIdNot(studentRequestDTO.getEmail(), id)){
            throw new EmailAlreadyExistsException("A student with this email " + studentRequestDTO.getEmail() + " already exists");
        }

        student.setName(studentRequestDTO.getName());
        student.setAddress(studentRequestDTO.getAddress());
        student.setEmail(studentRequestDTO.getEmail());
        student.setDateOfBirth(LocalDate.parse(studentRequestDTO.getDateOfBirth()));

        Student updatedStudent = studentRepository.save(student);

        return StudentMapper.toDTO(updatedStudent);
    }

    public void deleteStudent(UUID id){
        studentRepository.deleteById(id);
    }
}
