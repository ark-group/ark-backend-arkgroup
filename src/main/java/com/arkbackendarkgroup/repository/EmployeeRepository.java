package com.arkbackendarkgroup.repository;

import com.arkbackendarkgroup.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository <Employee,Long> {


}
