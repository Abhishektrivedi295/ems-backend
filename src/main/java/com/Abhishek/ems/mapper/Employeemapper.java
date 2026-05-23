package com.Abhishek.ems.mapper;

import com.Abhishek.ems.dto.EmployeeDto;
import com.Abhishek.ems.entity.Employee;
public class Employeemapper {
  public static EmployeeDto mapToEmployeeDto(Employee employee){
     return new EmployeeDto(
        employee.getId(),
        employee.getFirstName(),
        employee.getLastName(),
        employee.getEmail()

     );
  }
  public static Employee mapToEmployee(EmployeeDto employeeDto){
    return new Employee(
        employeeDto.getId(),
        employeeDto.getFirstName(),
        employeeDto.getLastName(),
        employeeDto.getEmail()

    );
  }
}
