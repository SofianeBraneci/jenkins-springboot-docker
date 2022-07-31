package com.springlearning.SpringBootReveiw.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private  final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    public List<Student> getStudents(){return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentEmail.isPresent()) throw new IllegalStateException("Email already exists");
        studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        boolean exists = studentRepository.existsById(id);
        if(!exists) throw new IllegalStateException("Student not present");
        studentRepository.deleteById(id);
    }

    public void updateStudentEmail(Long id, String newEmail){

        Optional<Student> exist = studentRepository.findById(id);
        if(! exist.isPresent()) throw new IllegalStateException("Student does not exists");
        Student current = exist.get();
        current.setEmail(newEmail);
        studentRepository.save(current);


    }
}
