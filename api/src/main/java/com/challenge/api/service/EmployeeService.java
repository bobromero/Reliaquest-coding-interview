package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.repository.EmployeeRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(UUID uuid) {

        return employeeRepository.getEmployeeByUUID(uuid);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }
}
