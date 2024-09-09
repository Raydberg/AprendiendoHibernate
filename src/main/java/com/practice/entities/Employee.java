package com.practice.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/***
 * Representa la tabla employee en la base de datos
 */
@Entity
@Table(name = "ob_employees")
public class Employee implements Serializable {
    //Atributos (columna en la tabla)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",length = 30 , nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    private Integer age;
    private Double salary;
    private Boolean married;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "register_date")
    private LocalDateTime registerDate;

    //Constructores
//Almenos debe haber un constructor vacio para que el ORM lo utilice
    public Employee() {
    }
    //Constructor para usarlo nosotros

    public Employee(Long id, String firstName, String lastName, String email, Integer age, Double salary, Boolean married, LocalDate birthDate, LocalDateTime registerDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.married = married;
        this.birthDate = birthDate;
        this.registerDate = registerDate;
    }
    // Get y Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }


//Metodo toString

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", married=" + married +
                ", birthDate=" + birthDate +
                ", registerDate=" + registerDate +
                '}';
    }
}
