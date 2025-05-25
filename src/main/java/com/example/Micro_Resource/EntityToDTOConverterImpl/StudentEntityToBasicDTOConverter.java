package com.example.Micro_Resource.EntityToDTOConverterImpl;

import com.example.Micro_Resource.DTO.StudentDTO;
import com.example.Micro_Resource.Entity.Student;
import com.example.Micro_Resource.EntityToDTOConverter.EntityToDTOConverter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
different type of student to DTO will be used for different usecase this is for basic DTO to show
Studen object with minimal info
 */
public class StudentEntityToBasicDTOConverter implements EntityToDTOConverter<Student,StudentDTO> {
    // Singleton
    private static class StudentEntityToDTOConverterSingleton {
        static final StudentEntityToBasicDTOConverter studentEntityToDTOConverter =
                new StudentEntityToBasicDTOConverter();
    }

    private StudentEntityToBasicDTOConverter() {
    }

    public static StudentEntityToBasicDTOConverter getInstance() {
        return StudentEntityToDTOConverterSingleton.studentEntityToDTOConverter;
    }

    /*
      this getDTOAsBasic is for getting StudentDTO with basics name,lastname, current year only
     */
    @Override
    public Optional<StudentDTO> getDTOAsBasic(Student student) {
        // use lombook when it starts working
        StudentDTO studentDTO = new StudentDTO();
        if (student != null) {
            studentDTO.setFirstName(student.getFirstname());
            studentDTO.setLastName(student.getLastname());
            studentDTO.setCurrentYear(student.getCurrentyear());
        }
        return Optional.of(studentDTO);


    }

    /*
      this getAllDTOAsBasic is for getting List of StudentDTO's with basics
       name,lastname, current year only
     */
    @Override
    public Optional<List<StudentDTO>> getAllDTOAsBasic(Iterator<Student> students) {
        List<StudentDTO> list = new ArrayList<>();
        if (students != null) {
            // making a defensive copy to be safe from concurrent modification

            List<Student> studentList = new ArrayList<>();
            students.forEachRemaining(studentList::add);
            for (Student student : studentList) {
                list.add(this.getDTOAsBasic(student).get());
            }
        }
        return Optional.of(list);
    }
}
