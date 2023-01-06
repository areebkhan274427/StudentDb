package com.example.StudentDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("add_student")
    public ResponseEntity<String> addStudent(@RequestBody()Student student){
        studentService.addStudentService(student);
        return new ResponseEntity<>("Student Added", HttpStatus.OK);
    }

    @GetMapping("get_student")
    public ResponseEntity<Student> getStudent(@RequestParam("name")String name){
        Student student=studentService.getStudentService(name);
        if(student==null){    //Student not Exist
            return new ResponseEntity<>(student,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(student,HttpStatus.FOUND);
    }

    @PostMapping("add_teacher")
    public ResponseEntity<String> addTeacher(@RequestBody()Teacher teacher){
        studentService.addTeacherService(teacher);
        return new ResponseEntity<>("Teacher Added",HttpStatus.OK);
    }

    @GetMapping("get_teacher")
    public ResponseEntity<Teacher> getTeacher(@RequestParam("name")String name){
        Teacher teacher=studentService.getTeacherService(name);
        if(teacher==null){  //Teacher Not Found
            return new ResponseEntity<>(teacher,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(teacher,HttpStatus.FOUND);
    }

    @PutMapping("/add_students_teacher_pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam String student, @RequestParam String teacher){
        studentService.addStudentTeacherPairService(student,teacher);
        return new ResponseEntity<>("student-teacher pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get_students_by_teacher_name")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@RequestParam("name") String teacher){
        List<String> students = studentService.getStudentsByTeacherNameService(teacher); // Assign list of student by calling service layer method

        return new ResponseEntity<>(students, HttpStatus.FOUND);
    }





}
