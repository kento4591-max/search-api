package com.example.search_api.controller;

import com.example.search_api.entity.Employee;
import com.example.search_api.repository.EmployeeRepository;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class SearchController {

    private final EmployeeRepository repository;

    public SearchController(EmployeeRepository repository) {
        this.repository = repository;
    }

    private String normalize(String param) {
        return (param != null && param.isEmpty()) ? null : param;
    }

    @GetMapping("/search")
    public List<Employee> search(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) 
        @DateTimeFormat(pattern = "yyyy/MM/dd") LocalDate dob,
        @RequestParam(required = false) String affiliation
    ){
        System.out.println("name=" + normalize(name));
        System.out.println("dob=" + dob);
        System.out.println("affiliation=" + normalize(affiliation));
        return repository.search(normalize(name), dob, normalize(affiliation));
    }
}
