package com.AccioRESTConcept.StudentManagementAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController         // Always write this annotation before a class which will become logic of API
public class StudentController
{
    @Autowired    // Inversion of Control
    StudentService studentService;       // Dependency Injection
    // here studentService is an reference object here
    // because controller layer talks to service layer


    // we should have CRUD in basic API
    // ResponseEntity<>(first_parameter, second_parameter)  is a class which return pair of data having origin response and http status code


    // adding the information
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student)
    {
        String response=studentService.addStudentService(student);    // First parameter to be passed in ResponseEntity
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // API logic to get information
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("q") int enrollmentNo)
    {
        Student student=studentService.getStudentService(enrollmentNo);
        return new ResponseEntity<>(student, HttpStatus.FOUND);    // returning object of ResponseEntity class
    }

    // API logic to delete data
    @DeleteMapping("/delete_student/{id}")    // path variable -->endpoint
    public ResponseEntity deleteStudent(@PathVariable("id") int enrollmentNo)
    {
        String response=studentService.deleteStudentService(enrollmentNo);
        if(response.equals("Invalid Enrollment Number"))
        {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    // API logic to update data in non primitive data type(reference)
    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("id") int enrollmentNo,@RequestParam("age") int age)     // we wanted to updated age
    {
        String response=studentService.updateStudentService(enrollmentNo, age);
        if(response.equals("Invalid Enrollment Number"))
        {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        //return new ResponseEntity<>("Updated", HttpStatus.CREATED);
        //                      OR
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
