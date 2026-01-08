package com.example.Micro_Resource.CutomUserDetailsServicePackage;

import com.example.Micro_Resource.Entity.CustomUserDetials.CustomUserDetails;
import com.example.Micro_Resource.Entity.Members.Student;
import com.example.Micro_Resource.repositryInterface.StudentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private StudentRepositry customUserDeatilsServiceRepo;

    @Autowired
    public void setCustomUserDeatilsServiceRepo(StudentRepositry customUserDeatilsServiceRepo) {
        this.customUserDeatilsServiceRepo = customUserDeatilsServiceRepo;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student =  customUserDeatilsServiceRepo.getUserByUserName(username);
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.setUsername(student.getPhone());
        userDetails.setPassword(student.getPasswordHash());
        // set all of scope to grantedAuthorities
        return userDetails;
    }
}
