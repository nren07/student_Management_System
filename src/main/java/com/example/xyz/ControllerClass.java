package com.example.xyz;

import com.example.xyz.Models.Branch;
import com.example.xyz.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class ControllerClass {
    @Autowired
    private ServiceClass serviceClass;

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
         return serviceClass.addStudent(student);
    }

    @PostMapping("addBranch")
    public String addBranch(@RequestBody Branch branch){
        return serviceClass.addBranch(branch);
    }
    @GetMapping("/getList")
    public List<String> getListHod(){
        return serviceClass.getListHod();
    }

    @GetMapping("/getListStudentRollNo")
    public List<Integer> getListStudent(){
        return serviceClass.getListStudent();
    }


}
