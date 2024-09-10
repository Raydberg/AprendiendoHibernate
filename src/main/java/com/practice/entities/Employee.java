package com.practice.entities;

import com.mysql.cj.xdevapi.AbstractDataResult;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.grammars.hql.HqlParser;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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
    @Column(name = "first_name", length = 30, nullable = false)
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

    //Estructura de Datos
    @ElementCollection
    //Inicializamos con un array para poder inicializarlo y no salga null
    private List<String> nickNames = new ArrayList<>();
    @ElementCollection
    private List<Integer> postalCodes = new ArrayList<>();
    @ElementCollection
    private Set<String> crediCards = new HashSet<>();
    @ElementCollection
    private Map<String, String> phones = new HashMap<>();
    @Enumerated(EnumType.STRING)
    EmployeeCategory category;

    // ###################################### ASOCIACION : ONE TO ONE ######################################
    //1. Asociacion clave foranea
    @OneToOne
    @JoinColumn(name = "direction_pk",foreignKey = @ForeignKey(name = "fk_employee_direction") )
//    @OneToOne
//    @JoinTable(name = "ob_employees_direction"
//            ,joinColumns =@JoinColumn(name = "employee_id")
//            , inverseJoinColumns = @JoinColumn(name = "direction_id"))
// 3. Asociacion Clave primaria
//    @OneToOne
//    @PrimaryKeyJoinColumn
    //4. MapsId
//    @OneToOne
//    @MapsId
    Direction direction;

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

    public List<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(List<String> nickNames) {
        this.nickNames = nickNames;
    }

    public List<Integer> getPostalCodes() {
        return postalCodes;
    }

    public void setPostalCodes(List<Integer> postalCodes) {
        this.postalCodes = postalCodes;
    }

    public Set<String> getCrediCards() {
        return crediCards;
    }

    public void setCrediCards(Set<String> crediCards) {
        this.crediCards = crediCards;
    }

    public Map<String, String> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, String> phones) {
        this.phones = phones;
    }

    public EmployeeCategory getCategory() {
        return category;
    }

    public void setCategory(EmployeeCategory category) {
        this.category = category;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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
                ", nickNames=" + nickNames +
                '}';
    }
}
