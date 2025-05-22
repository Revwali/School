package com.example.Micro_Resource.service;

import com.example.Micro_Resource.DTO.StudentDTO;
import com.example.Micro_Resource.Entity.Student;
import com.example.Micro_Resource.repositryInterface.StudentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        //   return StudentDTO.builder().build();
           return new StudentDTO();
       }
       else{
           try{
               student.setPasswordHash(passwordEncoder.encode(student.getPasswordHash()));
              Student savedStudent =  studentRepositry.save(student);
           /*   StudentDTO studentDTO = StudentDTO.builder().firstName(savedStudent.getFirstName())
                      .lastName(savedStudent.getLastName()).build();*/
               StudentDTO studentDTO = new StudentDTO();
               studentDTO.setFirstName(savedStudent.getFirstname());
               studentDTO.setLastName(savedStudent.getLastname());
              return studentDTO;
           } catch (Exception e) {
               // add custom expection
              // return StudentDTO.builder().build();
               return new StudentDTO();
           }
       }
   }


   public StudentDTO getStudentDTOById(int id){
       if(studentRepositry == null){
           // add custom expection for db not avialable
           //   return StudentDTO.builder().build();
           return new StudentDTO();
       }
       else{
           try{
               Optional<Student> savedStudent =  studentRepositry.findById(id);
           /*   StudentDTO studentDTO = StudentDTO.builder().firstName(savedStudent.getFirstName())
                      .lastName(savedStudent.getLastName()).build();*/
               if(!savedStudent.isEmpty()) {
                   StudentDTO studentDTO = new StudentDTO();
                   studentDTO.setFirstName(savedStudent.get().getFirstname());
                   studentDTO.setLastName(savedStudent.get().getLastname());
                   studentDTO.setCurrentYear(savedStudent.get().getCurrentyear());
                   return studentDTO;
               }
               else return new StudentDTO();
           } catch (Exception e) {
               // add custom expection
               // return StudentDTO.builder().build();
               return new StudentDTO();
           }
       }
   }
}
