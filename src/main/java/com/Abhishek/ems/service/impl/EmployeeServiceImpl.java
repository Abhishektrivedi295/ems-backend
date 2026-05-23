package com.Abhishek.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Abhishek.ems.dto.EmployeeDto;
import com.Abhishek.ems.entity.Employee;
import com.Abhishek.ems.exception.ResourceNotFoundException;
import com.Abhishek.ems.mapper.Employeemapper;
import com.Abhishek.ems.repository.EmployeeRepository;
import com.Abhishek.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // TODO Auto-generated method stub
        Employee employee = Employeemapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return Employeemapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        // TODO Auto-generated method stub
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
        return Employeemapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        // TODO Auto-generated method stub
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> Employeemapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        // TODO Auto-generated method stub
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return Employeemapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        // TODO Auto-generated method stub
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
        employeeRepository.deleteById(employeeId);
    }

}
