package org.example.studentform.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    private int id;
    private String lastname;
    private String firstname;
    private int age;
    private String mail;



}
