package org.hoangit3.dao.impl;

import org.hoangit3.dao.IDepartmentDAO;
import org.hoangit3.mapper.impl.DepartmentMapper;
import org.hoangit3.model.Department;

import java.util.List;

public class DepartmentDAO extends AbstractDAO<Department> implements IDepartmentDAO {
    @Override
    public Department findOne(int did) {
        String sqlQuery = "SELECT * FROM department WHERE did=?";
        List<Department> result = super.query(sqlQuery, new DepartmentMapper(), did);
        return !result.isEmpty() ? result.get(0) : null;
    }

    @Override
    public void update(Department department) {
        String sqlQuery = "UPDATE department SET dname=? WHERE did=?";
        super.update(sqlQuery, department.getdName(), department.getDid());
    }

    @Override
    public void delete(int did) {
        String sqlQuery = "DELETE FROM WHERE did=?";
        super.update(sqlQuery, did);
    }

    @Override
    public int insert(Department department) {
        String sqlQuery = "INSERT INTO department(dname) VALUES(?)";
        return super.save(sqlQuery, department.getdName());
    }

    @Override
    public List<Department> findAll() {
        String sqlQuery = "SELECT * FROM department";
        return super.query(sqlQuery, new DepartmentMapper());
    }
}
