package SpringBootProject.Employee.Management.System;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private long id;
    private String name;
    private String email;
    private int salary;
    private String contact;
    private String address;
    private LocalDate joinDate;


    public Employee() {
    }

    public Employee(String name, String email, int salary,
                    String contact, String address, LocalDate joinDate) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.contact = contact;
        this.address = address;
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", joinDate=" + joinDate +
                ", salary" + salary +
                ", contact" + contact +
                ", address" + address +
                '}';
    }
}
