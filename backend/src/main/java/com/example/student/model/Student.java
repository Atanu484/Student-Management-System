package com.example.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//This is a similar to entity which will interact with the model
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
