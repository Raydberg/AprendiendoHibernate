package com.practice.relationships;

import com.practice.dao.EmployeeDAO;
import com.practice.dao.EmployeeDAOImpl;
import com.practice.entities.Car;
import com.practice.entities.Employee;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class OneToManyTest {
    @Test
    void oneToManyTest() {
        Employee employee = new Employee(null,
                "Empleado one to many",
                "Garcia",
                "oneToMany@gmail",
                32,
                4000d,
                true,
                LocalDate.of(1999, 1, 1),
                LocalDateTime.now()
        );
        Car car1 = new Car(null,"Ford",1.2,2005);
        Car car2 = new Car(null,"Toyota",5.9,2085);
        Car car3 = new Car(null,"Nissan",8.2,2045);
        employee.getCars().add(car1);
        employee.getCars().add(car2);
        employee.getCars().add(car3);
        EmployeeDAO dao = new EmployeeDAOImpl();
        dao.create(employee);
//
//        Employee employeeDB = dao.findById(1L);
//        System.out.println(employeeDB);
        Employee employeeDB = dao.findByIdEager(1L);
        System.out.println(employeeDB);
        List<Car> cars = employeeDB.getCars();
        System.out.println(cars);
    }
}
