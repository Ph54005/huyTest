package com.example.demo;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentV2repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    private final StudentV2repo studentV2repo;

    public DemoApplication(StudentV2repo studentV2repo) {
        this.studentV2repo = studentV2repo;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("running....");
    }

    @Override
    public void run(String... args) throws Exception {
        studentV2repo.findByNameContaining("Student 1").forEach(student -> System.out.println(student.getName()));

        int pageNo = 0;
        int pageSize = 2;
        //creating pageOject
        //spring framwork
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Student> page = studentV2repo.findAll(pageable);
        List<Student>students= page.getContent();
        students.forEach(student -> System.out.println(student.getName()));
        int tortalPage = page.getTotalPages();// tong cong bao nhieu trang
        System.out.println(tortalPage);
        long totalElement = page.getTotalElements();
        System.out.println(totalElement);



        // sorting
        String sortBy = "name";
        String sortDir = "desc";
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy) : Sort.by(sortBy).descending();
        studentV2repo.findAll(sort).forEach(s -> System.out.println(s.getName()));


        Sort.by("name").descending().and(Sort.by("email").descending());
        // ket hop phan trang va sort

        studentV2repo.findAll(PageRequest.of(pageNo,pageSize,sort)).forEach(s -> System.out.println(s.getName()));
    }
}
