package com.example.Micro_Resource.controller;

import com.example.Micro_Resource.DTO.StudentDTO;
import com.example.Micro_Resource.Entity.Student;
import com.example.Micro_Resource.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<StudentDTO>  saveStudent(@RequestBody Student student){
       StudentDTO studentDTO = studentService.SaveStudent(student);
       return  ResponseEntity.ok(studentDTO);
    }

}
