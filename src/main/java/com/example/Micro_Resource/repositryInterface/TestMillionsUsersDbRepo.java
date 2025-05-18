package com.example.Micro_Resource.repositryInterface;

import com.example.Micro_Resource.DTO.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TestMillionsUsersDbRepo extends CrudRepository<User,Integer> {

    @Query(value = """
            SELECT * FROM users
            LIMIT 1000;
            
            """, nativeQuery = true)
    public Iterable<User> getFirstTenUsers();
}
