package com.aidasagadat.restcrud.rest;

import com.aidasagadat.restcrud.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> students = new ArrayList<>();
        students.add(new Student("Aida", "Sagadat"));
        students.add(new Student("Adiya", "Sagrsenbaeva"));
        students.add(new Student("Zhansulu", "Yensebaeva"));

        return students;
    }

}
