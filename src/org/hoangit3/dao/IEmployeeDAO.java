package org.hoangit3.dao;

import org.hoangit3.model.Employee;

import java.util.List;

public interface IEmployeeDAO {
    List<Employee> findAll();

    Employee findOne(int eid);

    void update(Employee employee);

    void delete(int eid);

    int insert(Employee employee);
}
