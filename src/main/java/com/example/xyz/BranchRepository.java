package com.example.xyz;

import com.example.xyz.Models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BranchRepository extends JpaRepository<Branch,Integer> {

    @Query(value = "select id from branch where branchName=:branchName",nativeQuery = true)
    Integer findId(BranchName branchName);
}
