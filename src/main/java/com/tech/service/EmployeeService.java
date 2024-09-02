package com.tech.service;

import com.tech.dto.EmployeeLoginDTO;
import com.tech.entity.Employee;

public interface EmployeeService {
    Employee login(EmployeeLoginDTO employeeLoginDTO);
}
