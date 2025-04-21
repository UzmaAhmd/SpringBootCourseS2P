package com.example15.App.services;


import com.example15.App.domain.StudentDetails;
import com.example15.App.repository.StudentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDetailsService
{
    @Autowired
    StudentDetailsRepository repository;


    // Save The Java StudentDetails Object Into Database table
    public StudentDetails save (StudentDetails studentDetails)
    {
        StudentDetails savedStudent =  repository.save(studentDetails);
        return savedStudent;
    }



    // Fetch all StudentDetails records from the database
    public List<StudentDetails> getListOfStudents()
    {
        // Returns all student_details records from database table in the form of list
        List<StudentDetails> studentDetailsList = repository.findAll();
        return studentDetailsList;
    }




    public StudentDetails getStudentById(Long studentId)
    {
        Optional<StudentDetails> studentDetailsOptional = repository.findById(studentId);

        StudentDetails data = null;

        if(studentDetailsOptional.isPresent())
        {
            data = studentDetailsOptional.get();
        }

        return data;
    }


    public void deleteStudent(Long id)
    {
        repository.deleteById(id);
    }




    public StudentDetails update(Long id, StudentDetails studentDetails)
    {

        // select * from student_details where id= 3;
        Optional<StudentDetails> studentOptional =  repository.findById(id);

        if(studentOptional.isPresent())
        {
            StudentDetails student = studentOptional.get();

            String newEmail = studentDetails.getEmail();
            student.setEmail(newEmail);

            String newFirstName = studentDetails.getFirstName();
            student.setFirstName(newFirstName);

            String newLastName = studentDetails.getLastName();
            student.setLastName(newLastName);

            student =  repository.save(student);
            return student;
        }

        return null;
    }

    public StudentDetails partialUpdate(Long id, StudentDetails studentBody)
    {
        Optional<StudentDetails> studentDetailsOptional = repository.findById(id);

        if(studentDetailsOptional.isPresent())
        {
            StudentDetails student = studentDetailsOptional.get();

            if(null != studentBody)
            {
                if(null != studentBody.getEmail())
                {
                    String email = studentBody.getEmail();
                    student.setEmail(email);
                }

                if(null != studentBody.getLastName())
                {
                    String lastName = studentBody.getLastName();
                    student.setLastName(lastName);
                }

                if(null != studentBody.getFirstName())
                {
                    String firstName = studentBody.getFirstName();
                    student.setFirstName(firstName);
                }

                StudentDetails savedStudent =  repository.save(student);
                return savedStudent;
            }
        }

        return  null;
    }


    public List<StudentDetails> saveAllStudentDetails(List<StudentDetails> studentDetailsList)
    {
        List<StudentDetails> result = null;

        if(null != studentDetailsList)
        {
            result = repository.saveAll(studentDetailsList);
        }

        return result;
    }






    public List<StudentDetails> getStudentByFirstName(String firstName) {
        return repository.findByFirstName(firstName);

    }


    public List<StudentDetails> getStudentByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }
}