package com.example.xyz.Models;

import com.example.xyz.BranchName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String contectNo;

    @Enumerated(value = EnumType.STRING)
    private BranchName branchName;

    @CreationTimestamp
    private Date branchCreationDate;
    private String HodName;

    @OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
    List<Student> studentList=new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private Grant grant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContectNo() {
        return contectNo;
    }

    public void setContectNo(String contectNo) {
        this.contectNo = contectNo;
    }

    public BranchName getBranchName() {
        return branchName;
    }

    public void setBranchName(BranchName branchName) {
        this.branchName = branchName;
    }

    public String getHodName() {
        return HodName;
    }

    public void setHodName(String hodName) {
        HodName = hodName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Grant getGrant() {
        return grant;
    }

    public void setGrant(Grant grant) {
        this.grant = grant;
    }

    public Date getBranchCreationDate() {
        return branchCreationDate;
    }
}
