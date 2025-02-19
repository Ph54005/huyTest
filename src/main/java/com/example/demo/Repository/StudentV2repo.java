package com.example.demo.Repository;

import com.example.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentV2repo extends JpaRepository<Student,Long> {
//List<Student>findbyTen(String ten);
   List<Student>findByNameContaining(String name);
   @Query("select s from Student s where s.name=?1  Or s.id=?2")
   List<Student>findByNameorID(String name,long id2);

}
