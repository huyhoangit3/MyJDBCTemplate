package org.hoangit3.dao.impl;

import org.hoangit3.dao.IEmployeeDAO;
import org.hoangit3.mapper.impl.DepartmentMapper;
import org.hoangit3.mapper.impl.EmployeeMapper;
import org.hoangit3.model.Department;
import org.hoangit3.model.Employee;

import java.util.List;

public class EmployeeDAO extends AbstractDAO<Employee> implements IEmployeeDAO {
    @Override
    public Employee findOne(int eid) {
        String sqlQuery = "SELECT * FROM employee WHERE eid=?";
        List<Employee> result = super.query(sqlQuery, new EmployeeMapper(), eid);
        return !result.isEmpty() ? result.get(0) : null;
    }

    @Override
    public void update(Employee employee) {
        String sqlQuery = "UPDATE employee SET ename=?, eaddress=?, did=? WHERE eid=?";
        super.update(sqlQuery, employee.geteName(), employee.geteAddress(),
                employee.getDid(), employee.getEid());
    }

    @Override
    public void delete(int eid) {
        String sqlQuery = "DELETE FROM employee WHERE eid=?";
        super.update(sqlQuery, eid);
    }

    @Override
    public int insert(Employee employee) {
        String sqlQuery = "INSERT INTO employee(ename,eaddress,did) VALUES(?,?,?)";
        return super.save(sqlQuery, employee.geteName(), employee.geteAddress(), employee.getDid());
    }

    @Override
    public List<Employee> findAll() {
        String sqlQuery = "SELECT * FROM employee";
        return super.query(sqlQuery, new EmployeeMapper());
    }
}
