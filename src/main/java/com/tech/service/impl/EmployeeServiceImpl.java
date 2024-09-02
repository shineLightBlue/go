package com.tech.service.impl;

import com.tech.dto.EmployeeLoginDTO;
import com.tech.entity.Employee;
import com.tech.mapper.EmployeeMapper;
import com.tech.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();
        Employee employee = employeeMapper.getByUsername(username);
        return employee;
    }
}
