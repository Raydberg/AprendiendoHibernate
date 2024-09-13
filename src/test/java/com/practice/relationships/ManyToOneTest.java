package com.practice.relationships;

import com.practice.dao.EmployeeDAO;
import com.practice.dao.EmployeeDAOImpl;
import com.practice.entities.Company;
import com.practice.entities.Employee;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ManyToOneTest {

    @Test
    void manyToOneTest() {
        Employee employee1 = new Employee(null,
                "Empleado many to one 1",
                "Rodriguez",
                "ManyToOne1@gmail",
                32,
                4000d,
                true,
                LocalDate.of(1999, 1, 1),
                LocalDateTime.now()
        );
         Employee employee2 = new Employee(null,
                "Empleado many to one 2",
                "Pedro",
                "ManyToOne2@gmail",
                32,
                4000d,
                true,
                LocalDate.of(1999, 1, 1),
                LocalDateTime.now()
        );

        Company company = new Company(null,"125478","COSMIC LEGACY",8945.5d,2023);
        employee1.setCompany(company);
        employee2.setCompany(company);

        EmployeeDAO dao = new EmployeeDAOImpl();
        dao.create(employee1);
        dao.create(employee2);
        Employee employeeDB = dao.findById(1L);
        System.out.println(employeeDB.getCompany());

    }
}
