package com.example.xyz.Models;

import com.example.xyz.BranchName;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;
    private String name;
    private int marks;
    private BranchName branchName;

    @ManyToOne
    @JoinColumn
    private Branch branch;

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public BranchName getBranchName() {
        return branchName;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setBranchName(BranchName branchName) {
        this.branchName = branchName;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
