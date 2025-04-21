package com.uzma.example14.controller;


import com.uzma.example14.dto.StudentDto;
import com.uzma.example14.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// This @RestController makes this class accept request from client
@RestController
public class StudentController {

    static List<Student> myStudents=new LinkedList<>();
    static Random random=new Random();


    //  http://localhost:8080/student/all
    @GetMapping("/student/all")
    public ResponseEntity<List<StudentDto>> getPersonList() {
        List<StudentDto> studentDtos=new LinkedList<>();
        // Convert each Student object to StudentDto
       for (Student student:myStudents){
            StudentDto studentDto = new StudentDto();
            studentDto.setName(student.getName());
            studentDto.setAge(student.getAge());
            studentDto.setEmail(student.getEmail());
            studentDto.setCourse(student.getCourse());
            studentDtos.add(studentDto);
        }
        return new ResponseEntity<>(studentDtos, HttpStatus.OK);
    }


    //http://localhost8080/student/add
    @PostMapping("/student/add")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto){

        //object received of student dto class is received into variables
        String name  =studentDto.getName();
        String email  =studentDto.getEmail();
        Integer age  =studentDto.getAge();
        String course  =studentDto.getCourse();


        //Student Dto to student object conversion by setting values
        Student student=new Student();
        student.setName(name);
        student.setAge(age);
        student.setEmail(email);
        student.setCourse(course);
        //generate random Long for long type of Id and allocate to new student
        student.setId(random.nextLong(100,100000));

        //add our student object to linked list myStudent
        myStudents.add(student);

        return new ResponseEntity<>(studentDto, HttpStatus.CREATED);
    }


    //http://localhost:8080/student/delete/2
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<StudentDto> deleteStudentById(@PathVariable("id") Long id)
    {
        Student toDeleteStudent=null;
//        StudentDto studentDto=null;


        for (Student student : myStudents) {
            if (student.getId().equals(id)) {
                toDeleteStudent = student;
                break;
            }
        }

        if (toDeleteStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if student not found
        }

        StudentDto studentDto = new StudentDto();
        studentDto.setName(toDeleteStudent.getName());
        studentDto.setAge(toDeleteStudent.getAge());
        studentDto.setEmail(toDeleteStudent.getEmail());
        studentDto.setCourse(toDeleteStudent.getCourse());
        myStudents.remove(toDeleteStudent);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    //http://localhost:8080/student/get/cse
    @GetMapping("/student/get/{course}")
    public ResponseEntity<List<StudentDto>> findByCourseName(@PathVariable("course")String course)
    {
        List <StudentDto> courseStudents=new LinkedList<>();
        for(Student student:myStudents) {
            if (student.getCourse().equals(course)) {
                courseStudents.add(new StudentDto(student.getName(),
                        student.getAge(),
                        student.getEmail(),
                        student.getCourse()));
            }
        }
        if (courseStudents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content if no matches
        }
        return new  ResponseEntity<>(courseStudents, HttpStatus.OK);
    }





    //http://localhost:8080/student/get/2
    @DeleteMapping("/student/get/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id)
    {
        Student responseStudent=null;
        for (Student student : myStudents) {
            if (student.getId().equals(id)) {
                responseStudent = student;
                break;
            }
        }

        if (responseStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if student not found
        }

        StudentDto studentDto = new StudentDto();
        studentDto.setName(responseStudent.getName());
        studentDto.setAge(responseStudent.getAge());
        studentDto.setEmail(responseStudent.getEmail());
        studentDto.setCourse(responseStudent.getCourse());

        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @PutMapping("/student/update/{id}")
    public ResponseEntity<StudentDto> updateStudentById (@PathVariable("id") Long myId,
                                                         @RequestBody StudentDto studentDto){

       //to check if its still null after the loop.
        //if object memory is allocated using "= new student()" , the if condition
        // never becomes false so no error statement is executed
        Student updateStudent =null;

        for(Student student:myStudents) {
            if (student.getId().equals(myId)) {
                updateStudent = student;
                break;
            }
        }
        if (updateStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if student not found
        }
          Student student = new Student();
          student.setName(updateStudent.getName());
          student.setAge(updateStudent.getAge());
          student.setEmail(updateStudent.getEmail());
          student.setCourse(updateStudent.getCourse());


        return new ResponseEntity<>(studentDto, HttpStatus.OK);


    }



}
