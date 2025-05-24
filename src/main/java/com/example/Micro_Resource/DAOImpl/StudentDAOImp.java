package com.example.Micro_Resource.DAOImpl;

import com.example.Micro_Resource.DAO.StudentDao;
import com.example.Micro_Resource.Entity.Student;
import com.example.Micro_Resource.repositryInterface.StudentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentDAOImp implements StudentDao {


    private StudentRepositry studentRepositry;

    @Autowired
    public void setStudentRepositry(StudentRepositry studentRepositry) {
        this.studentRepositry = studentRepositry;
    }

    @Override
    @Transactional
    public Optional<Student> SaveStudent(Student student) {
        if( studentRepositry == null){
            /// log DB not avaialable
        return Optional.empty();
        }
        else
        return Optional.of(studentRepositry.save(student));

        
    }

    @Override
    public Optional<Student> getStudentById(int id) {
        if( studentRepositry == null){
            /// log DB not avaialable
        return Optional.empty();
        }
        else
            return studentRepositry.findById(id);
    }

    @Override
    public Optional<Iterable<Student>> getAllStudents() {
        if( studentRepositry == null){
            /// log DB not avaialable
        return Optional.empty();
        }
        else {
            try {
                return Optional.ofNullable(studentRepositry.findAll());
            } catch (Exception e) {
                // implement exception handling later
                return Optional.empty();
            }
        }
    }

    @Override
    public Iterable<Student> getAllStudentsByYear(int year) {
        return null;
    }

    @Override
    public Iterable<Student> getAllTopStudentsByYear(int year, Double percent) {
        return null;
    }

    @Override
    public Iterable<Student> getAllStudentByFeesPending() {
        return null;
    }

    @Override
    public Iterable<Student> getAllStudentByFeesPendingWithYear(int year) {
        return null;
    }
}
