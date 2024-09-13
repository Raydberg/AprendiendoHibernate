package com.practice.dao;

import com.practice.entities.Employee;
import com.practice.entities.EmployeeCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class EmployeeCriteriaTest {
    EmployeeDAO dao;

    @BeforeEach
    void setUp() {
        dao = new EmployeeDAOImpl();
    }

    @Test
    void findAllCriteria() {
        List<Employee> employees = dao.findAllCriteria();
        System.out.println(employees);
    }

    @Test
    void findAllIdCriteria() {
        Employee employee = dao.findByIdCriteria(1L);
        System.out.println(employee);
    }

    @Test
    void findByLastNameLikeCriteria() {
        List<Employee> employees = dao.findByLastNameLikeCriteria("Castro");
        System.out.println(employees);
    }

    @Test
    void findByAgeGreaterCriteria() {
        List<Employee> employees = dao.findByAgeGreaterCriteria(18);
        System.out.println(employees);
    }

    @Test
    void findByAgeBetweenCriteria() {
        List<Employee> employees = dao.findByAgeBetweenCriteria(18, 30);
        System.out.println(employees);
    }

    @Test
    void findByAgeBetweenCriteriaAndCategory() {
        List<Employee> employees = dao.findByAgeBetweenCriteriaAndCategory(18, 30, EmployeeCategory.ANALYST);
        System.out.println(employees);
    }
}