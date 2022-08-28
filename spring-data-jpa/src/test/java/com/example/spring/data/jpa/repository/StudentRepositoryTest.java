package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Guardian;
import com.example.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Guard;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("nileshsinha1731@gmail.com")
                .firstName("Nilesh")
                .lastName("Sinha")
//                .guardianName("Nik")
//                .guardianEmail("niksh@gmail.com")
//                .guardianMobile("12456478639")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Aman")
                .email("aman@gmail.com")
                .mobile("9874561230")
                .build();

        Student student = Student.builder()
                .firstName("Shivam")
                .lastName("Singh")
                .emailId("shivamsingh@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Nilesh");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("ni");

        System.out.println("students char = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Nik");
        System.out.println("students guardian = " + students);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("nileshsinha1731@gmail.com");
        System.out.println("students email address = " + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("nileshsinha1731@gmail.com");
        System.out.println("student's first name = " + firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("shivamsingh@gmail.com");
        System.out.println("student email address native = " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNamedParam("shivamsingh@gmail.com");
        System.out.println("Student named param = " + student);
    }
}