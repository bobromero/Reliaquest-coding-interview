package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();

    public EmployeeService() {}

    public List<Employee> getEmployees() {
        return employees; // replace with api call to old system or repository
    }

    public Employee getEmployeeById(UUID uuid) {
        for (Employee employee : getEmployees()) {
            if (employee.getUuid().equals(uuid)) {
                return employee;
            }
        }
        return null;
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }
}
