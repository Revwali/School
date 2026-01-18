package com.example.Micro_Resource.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected LocalDate dob;
    protected String parentsFirstName;
    protected String parentsLastName;
    protected String aadharNo;
    protected String email;
    protected boolean is_associate;


}
