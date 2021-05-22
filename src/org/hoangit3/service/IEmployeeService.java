package org.hoangit3.service;

import org.hoangit3.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Employee findOne(int eid);

    void update(Employee employee);

    void delete(int eid);

    int insert(Employee employee);
}
