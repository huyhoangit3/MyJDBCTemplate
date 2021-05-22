package org.hoangit3.service;

import org.hoangit3.model.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll();

    Department findOne(int did);

    void update(Department department);

    void delete(int did);

    int insert(Department department);
}
