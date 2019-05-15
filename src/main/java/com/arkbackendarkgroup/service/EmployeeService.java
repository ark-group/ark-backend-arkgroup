package com.arkbackendarkgroup.service;

import com.arkbackendarkgroup.model.Employee;
import com.arkbackendarkgroup.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
