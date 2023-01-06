package com.example.StudentDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudentService(Student student){
        studentRepository.addStudentToDb(student);
    }

    public Student getStudentService(String name){
        return studentRepository.getStudentFromDb(name);
    }

    public void addTeacherService(Teacher teacher){
        studentRepository.addTeacherToDb(teacher);
    }

    public Teacher getTeacherService(String name){
        return studentRepository.getTeacherFromDb(name);
    }

    public void addStudentTeacherPairService(String studentName,String teacherName){
        studentRepository.addStudentTeacherPairToDb(studentName,teacherName);
    }

    public List<String> getStudentsByTeacherNameService(String teacherName){
        return studentRepository.getStudentsByTeacherNameFromDb(teacherName);
    }


}
