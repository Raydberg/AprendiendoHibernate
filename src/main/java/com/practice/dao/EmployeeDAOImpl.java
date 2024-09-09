package com.practice.dao;

import com.practice.entities.Employee;
import com.practice.util.HibernateUtil;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Consulta HQL
        Query<Employee> query = session.createQuery("from Employee ", Employee.class);
        List<Employee> employees = query.list();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> findAllCriteria() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //1. Criteria
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        //  Root<Employee> root = criteria.from(Employee.class);
        //   criteria.select(root);
        criteria.select(criteria.from(Employee.class));
        //2. Query
        List<Employee> employees = session.createQuery(criteria).list();
        session.close();
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee2 = session.find(Employee.class, 1L);
        session.close();
        return employee2;
    }

    @Override
    public Employee findByIdCriteria(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        Predicate filter = builder.equal(root.get("id"), id);
        criteria.select(root).where(filter);
        //Query
        Employee employee = session.createQuery(criteria).getSingleResult();
        session.close();
        return employee;
    }

    @Override
    public List<Employee> findByAge(Integer age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Employee> query = session.createQuery("from Employee where age=:age", Employee.class);
        query.setParameter("age", age);
        List<Employee> employees = query.list();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> findByLastNameLikeCriteria(String lastName) {
        // SELECT*FROM ob_employees WHERE lastName like '%ence%'

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        //Like simulando metodos de SQL
        Predicate filter = builder.like(root.get("lastName"),"%"+lastName+"%");
        criteria.select(root).where(filter);
        //Query
        List<Employee> employee = session.createQuery(criteria).list();
        session.close();
        return employee;
    }

    @Override
    public List<Employee> findByAgeGreaterCriteria(Integer age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        // gt metodo para indicar 'mayor que'
        Predicate filter = builder.gt(root.get("age"),age);
        criteria.select(root).where(filter);
        //Query
        List<Employee> employee = session.createQuery(criteria).list();
        session.close();
        return employee;
    }

    @Override
    public List<Employee> findByAgeBetweenCriteria(Integer min, Integer max) {
      Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        // between para rangos igual que SQL
        Predicate filter = builder.between(root.get("age"),min,max);
        criteria.select(root).where(filter);
        //Query
        List<Employee> employee = session.createQuery(criteria).list();
        session.close();
        return employee;
    }

    @Override
    public Employee create(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            //Cambio del metodo update con merge ya que esta deprecado
            session.merge(employee);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return employee;
    }

    @Override
    public boolean deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            //Obtiene el empleado de la base de datos y procede a eliminarlo
            Employee employee = this.findById(id);
            session.remove(employee);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
