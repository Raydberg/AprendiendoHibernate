package com.practice.relationships;

import com.practice.dao.EmployeeDAO;
import com.practice.dao.EmployeeDAOImpl;
import com.practice.entities.Employee;
import com.practice.entities.Project;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ManyToManyTest {
    @Test
    void manyToManyTest() {
        Project project1 = new Project(null, "Project X 1", LocalDate.now());
        Project project2 = new Project(null, "Project X 2", LocalDate.now());
        Employee employee = new Employee(null,
                "Empleado many to many",
                "Pedro",
                "ManyToMany@gmail",
                32,
                4000d,
                true,
                LocalDate.of(1999, 1, 1),
                LocalDateTime.now()
        );
        employee.getProjects().add(project1);
        employee.getProjects().add(project2);
        EmployeeDAO dao = new EmployeeDAOImpl();
        dao.create(employee);
    }
}
