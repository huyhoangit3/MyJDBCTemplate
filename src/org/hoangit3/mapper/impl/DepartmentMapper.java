package org.hoangit3.mapper.impl;

import org.hoangit3.mapper.RowMapper;
import org.hoangit3.model.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper implements RowMapper<Department> {
    @Override
    public Department mapRow(ResultSet resultSet) {
        Department department = new Department();
        try {
            department.setDid(resultSet.getInt("did"));
            department.setdName(resultSet.getString("dname"));
        } catch (SQLException throwables) {
            return null;
        }
        return department;
    }
}
