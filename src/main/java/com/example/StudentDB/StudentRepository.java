package com.example.StudentDB;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {


    HashMap<String,Student> studentDb=new HashMap<>();  //HashMap for Storing Student with name as key.

    HashMap<String,Teacher> teacherDb=new HashMap<>();  //HashMap for Storing Teacher with name as key.

    HashMap<String,List<String>> teacherStudentPair=new HashMap<>();  //HashMap for Storing Teacher's Students with TeacherName as Key and value as list of Students names.

    public void addStudentToDb(Student student){
        String name=student.getName();
        studentDb.put(name,student); //Student added to the HashMap.
    }

    public Student getStudentFromDb(String name){
        return studentDb.getOrDefault(name,null); //getting Student from HashMap.
    }

    public void addTeacherToDb(Teacher teacher){
        String name=teacher.getName();
        teacherDb.put(name,teacher);  //Teacher added to the HashMap.
    }

    public Teacher getTeacherFromDb(String name){
        return teacherDb.getOrDefault(name,null);  //getting Teacher from HashMap.
    }

    public void addStudentTeacherPairToDb(String studentName, String teacherName) {
        if (studentDb.containsKey(studentName) && teacherDb.containsKey(teacherName)) { //If Student And Teacher Exist in HashMap Pair them.
            if (teacherStudentPair.containsKey(teacherName)) {
                teacherStudentPair.get(teacherName).add(studentName);
            } else {
                List<String> list = new ArrayList<>();
                list.add(studentName);
                teacherStudentPair.put(teacherName, list);
            }

        }
    }

    public List<String> getStudentsByTeacherNameFromDb(String teacherName) {
        List<String> student = new ArrayList<>();
        if (teacherStudentPair.containsKey(teacherName)) {  //return Student Names for a particular Teacher.

            student = teacherStudentPair.get(teacherName);
        }
        return student;
    }








}
