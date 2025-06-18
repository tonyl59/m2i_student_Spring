package org.example.studentform.controller;

import org.example.studentform.entity.Student;
import org.example.studentform.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/")
    public String homePage(){return "homepage";}

    @GetMapping("/students")
    public String list(Model model) {
        List<Student> students = studentService.get_all();
        model.addAttribute("students",students);
        return "listpage";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model){
        Student student = studentService.get_by_id(id);
        model.addAttribute(student);
        return "detailpage";
    }




}
