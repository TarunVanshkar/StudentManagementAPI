package com.AccioRESTConcept.StudentManagementAPI;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository   // Reposiory layer
public class StudentRepository
{
    Map<Integer, Student> db=new HashMap<>();      // HshMap to store a data and used as DataBase--> primary key=enrollmentNo

    // Logic to add student in Data base
    public String addStudent(Student student)
    {
        int enrollmentNo=student.getEnrollmentNo();
        db.put(enrollmentNo, student);
        return "Student added successfully";
    }

    // logic to get information
    public Student getStudent(int enrollmentNo)
    {
        return db.get(enrollmentNo);
    }

    // logic to delete data
    public String deleteStudent(int enrollmentNo)
    {
        if(!db.containsKey(enrollmentNo))
        {
            return "Invalid Enrollment Number";
        }

        db.remove(enrollmentNo);
        return "Student deleted successfully";
    }

    // logic to update data in non primitive data type(reference)
    public String updateStudent(int enrollmentNo, int age)
    {
        if(!db.containsKey(enrollmentNo))
        {
            return "Invalid Enrollment Number";
        }

        db.get(enrollmentNo).setAge(age);
        return "Data updated successfully";
    }
}
