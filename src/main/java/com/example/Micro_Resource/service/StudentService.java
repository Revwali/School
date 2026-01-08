package com.example.Micro_Resource.service;

import com.example.Micro_Resource.DTO.StudentDTO;
import com.example.Micro_Resource.Entity.Members.Student;
import com.example.Micro_Resource.EntityToDTOConverter.EntityToDTOConverter;
import com.example.Micro_Resource.EntityToDTOConverterImpl.StudentEntityToBasicDTOConverter;
import com.example.Micro_Resource.Enums.UserScope;
import com.example.Micro_Resource.repositryInterface.StudentRepositry;
import jakarta.annotation.Nullable;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/*
extract logic of conveing DTO to entity and Entity to DTO in another package.
 */

@Service
public class StudentService {

    private StudentRepositry studentRepositry;
    private PasswordEncoder passwordEncoder;
    private static EntityToDTOConverter<Student, StudentDTO> entityToDTOConverter = StudentEntityToBasicDTOConverter.getInstance();

    @Autowired
    public void setStudentRepositry(StudentRepositry studentRepositry) {
        this.studentRepositry = studentRepositry;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PreAuthorize("hasAuthority('CONTROLLER')")
    @PostAuthorize("isAuthenticated()")
    public StudentDTO SaveStudent(Student student) {
        if (studentRepositry != null) {
            try {
               student.setPasswordHash(passwordEncoder.encode(student.getPasswordHash()));
                Student savedStudent = studentRepositry.save(student);
                return entityToDTOConverter.getDTOAsBasic(savedStudent, UserScope.CONTROLLER).get();
            } catch (Exception e) {
                // log and handle exception
            }
        }
                return new StudentDTO();
            }


    public StudentDTO getStudentDTOByBasicDetails(String firstName,String lastName,String phone) {
        if (studentRepositry != null) {
            if ( (firstName != null && lastName != null && phone != null)  ) {
                try {
                    Optional<Student> savedStudent = studentRepositry.findByFirstNameLastNameAndPhone(firstName,lastName,phone);
                    return entityToDTOConverter.getDTOAsBasic(
                            savedStudent.orElseGet(() -> null), UserScope.BASIC).get();

                } catch (Exception e) {
                    // add custom expection handler
                }

            }
        }
       return new StudentDTO();
    }

    public List<StudentDTO> getAllStudents(Integer year) {
        if (studentRepositry != null) {

            try {
                Iterable<Student> studentIterable;
                if(year == 0) {
                    studentIterable = studentRepositry.findAll();
                }
                else {
                    studentIterable = studentRepositry.findAllByYear(year);
                }
                // temporarily set basic
                // UserScope scope = getAuthoritiy();
                Optional<List<StudentDTO>> allDTOAsBasic = entityToDTOConverter.getAllDTOAsBasic(studentIterable.iterator(), UserScope.BASIC);
                if (allDTOAsBasic.isPresent()) return allDTOAsBasic.get();
            } catch (Exception e) {
                // implement exception handler and log the exception
                System.out.println("somethin went wrong");
            }
        }
        return Collections.emptyList();
    }

    @PreAuthorize("hasAnyAuthority( 'STUDENT','CONTROLLER','PRINCIPAL')")
    @PostAuthorize("isAuthenticated()")
    public StudentDTO getStudentForSure(@NonNull String number){
        if(studentRepositry != null && (!number.isEmpty())  ){

            try{
             Optional<Student> optionalStudent =  studentRepositry.findByAdhaar(number);
             // temp use harcode
                // UserScope scope = getAuthoritiy();
           return entityToDTOConverter.getDTOAsBasic( optionalStudent.orElseGet(() -> new Student()),UserScope.STUDENT ).get();
            } catch (Exception e) {
                // same as for basic fetch implement exception handler and log the exception
                System.out.println("somethin went wrong");
            }
        }
        return new StudentDTO();
    }

    public UserScope getAuthoritiy(){
        // below is to fecth student info according to user scope, confused for student as he has two scopes
        // dont know how to managge b/w these two
            GrantedAuthority authorities
                  = new ArrayList<>(SecurityContextHolder.getContext().getAuthentication()
                    .getAuthorities()).get(0);
          return UserScope.getStudentScope(authorities.getAuthority());
    }
}
