package org.hoangit3;

import org.hoangit3.dao.IDepartmentDAO;
import org.hoangit3.dao.IEmployeeDAO;
import org.hoangit3.dao.impl.AbstractDAO;
import org.hoangit3.dao.impl.DepartmentDAO;
import org.hoangit3.dao.impl.EmployeeDAO;
import org.hoangit3.model.Department;
import org.hoangit3.model.Employee;
import org.hoangit3.service.IDepartmentService;
import org.hoangit3.service.IEmployeeService;
import org.hoangit3.service.impl.DepartmentService;
import org.hoangit3.service.impl.EmployeeService;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IEmployeeDAO employeeDAO = new EmployeeDAO();
        IDepartmentDAO departmentDAO = new DepartmentDAO();
        IEmployeeService employeeService = new EmployeeService(employeeDAO);
        IDepartmentService departmentService = new DepartmentService(departmentDAO);

        List<Employee> employees = employeeService.findAll();
        List<Department> departments = departmentService.findAll();
        employees.forEach(System.out::println);
        System.out.println("======================");
        departments.forEach(System.out::println);
    }
}
