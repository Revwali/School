package com.example.Micro_Resource.DAO;

import com.example.Micro_Resource.Entity.Student;

import java.util.Optional;


public interface StudentDao {

   public Optional<Student> SaveStudent(Student student);
    public Optional<Student> getStudentById(int id);
    public Optional<Iterable<Student>> getAllStudents();
    public Iterable<Student> getAllStudentsByYear(int year);
    public Iterable<Student> getAllTopStudentsByYear(int year, Double percent);
    public Iterable<Student> getAllStudentByFeesPending();
    public Iterable<Student> getAllStudentByFeesPendingWithYear(int year);
}
