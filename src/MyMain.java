import java.util.Scanner;
import java.util.ArrayList;

public class MyMain{
    private static ArrayList<Employee> employees = new ArrayList <>();
    private static Scanner scanner = new Scanner(System.in);

    public static Employee findEmployeeById(int id){
        for (Employee emp : employees) {
            if (emp.getEmpId() == id){
                return emp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Management System");
        System.out.println("----------------------------------------");

        while (true){
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    getAllEmployees();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Thank you for using our Employee Management System.");
                    return;
                default:
                    System.out.println("Invalid choice, Please try again.");
            }
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

    public static void getAllEmployees(){
        System.out.println("----All Employees----");
        System.out.println("-----------------------");
        if (employees.isEmpty()) {
            System.out.println("There are no employees available.");
            System.out.println("----------------------------------");
        } else {
            for (Employee emp : employees){
                System.out.println(emp);
            }
        }
    }

    public static void addEmployee(){
        System.out.println("----Add Employee----");

        while (true) {
            int id;
            while (true){
                System.out.print("Enter Employee Id: ");
                id  = scanner.nextInt();
                scanner.nextLine();

                // checking whether already exists
                if (findEmployeeById(id) == null){
                    break;
                }
                System.out.println("Employee already exists. Please try again.");
            }

            System.out.print("Enter Employee Name: ");
            String name =scanner.nextLine();

            System.out.print("Enter Employee Address: ");
            String address =scanner.nextLine();

            System.out.print("Enter Employee Phone Number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter Employee Position: ");
            String position = scanner.nextLine();

            Employee newEmployee = new Employee (id, name, address, phone, position);
            employees.add(newEmployee);

            System.out.println("Employee added successfully.");
            System.out.println("------------------------------");

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

    private static void updateEmployee(){
        System.out.println("----Update Employee----");

        System.out.print("Enter Employee Id to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee emp = findEmployeeById(id);
        if (emp == null){
            System.out.println("Employee not found");
            return;
        }

        System.out.println("Current details:");
        System.out.println(emp);

        System.out.println("What would you like to update?");
        System.out.println("1. Name ");
        System.out.println("2. Address ");
        System.out.println("3. Phone Number ");
        System.out.println("4. Position ");
        System.out.println("Enter your choice.");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1:
                System.out.print("Enter new Name: ");
                emp.setEmpName(scanner.nextLine());
                break;
            case 2:
                System.out.print("Enter new Address: ");
                emp.setEmpAddress(scanner.nextLine());
                break;
            case 3:
                System.out.print("Enter new Phone Number: ");
                emp.setEmpPhone(scanner.nextLine());
                break;
            case 4:
                System.out.print("Enter new Position: ");
                emp.setEmpPost(scanner.nextLine());
                break;
            default:
                System.out.println("Invalid choice,");
                return;
        }
        System.out.println("Updated successfully.");
    }

    private static void deleteEmployee(){
        System.out.println("----Delete Employee----");

        System.out.print("Enter Employee Id to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee emp = findEmployeeById(id);
        if (emp == null){
            System.out.println("Employee not found");
            return;
        }
        System.out.println("Employee to delete:");
        System.out.println(emp);
        employees.remove(emp);
        System.out.println("Employee deleted successfully.");
        }
    }

