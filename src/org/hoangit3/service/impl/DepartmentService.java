package org.hoangit3.service.impl;

import org.hoangit3.dao.IDepartmentDAO;
import org.hoangit3.model.Department;
import org.hoangit3.service.IDepartmentService;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    private final IDepartmentDAO departmentDAO;

    public DepartmentService(IDepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    public List<Department> findAll() {
        return departmentDAO.findAll();
    }

    @Override
    public Department findOne(int did) {
        return departmentDAO.findOne(did);
    }

    @Override
    public void update(Department department) {
        departmentDAO.update(department);
    }

    @Override
    public void delete(int did) {
        departmentDAO.delete(did);
    }

    @Override
    public int insert(Department department) {
        return departmentDAO.insert(department);
    }
}
