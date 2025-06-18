package org.example.studentform.service;

import org.example.studentform.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private final Map<Integer,Student> students;
    private static int cid = 4;


    public StudentService(){

        students = new HashMap<>();

        Student student1 = Student.builder().id(1).lastname("LUONG").firstname("Tony").age(29).mail("tony.luong59@yahoo.com").build();
        Student student2 = Student.builder().id(2).lastname("DOE").firstname("John").age(25).mail("notjohn00@hotmail.com").build();
        Student student3 = Student.builder().id(3).lastname("BURGER").firstname("Karen").age(20).mail("ilovemcdonalds@gmail.com").build();
        this.students.put(student1.getId(),student1);
        this.students.put(student2.getId(),student2);
        this.students.put(student3.getId(),student3);

    }

    public void create(Student student) {

        student.setId(cid);
        this.students.put(cid,student);
        cid++;
    }

    public List<Student> get_all(){
        return students.values().stream().toList();
    }

    public Student get_by_id(int id){
        return this.students.get(id);
    }

    public List<Student> search_names(String name){
        List<Student> results = new ArrayList<>();
        name = name.toLowerCase();
        for(Student s : students.values()) {
            if (s.getFirstname().toLowerCase().contains(name) || s.getLastname().toLowerCase().contains(name)) {
                results.add(s);
            }
        }
        return results;
    }

    public void update(int id, String lastname, String firstname, int age, String mail){
        Student student_updated = Student.builder().id(id).lastname(lastname).firstname(firstname).age(age).mail(mail).build();
        this.students.put(id,student_updated);
    }

    public void delete(int id){
        this.students.remove(id);
    }



/*
    public List<Student> search_name_and_minAge(String name, int minAge){
        List<Student> results = new ArrayList<>();
        for(Student s : students.values()){
            if (s.getAge() > minAge && s.getFirstname().contains(name)){
                results.add(s);
            }

        }
        return results;
    } */


}



