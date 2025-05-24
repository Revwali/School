package com.example.Micro_Resource.service;

import com.example.Micro_Resource.DAO.StudentDao;
import com.example.Micro_Resource.DTO.StudentDTO;
import com.example.Micro_Resource.Entity.Student;
import com.example.Micro_Resource.EntityToDTOConverter.EntityToDTOConverter;
import com.example.Micro_Resource.EntityToDTOConverterImpl.StudentEntityToBasicDTOConverter;
import com.example.Micro_Resource.repositryInterface.StudentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
extract logic of conveing DTO to entity and Entity to DTO in another package.
 */

@Service
public class StudentService {


    private PasswordEncoder passwordEncoder;
    private StudentDao studentDao;
    private  static EntityToDTOConverter<Student, StudentDTO> entityToDTOConverter = StudentEntityToBasicDTOConverter.getInstance();

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public  void setStudentDao(StudentDao studentDao){

        this.studentDao=studentDao;
    }

    public StudentDTO SaveStudent(Student student){
       if(studentDao == null){
           // add custom expection for db not avialable
        //   return StudentDTO.builder().build();
           return new StudentDTO();
       }
       else {
           try {
               student.setPasswordHash(passwordEncoder.encode(student.getPasswordHash()));
               Optional<Student> savedStudent = studentDao.SaveStudent(student);
               Student returnedStudent = savedStudent.orElseGet(() -> new Student());
           /*   StudentDTO studentDTO = StudentDTO.builder().firstName(savedStudent.getFirstName())
                      .lastName(savedStudent.getLastName()).build();*/
               return  entityToDTOConverter.getDTOAsFull(returnedStudent).get();
           } catch (Exception e) {
              // log and handle exception
               return  new StudentDTO();
           }
       }
   }


   public StudentDTO getStudentDTOById(int id){
       if(studentDao == null){
           //   return StudentDTO.builder().build();
           return new StudentDTO();
       }
       else{
           try{
               Optional<Student> savedStudent =  studentDao.getStudentById(id);
           /*   StudentDTO studentDTO = StudentDTO.builder().firstName(savedStudent.getFirstName())
                      .lastName(savedStudent.getLastName()).build();*/
               return  entityToDTOConverter.getDTOAsFull(
                       savedStudent.orElseGet(() -> null)
               ).get();
              /* if(savedStudent.isEmpty()) {
                   // log id resource not found
                   System.out.println("with id not found");
                   return new StudentDTO();
               }
               else {
                  *//* StudentDTO studentDTO = new StudentDTO();
                   studentDTO.setFirstName(savedStudent.get().getFirstname());
                   studentDTO.setLastName(savedStudent.get().getLastname());
                   studentDTO.setCurrentYear(savedStudent.get().getCurrentyear());*//*
                   return studentDTO;

               }*/
           } catch (Exception e) {
               // add custom expection
               // return StudentDTO.builder().build();
               return new StudentDTO();
           }
       }
   }
}
