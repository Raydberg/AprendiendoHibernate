package com.practice.Entities;

import com.practice.dao.DirectionDAO;
import com.practice.dao.DirectionDAOImpl;
import com.practice.dao.EmployeeDAO;
import com.practice.dao.EmployeeDAOImpl;
import com.practice.entities.Direction;
import com.practice.entities.Employee;
import com.practice.entities.EmployeeCategory;
import com.practice.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EnployeeTest {
    @Test
    void createTablesTest() {
        Employee employee1 = new Employee(null,
                "Empleado1",
                "Garcia",
                "empleado1@gmail",
                32,
                4000d,
                true,
                LocalDate.of(1999, 1, 1),
                LocalDateTime.now()
        );
        Employee employee2 = new Employee(null,
                "Empleado2",
                "Ryan",
                "empleado2@gmail",
                22,
                4045d,
                false,
                LocalDate.of(1987, 3, 5),
                LocalDateTime.now()
        );
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        //Inicia la transaccion
        session.beginTransaction();
        session.persist(employee1);
        session.persist(employee2);
        //  Inserta los cambios en la base de datos
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        HibernateUtil.shutdown();
    }

    @Test
    void nickNamesTest() {
        Employee employee = new Employee(null,
                "employee nick",
                "Perez",
                "employeenick@gmail.com",
                32,
                4000d,
                true,
                LocalDate.of(1999, 1, 1),
                LocalDateTime.now()
        );
        //Opcion 1
//        List<String> nickNames = new ArrayList<>();
//        nickNames.add("nickname1");
//        nickNames.add("nickname2");
//        nickNames.add("nickname3");
//        nickNames.add("nickname4");
//    employee.setNickNames(nickNames);
//
        //Opcion 2
        employee.getNickNames().add("nickname1");
        employee.getNickNames().add("nickname2");
        employee.getNickNames().add("nickname3");
        employee.getNickNames().add("nickname4");
        employee.getPostalCodes().add(12636);
        employee.getPostalCodes().add(12345);
        employee.getPostalCodes().add(18451);
        employee.getPostalCodes().add(89722);
        employee.getCrediCards().add("1234-4123-789-7896");
        employee.getCrediCards().add("8934-4123-789-1546");
        employee.getCrediCards().add("8982-2399-789-1546");
        employee.getCrediCards().add("8934-7822-789-1546");
        employee.getPhones().put("7894566", "Movistar");
        employee.getPhones().put("123654", "Claro");
        employee.getPhones().put("748596", "Entel");
        //Enums
        employee.setCategory(EmployeeCategory.SENIOR);
        EmployeeDAO dao = new EmployeeDAOImpl();
        dao.create(employee);
    }

    @Test
    @DisplayName("Test para aprobar la asociacion One to One entre Employee y Direction")
    void employeeDirectionTest() {
        Direction direction = new Direction(null,"El street test","Trujillo","Peru");
        Employee employee = new Employee(null,
                "EmpleadoOneToOne",
                "Garcia",
                "oneToOne@gmail",
                32,
                4000d,
                true,
                LocalDate.of(1999, 1, 1),
                LocalDateTime.now()
        );
        employee.setDirection(direction);//One to One
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        DirectionDAO directionDAO = new DirectionDAOImpl();
        directionDAO.create(direction);
        employeeDAO.create(employee);
        //Asegurarse recuperando de nuevo el empleado de base de datos
      Employee employeeDB = employeeDAO.findById(1L);
        System.out.println(employeeDB.getDirection());
    }
}
