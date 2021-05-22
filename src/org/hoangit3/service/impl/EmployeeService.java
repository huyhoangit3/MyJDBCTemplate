package org.hoangit3.service.impl;

import org.hoangit3.dao.IEmployeeDAO;
import org.hoangit3.model.Employee;
import org.hoangit3.service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeDAO employeeDAO;

    public EmployeeService(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findOne(int eid) {
        return employeeDAO.findOne(eid);
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public void delete(int eid) {
        employeeDAO.delete(eid);
    }

    @Override
    public int insert(Employee employee) {
        return employeeDAO.insert(employee);
    }
}
