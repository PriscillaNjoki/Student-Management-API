package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class studentsservice {
private final StudentRepository StudentRepository;
@Autowired
    public studentsservice(com.example.demo.student.StudentRepository studentRepository) {
        StudentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return StudentRepository.findAll();

    }

    public void addNewstudent(Student student) {
    Optional<Student> studentoptional= StudentRepository
            .findStudentByEmail(student.getEmail());
    if (studentoptional.isPresent()){
        throw new IllegalStateException("email already taken");
    }

    StudentRepository.save(student);
    }

    public void deleteStudent(long studentId) {
    boolean exists =StudentRepository.existsById(studentId);
    if (!exists){
        throw new IllegalStateException(
                "student with id" + studentId   +"does not exists");
    }StudentRepository.deleteById(studentId);

    }
@Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
    Student student = StudentRepository
            .findById(studentId).orElseThrow(() -> new IllegalStateException(
            "student with Id " + studentId + " does not exist"));

    if (name != null &&
            name.length() > 0 &&
            !Objects.equals(student.getName(), name)) {
        student.setName(name);
    }
    if (email != null &&
            email.length() > 0 &&
            !Objects.equals(student.getEmail(), email)) {
        student.setEmail(email);

    }
}}
