package com.example.xyz;

import com.example.xyz.Models.Branch;
import com.example.xyz.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceClass {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BranchRepository branchRepository;

    public String addStudent(Student student){
        BranchName branchName=student.getBranchName();
        int id=branchRepository.findId(branchName);
        Branch branch=branchRepository.findById(id).get();
        student.setBranch(branch);
        branch.getStudentList().add(student);
        branchRepository.save(branch);
        return "Student saved";
    }

    public String addBranch(Branch branch){
        branchRepository.save(branch);
        return "branch Saved successfully";
    }
    public int maxMax(){
        List<Branch> branchList=branchRepository.findAll();
        int max=Integer.MIN_VALUE;
        for(Branch branch: branchList){
            for(Student student : branch.getStudentList()){
                if(student.getMarks()>=max){
                    max=student.getMarks();
                }
            }
        }
        return max;
    }
    public List<String> getListHod(){
        List<Branch> branchList=branchRepository.findAll();
        List<String>hodList=new ArrayList<>();
        int max=maxMax();
        for(Branch branch: branchList){
            for(Student student : branch.getStudentList()){
                if(student.getMarks()>=max){
                    hodList.add(branch.getContectNo());
                    break;
                }
            }
        }
        return hodList;
    }

    public Branch findLatestBranch(){
        List<Branch> branchList=branchRepository.findAll();
        Collections.sort(branchList, new Comparator<Branch>() {
            public int compare(Branch o1, Branch o2) {
                return o2.getBranchCreationDate().compareTo(o1.getBranchCreationDate());
            }
        });
        return branchList.get(0);
    }

    public List<Integer> getListStudent(){
        List<Branch> branchList=branchRepository.findAll();
        List<Integer>rollNoList=new ArrayList<>();
        Branch latestBranch=findLatestBranch();

       for(Student student: latestBranch.getStudentList()){
           rollNoList.add(student.getRollNo());
       }
       return rollNoList;
    }
}
