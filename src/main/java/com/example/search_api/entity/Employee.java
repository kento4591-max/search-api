package com.example.search_api.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private Integer id;   // 既存テーブルの主キーをそのまま使う場合

    private String name;

    @Column(name = "BIRTH_DATE")
    private LocalDate dob;

    @Column(name = "AFFILIATION")
    private String affiliation;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getAffiliation() { return affiliation; }
    public void setAffiliation(String affiliation) { this.affiliation = affiliation; }
}
