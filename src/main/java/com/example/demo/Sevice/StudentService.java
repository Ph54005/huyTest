package com.example.demo.Sevice;

import com.example.demo.Entity.Student;

import com.example.demo.Repository.StudentV2repo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentV2repo studentV2repo;

    public StudentService(StudentV2repo studentV2repo) {
        this.studentV2repo = studentV2repo;
    }

    public List<Student> getAll() {
        return studentV2repo.findAll();
    }

    public void delete(long id) {
        studentV2repo.deleteById(id);
    }

    public void add(Student s) {
        studentV2repo.save(s);
    }

    public void update(Student s) {
        studentV2repo.save(s);
    }

    public Student getOne(long id) {
        return studentV2repo.findById(id).orElse(null);
    }
    public Student getOne1(long id) {
        return studentV2repo.findById(id).orElse(null);
    }
    public Student getOne2(long id) {
        return studentV2repo.findById(id).orElse(null);
    }
//    public List<Student> seachTen(String ten){
//        return studentV2repo.findbyTen(ten);
//
//    }


}
