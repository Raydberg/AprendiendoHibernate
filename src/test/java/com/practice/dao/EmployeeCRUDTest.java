package com.practice.dao;
import com.practice.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

class EmployeeCRUDTest {
    EmployeeDAO dao;

    @BeforeEach
    void setUp() {
        dao = new EmployeeDAOImpl();
    }

    @Test
    void findAll() {
        List<Employee> employees = dao.findAll();
        System.out.println(employees);
    }

    @Test
    void findById() {
        Employee employee1 = dao.findById(1L);
        Employee employee2 = dao.findById(2L);
        Employee employee3 = dao.findById(3L);
    }

    @Test
    void findByAge() {
        List<Employee> employees18 = dao.findByAge(18);
        List<Employee> employees15 = dao.findByAge(15);
        List<Employee> employees50 = dao.findByAge(50);
    }

    @Test
    void create() {
        Employee employee = new Employee(null, "EmployeeCreateTest", "test", "test@gamil.com", 55, 2258.9, false, LocalDate.now(), LocalDateTime.now());
        dao.create(employee);
        System.out.println(employee);
    }

    @Test
    void update() {
        //Se pone ahora el ID por que es una actualizacion
        Employee employee1 = new Employee(1L,
                "Empleado1 editado",
                "Garcia",
                "empleado1@gmail",
                32,
                4000d,
                true,
                LocalDate.of(1999, 1, 1),
                LocalDateTime.now()
        );
        employee1 = dao.update(employee1);
        System.out.println(employee1);
    }

    @Test
    void deleteById() {
        boolean result = dao.deleteById(1L);
        System.out.println(result);
    }
}