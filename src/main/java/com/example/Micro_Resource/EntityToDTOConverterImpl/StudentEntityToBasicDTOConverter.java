package com.example.Micro_Resource.EntityToDTOConverterImpl;

import com.example.Micro_Resource.DTO.StudentDTO;
import com.example.Micro_Resource.Entity.Student;
import com.example.Micro_Resource.EntityToDTOConverter.EntityToDTOConverter;

import java.util.Optional;

/*
different type of student to DTO will be used for different usecase this is for basic DTO to show
Studen object with minimal info
 */
public class StudentEntityToBasicDTOConverter implements EntityToDTOConverter<Student,StudentDTO> {
    // Singleton
    private static class StudentEntityToDTOConverterSingleton{
            static final StudentEntityToBasicDTOConverter studentEntityToDTOConverter =
                    new StudentEntityToBasicDTOConverter();
    }
    private StudentEntityToBasicDTOConverter(){}
    public static StudentEntityToBasicDTOConverter getInstance(){
        return StudentEntityToDTOConverterSingleton.studentEntityToDTOConverter;
    }

    @Override
    public Optional<StudentDTO> getDTOAsFull(Student student) {
        // use lombook when it starts working
        StudentDTO studentDTO = new StudentDTO();
        if( student == null){
           return Optional.of(studentDTO);
        }
        else {
            studentDTO.setFirstName(student.getFirstname());
            studentDTO.setLastName(student.getLastname());
            studentDTO.setCurrentYear(student.getCurrentyear());
            return Optional.of(studentDTO);
        }

    }
}
