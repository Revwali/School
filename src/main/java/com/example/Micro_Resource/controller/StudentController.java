package com.example.Micro_Resource.controller;

import com.example.Micro_Resource.DTO.StudentDTO;
import com.example.Micro_Resource.Entity.Members.Student;
import com.example.Micro_Resource.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/saveStudent/admin")
    public ResponseEntity<StudentDTO>  saveStudent(@RequestBody Student student){
       StudentDTO studentDTO = studentService.SaveStudent(student);
       return  ResponseEntity.ok(studentDTO);
    }

    @GetMapping(value = "/get")
    public  ResponseEntity<StudentDTO> getStudentWithBasicDetails(@RequestParam("firstName") String firstName,
                                                                  @RequestParam("lastName") String lasttName,
                                                                  @RequestParam("phone") String phone){
        StudentDTO studentDTO = studentService.getStudentDTOByBasicDetails(firstName,lasttName,phone);
        return ResponseEntity.ok(studentDTO);

    }

    @GetMapping("/getSure")
    public ResponseEntity<StudentDTO> getStudentForSure(@RequestParam("number") String number){
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getALL/admin")
    public ResponseEntity<? extends List<StudentDTO>> getAllStudents(@RequestParam(value = "year" ,required = false) Integer year){
        List<StudentDTO> list = studentService.getAllStudents(year);
        return ResponseEntity.ok(list);
    }


}
