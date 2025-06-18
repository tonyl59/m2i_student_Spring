package org.example.studentform.controller;

import org.example.studentform.entity.Student;
import org.example.studentform.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/")
    public String homePage(){return "homepage";}

    @GetMapping("/students")
    public String list(@RequestParam(name ="search", required = false) String search, Model model) {
        if (search == null){
            model.addAttribute("students",studentService.get_all());
        }else{
            model.addAttribute("students",studentService.search_names(search));
        }
        return "listpage";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model){
        Student student = studentService.get_by_id(id);
        model.addAttribute(student);
        return "detailpage";
    }
    @GetMapping("/signup")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "signuppage";
    }
    @PostMapping("/add")
    public String submitStudent(@ModelAttribute("student") Student student){
        studentService.create(student);
        return "redirect:/signup";
    }
}


