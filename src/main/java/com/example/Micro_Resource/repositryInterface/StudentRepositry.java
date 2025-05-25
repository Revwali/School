package com.example.Micro_Resource.repositryInterface;

import com.example.Micro_Resource.Entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositry extends CrudRepository<Student,Integer> {
    @Query(value = """
            select * from student where Current_Year = :year
            """,nativeQuery = true)
    public Iterable<Student> findAllByYear(@Param("year") int year);
}
