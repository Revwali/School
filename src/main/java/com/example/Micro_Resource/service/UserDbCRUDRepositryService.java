package com.example.Micro_Resource.service;

import com.example.Micro_Resource.Entity.User;
import com.example.Micro_Resource.repositryInterface.TestMillionsUsersDbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserDbCRUDRepositryService {

    @Autowired
    private TestMillionsUsersDbRepo crudUserRepo;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserById(int id){
        try{
       Optional<User> optionalUser = crudUserRepo.findById(id);
         return optionalUser.orElse(new User());
        } catch (Exception e) {
            System.out.println("somrthing is wrong "+ e.getMessage());
            throw new RuntimeException();
        }
        finally {
            // nothing
        }
    }

    public List<User> getFirstTenUsers(){
        try {


            Iterable<User> iterable = crudUserRepo.getFirstTenUsers();
            List<User> list = new ArrayList<>();
            iterable.forEach(user -> list.add(user));
            return Collections.unmodifiableList(list);
        }catch (Exception e){
            System.out.println("something went wrong");
        }
        return Collections.emptyList();

    }

    public User saveUserToDataBase(User user){
        User returnUser = null;
       try {
            user.setPassword( passwordEncoder.encode(user.getPassword()) );
            user.setCreated_at(LocalDateTime.now());
        returnUser = crudUserRepo.save(user);
        return  returnUser;
       } catch (Exception e) {
           System.out.println(e.getMessage()+" something went wrong");
           return returnUser;
       }
       finally {
           // nothing
       }
    }
}
