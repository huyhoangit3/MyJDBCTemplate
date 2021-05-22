package org.hoangit3.mapper.impl;

import org.hoangit3.mapper.RowMapper;
import org.hoangit3.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet) {
        Employee employee = new Employee();
        try {
            employee.setEid(resultSet.getInt("eid"));
            employee.seteName(resultSet.getString("ename"));
            employee.seteAddress(resultSet.getString("eaddress"));
            employee.setDid(resultSet.getInt("did"));
        } catch (SQLException throwables) {
            return null;
        }
        return employee;
    }
}
