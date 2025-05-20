package com.example.Micro_Resource.service;

import com.example.Micro_Resource.DTO.StudentDTO;
import com.example.Micro_Resource.Entity.Student;
import com.example.Micro_Resource.repositryInterface.StudentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private  StudentRepositry studentRepositry;
    private PasswordEncoder passwordEncoder;

    @Autowired
   public void setStudentRepositry(StudentRepositry studentRepositry){
       this.studentRepositry = studentRepositry;
   }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public StudentDTO SaveStudent(Student student){
       if(studentRepositry == null){
           // add custom expection for db not avialable
           return StudentDTO.builder().build();
       }
       else{
           try{
               student.setPasswordHash(passwordEncoder.encode(student.getPasswordHash()));
              Student savedStudent =  studentRepositry.save(student);
              StudentDTO studentDTO = StudentDTO.builder().firstName(savedStudent.getFirstName())
                      .lastName(savedStudent.getLastName()).build();
              return studentDTO;
           } catch (Exception e) {
               // add custom expection
               return StudentDTO.builder().build();
           }
       }
   }
}
