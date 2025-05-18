package com.example.Micro_Resource.controller;

import com.example.Micro_Resource.DTO.User;
import com.example.Micro_Resource.service.UserDbCRUDRepositryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/test")
public class TestOneEndpoint {

    @Autowired
    private UserDbCRUDRepositryService crudRepositryService;


    @CrossOrigin(origins = "*")
    @PostMapping("/post")
    public String testPostForCorcs( @RequestBody(required = false) Integer id){
        return "thank you and your ID is "+ id;
    }

    @GetMapping("/get")
    public ResponseEntity<User> testGetForCorcs(@RequestParam(required = false , value = "id") Integer id){
        if ( id != null) {
            User user = crudRepositryService.getUserById(id);
            ResponseEntity responseEntity = ResponseEntity.ok(user);
            return responseEntity;
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/default")
    public ResponseEntity<? extends List<User>> getFirstTenUsers(){
            List<User> list = crudRepositryService.getFirstTenUsers();
            return ResponseEntity.ok(list);

    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
       return ResponseEntity.ok(crudRepositryService.saveUserToDataBase(user));
    }
}
