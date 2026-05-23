package com.Abhishek.ems.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Abhishek.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
