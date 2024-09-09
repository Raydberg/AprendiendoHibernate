package com.practice.dao;

import com.practice.entities.Employee;

import java.util.List;

/**
 * Data Access Object
 * Metodos CRUD
 *
 */

public interface EmployeeDAO {

    /**
     *Recuperar todo los empleados de la base de datos de la
     * tabla Employee
     * Utiliza HQL
     * @return lista de empleados
     */
    List<Employee> findAll();

    /**
     * Recuperar datos haciendo uso de CRITERIA
     * @return
     */
    List<Employee> findAllCriteria();
    /**
     * Busca un empleado por ID
     * @return empleado
     */
    Employee findById(Long id);

    /**
     * Busqueda de empleado por ID haciendo uso de Criteria
     * @param id
     * @return
     */
     Employee findByIdCriteria(Long id);
    /**
     * Buscar todo los empleados por edad
     * @param age
     * @return lista de empleados por edad
     */
    List<Employee> findByAge(Integer age);

    /**
     * Filtrar por apellido
     * @param lastName
     * @return
     */
    List<Employee> findByLastNameLikeCriteria(String lastName);

    /**
     * Filtrar mayores de un determinado numero
     * @param age
     * @return
     */
    List<Employee> findByAgeGreaterCriteria(Integer age);

    /**
     * Filtrar por rango de edad entre dos numeros
     * Criteria
     * @param min
     * @param max
     * @return
     */
    List<Employee> findByAgeBetweenCriteria(Integer min , Integer max );

    /**
     * Inserta un nuevo reguistro en la tabla employees
     * @param employee
     * @return
     */
   Employee create(Employee employee);

    /**
     * Actualiza un reguistro existente en  la tabla employees
     * @param employee
     * @return
     */
   Employee update (Employee employee);

    /**
     * Borrar un empleado de la tabla employees
     * @param id
     * @return
     */
   boolean deleteById(Long id);

}
