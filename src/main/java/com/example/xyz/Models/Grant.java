package com.example.xyz.Models;

import com.example.xyz.BranchName;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BranchName branchName;
    private int grantAmount;

    @OneToMany(mappedBy = "grant",cascade = CascadeType.ALL)
    private List<Branch>branches=new ArrayList<>();
}
