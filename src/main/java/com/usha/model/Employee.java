package com.usha.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@NoArgsConstructor  // for no argument constructor
public class Employee{
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    private String empAddress;
    private String empPhone;
    private String empPost;
    private int empAge;
    private long empSalary;

    //constructor
    public Employee(String empName, String empAddress, String empPhone, String empPost, int empAge, long empSalary){
        // Let ID be auto-generated
        this.empName = empName;
        this.empAddress = empAddress;
        this.empPhone = empPhone;
        this.empPost = empPost;
        this.empAge = empAge;
        this.empSalary = empSalary;
    }
    // Getters
    public String getEmpName(){
        return empName;
    }
    public String getEmpAddress(){
        return empAddress;
    }
    public String getEmpPhone(){
        return empPhone;
    }
    public String getEmpPost(){
        return empPost;
    }
    public int getEmpId(){
        return empId;
    }
    public int getEmpAge(){ return empAge;}
    public long getEmpSalary(){ return empSalary;}

    // setters
    public void setEmpId(int empId){
        if (empId < 0) throw new IllegalArgumentException("Employee ID cannot be less than 0");
        this.empId = empId;
    }

    public void setEmpName(String empName){
        if (empName == null) throw new IllegalArgumentException("Name must not be null.");
        this.empName = empName;
    }

    public void setEmpAddress(String empAddress){
        this.empAddress = empAddress;
    }
    public void setEmpPhone(String empPhone){
        if (empPhone.length() != 10) throw new IllegalArgumentException("Phone number must be 10 digits");
        this.empPhone = empPhone;
    }

    public void setEmpPost(String empPost){
        this.empPost = empPost;
    }

    public void setEmpAge(int empAge){
        if (empAge < 18) throw new IllegalArgumentException("Age cannot be less than 18");
        this.empAge = empAge;
    }
    public void setEmpSalary(long empSalary){
        this.empSalary = empSalary;
    }

    // method to display employee details
    @Override
    public String toString(){
        return "Employee ID: " + empId +
                "\nName: " + empName +
                "\nAddress: " + empAddress +
                "\nPhone: " + empPhone +
                "\nPost: " + empPost +
                "\nAge: " + empAge +
                "\nSalary: " + empSalary +
                "\n" + "-".repeat(30);
    }
}

