package com.challenge.api.repository;

import com.challenge.api.model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class InMemoryEmployeeRepository implements EmployeeRepository {
    List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeByUUID(UUID id) {
        for (Employee employee : employees) {
            if (employee.getUuid().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }
}
