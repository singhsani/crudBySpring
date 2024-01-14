package com.example.first.project.Model;

import javax.persistence.*;

@Entity
@Table(name="employee_detail")
public class Employee {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

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

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee(){

    }
    public Employee(String firstName,String lastName ,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }
}
