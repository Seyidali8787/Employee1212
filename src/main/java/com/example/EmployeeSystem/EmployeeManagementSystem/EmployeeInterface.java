package com.example.EmployeeSystem.EmployeeManagementSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeInterface extends JpaRepository<Employee,Long> {
    @Query(value = "select * from Employee where id=?1",nativeQuery = true)
    public List<Employee> search(@Param("keword") Long keyword);
}
