package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/Student")

public class Studentcontroller {
    private final studentsservice studentsservice;
    @Autowired

    public Studentcontroller(com.example.demo.student.studentsservice studentsservice) {
        this.studentsservice = studentsservice;
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentsservice.getStudents();
    }
    @PostMapping
    public void registerNewstudents(
                @RequestBody Student student) {
                studentsservice.addNewstudent(student);
        }

        @DeleteMapping("{studentId}")
        public void deleteStudent(
                @PathVariable("studentId")Long studentId){
        studentsservice.deleteStudent(studentId);
        }
        @PutMapping("{studentId}")
        public void updateStudent(
                @PathVariable("studentId") Long studentId,
                @RequestParam(required = false) String name,
                @RequestParam(required = false) String email){
        studentsservice.updateStudent(studentId, name, email);
        }


}
