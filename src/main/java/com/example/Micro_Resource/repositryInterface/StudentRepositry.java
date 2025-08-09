package com.example.Micro_Resource.repositryInterface;

import com.example.Micro_Resource.Entity.Members.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepositry extends CrudRepository<Student,Integer> {
    @Query(value = """
            select * from student where Current_Year = :year
            """,nativeQuery = true)
    public Iterable<Student> findAllByYear(@Param("year") int year);

    @Query(value = """
            select * from student s where s.first_name = :first_name AND s.last_name= :last_name AND s.phone = :phone;
            """,nativeQuery = true)
    public Optional<Student> findByFirstNameLastNameAndPhone(@Param("first_name") String firstName,
                                                             @Param("last_name") String lastName,
                                                             @Param("phone") String phone);

    @Query(value = """
            select * from student where Aadhar_No = :aadharNo
            """,nativeQuery = true)
    public Optional<Student> findByAdhaar(@Param("aadharNo") String aadharNo);

    @Query(value = """
            select * from student where first_name=:firstname;
            """,nativeQuery = true)
    public Student getUserByUserName(String firstname);
}
