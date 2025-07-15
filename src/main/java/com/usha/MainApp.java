package com.usha;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.usha.repository.*;
import com.usha.model.*;
import com.usha.service.*;

public class MainApp{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (Connection conn = DbFunctions.connect_to_db()){
            EmployeeService service = new EmployeeService(conn);
            System.out.println("Welcome to Employee Management System");

            while (true){
                showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1:
                        showAllEmployees(service);
                        break;
                    case 2:
                        addNewEmployee(service);
                        break;
                    case 3:
                        updateEmployee(service);
                        break;
                    case 4:
                        deleteEmployee(service);
                        break;
                    case 5:
                        System.out.println("Thank you for using our Employee Management System.");
                        return;
                    default:
                        System.out.println("Invalid choice, Please try again.");
                }
            }
        } catch (Exception e){
            System.err.println("Error:" + e.getMessage());
        }
    }

    public static void showMenu(){
        System.out.println("What is the operation you want to perform?");
        System.out.println("1. Get All Employee Details");
        System.out.println("2. Add Employee Details");
        System.out.println("3. Update Employee Details");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");
        System.out.println("Enter your choice (1-5): ");
        System.out.println("---------------------------");
    }

    public static void showAllEmployees(EmployeeService service) {
        System.out.println("----All Employees----");
        System.out.println("-----------------------");

        // Getting from postgresSQL
        try{
            ArrayList<Employee> employees = service.getAllEmployees();
            if (employees.isEmpty()) {
                System.out.println("No employees found in the database.");
            } else {
                employees.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.err.println("Failed to fetch Employees" + e.getMessage());
        }

    }

    public static void addNewEmployee(EmployeeService service){
        System.out.println("----Add Employee----");

        while (true) {
            System.out.print("Enter Employee Id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Employee Address: ");
            String address = scanner.nextLine();

            System.out.print("Enter Employee Phone Number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter Employee Position: ");
            String position = scanner.nextLine();

            System.out.println("Enter Employee's Age: ");
            int age = scanner.nextInt();

            System.out.println("Enter Employee's Salary: ");
            long salary = scanner.nextLong();
            scanner.nextLine();

            // Inserting into PostgresSQL
            try {
                Employee emp = new Employee(id, name, address, phone, position, age, salary);
                service.addEmployee(emp);
                System.out.println("Employee added successfully");
            } catch(IllegalArgumentException e) {
                System.err.println("Invalid input: " + e.getMessage());
            } catch(SQLException e){
                System.err.println("Database error:" + e.getMessage());
            }

            while(true) {
                System.out.println("Do you want to add another employee? (y/n): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("n") || confirm.equalsIgnoreCase("no")){
                    return;
                } else if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")){
                    System.out.println("Then you can add new employee.");
                    break;
                } else {
                    System.out.println("Invalid input, please try again.");
                }
            }
        }
    }

    private static void updateEmployee(EmployeeService service){

        System.out.print("Enter Employee Id to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            // fetching the existing employee
            Employee emp = service.getEmployeeById(id);
            if (emp == null) {
                System.out.println("Employee id does not exist.");
                return;
            }

            // Showing current details
            System.out.println("Existing Employee Details:");
            System.out.println(emp);

            // Asking what to update
            Map<String, Object> updates = new HashMap<>();
            System.out.println("What would you like to update?");
            System.out.println("1. Name ");
            System.out.println("2. Address ");
            System.out.println("3. Phone Number ");
            System.out.println("4. Position ");
            System.out.println("5. Age");
            System.out.println("6. Salary");
            System.out.println("Enter your choice.");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Enter new Name: ");
                    updates.put("e_name",scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter new Address: ");
                    updates.put("e_address",scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter new Phone Number: ");
                    updates.put("emp_phone",scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter new Position: ");
                    updates.put("emp_post",scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Enter new Age: ");
                    updates.put("emp_age",scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.print("Enter new Salary: ");
                    updates.put("emp_salary", scanner.nextLong());
                    scanner.nextLine();
                default:
                    System.out.println("Invalid choice,");
                    return;
            }

            // Applying updates
            service.updateEmployee(id, updates);
            System.out.println("Employee updated successfully.");

        } catch (SQLException e){
            System.err.println("Database error:" + e.getMessage());
        } catch (IllegalArgumentException e){
            System.err.println("Invalid input: " + e.getMessage());
        }
    }

    private static void deleteEmployee(EmployeeService service) {
        System.out.println("----Delete Employee----");
        System.out.print("Enter Employee Id to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        // Getting from postgresSQL
        try {
            // fetching the existing employee
            Employee emp = service.getEmployeeById(id);
            if (emp == null) {
                System.out.println("Employee id does not exist.");
                return;
            }

            // Showing current details
            System.out.println("Existing Employee Details:");
            System.out.println(emp);

            // deleting
            service.deleteEmployee(id);
            System.out.println("Employee deleted successfully.");
            System.out.println("-------------------------------");
        } catch (SQLException e){
            System.err.println("Database error:" + e.getMessage());
        }
    }
}

