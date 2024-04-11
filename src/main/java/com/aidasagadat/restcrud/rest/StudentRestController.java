package com.aidasagadat.restcrud.rest;

import com.aidasagadat.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;


    // define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Aida", "Sagadat"));
        students.add(new Student("Adiya", "Sagrsenbaeva"));
        students.add(new Student("Zhansulu", "Yensebaeva"));
    }


    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // check studentId against list size

        if((studentId >= students.size()) || studentId<0){
            throw new StudentNotFoundException("Student id " + studentId + " not found");
        }

        return students.get(studentId);
    }

}
