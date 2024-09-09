package com.practice.Entities;

import com.practice.entities.Employee;
import com.practice.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
