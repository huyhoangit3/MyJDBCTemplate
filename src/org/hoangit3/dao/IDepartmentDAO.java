package org.hoangit3.dao;

import org.hoangit3.model.Department;

import java.util.List;

public interface IDepartmentDAO {
    List<Department> findAll();

    Department findOne(int did);

    void update(Department department);

    void delete(int did);

    int insert(Department department);
}
