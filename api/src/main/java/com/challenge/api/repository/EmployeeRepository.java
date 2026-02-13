package com.challenge.api.repository;

import com.challenge.api.model.Employee;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository {
    List<Employee> getAllEmployees();

    Employee getEmployeeByUUID(UUID id);

    Employee addEmployee(Employee employee);
}
