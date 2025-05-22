package com.example.Micro_Resource.repositryInterface;

import com.example.Micro_Resource.Entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositry extends CrudRepository<Student,Integer> {
}
