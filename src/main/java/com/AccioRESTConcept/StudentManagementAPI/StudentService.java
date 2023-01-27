package com.AccioRESTConcept.StudentManagementAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service   // Service layer
public class StudentService
{
    @Autowired   // Inversion of Control
    StudentRepository studentRepository;    // Dependency Injection
    // here studentRepository is an reference object here
    // Since service layer talks to repository layer

    // To add student in repository layer Data base
    public String addStudentService(Student student)
    {
        return studentRepository.addStudent(student);
    }

    // To get the student
    public Student getStudentService(int enrollmentNo)
    {
        return studentRepository.getStudent(enrollmentNo);
    }

    // To delete student
    public String deleteStudentService(int enrollmentNo)
    {
        return studentRepository.deleteStudent(enrollmentNo);
    }

    // To update student
    public String updateStudentService(int enrollmentNo, int age)
    {
        return studentRepository.updateStudent(enrollmentNo, age);
    }
}
