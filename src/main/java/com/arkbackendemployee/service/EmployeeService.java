package com.arkbackendemployee.service;

import com.arkbackendemployee.model.Employee;
import com.arkbackendemployee.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> getAllEmployees(){

        return employeeDao.findAll();
    }

    public Employee getEmployeeDetails(Long id){
        return employeeDao.getOne(id);
    }

    public void saveEmployee(Employee employee){

        employeeDao.save(employee);

    }

    public void deleteEmployeeDetails(Long id){

        employeeDao.deleteById(id);

    }
}
