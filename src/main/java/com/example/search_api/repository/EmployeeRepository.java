package com.example.search_api.repository;

import com.example.search_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // 既存のメソッドは不要になるので削除してもOK
    // List<Employee> findByName(String name);
    // List<Employee> findByDob(String dob);
    // List<Employee> findByAffiliation(String affiliation);

    @Query("SELECT e FROM Employee e WHERE "
         + "(:name IS NULL OR e.name = :name) AND "
         + "(:dob IS NULL OR e.dob = :dob) AND "
         + "(:affiliation IS NULL OR e.affiliation = :affiliation)")
    List<Employee> search(@Param("name") String name,
                          @Param("dob") LocalDate dob,
                          @Param("affiliation") String affiliation);
}
