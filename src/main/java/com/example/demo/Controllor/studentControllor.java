package com.example.demo.Controllor;

import com.example.demo.Entity.Student;
import com.example.demo.Sevice.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class studentControllor {
    private final StudentService repo;

    public studentControllor(StudentService repo) {
        this.repo = repo;
    }

    @GetMapping("/student")
    public String Show(Model model){
        Student st = new Student();
        model.addAttribute("student",st);
        List<Student> list = repo.getAll();
        model.addAttribute("list",list);
        return "view/studentView";
    }
    @GetMapping("/student/delete/{id}")
    public String delete(@PathVariable("id") long id){
        repo.delete(id);
        return "redirect:/student";

    }
    @GetMapping("/student/detail/{id}")
    public String detail(@PathVariable("id") long id, Model model){
        Student st = repo.getOne(id);
        model.addAttribute("student",st);
        List<Student> list = repo.getAll();
        model.addAttribute("list",list);
        return "view/studentView";

    }
    @PostMapping("/student/add")
    public String add(@ModelAttribute("student") Student s){
        repo.add(s);
        return "redirect:/student";

    }
    @PostMapping("/student/update")
    public String update(@ModelAttribute("student") Student s){
        repo.update(s);
        return "redirect:/student";

    }


}
