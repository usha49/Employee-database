import java.util.Scanner;
import java.util.ArrayList;

public class main{
    private static ArrayList<Employee> employees = new ArrayList <>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Management System");

        while (true){
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    getAllEmployess();
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
                    System.out.println("Thank you for using our Employee Management System");
                    return;
                default:
                    System.out.println("Invalid choice, Please try again.");
            }
        }
    }

    public static void showMenu(){
        System.out.println("1. Get All Employee Details");
        System.out.println("2. Add Employee Details");
        System.out.println("3. Update Employee Details");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");
        System.out.println("Enter your choice (1-5): ");
    }

    public static void getAllEmployees(){
        System.out.println("----All Employees----");
        if (employees.isEmpty()) {
            System.out.println("There are no employees available");
        } else {
            for (Employee emp : employees){
                System.out.println(emp);
            }
        }
    }

    public static void addEmployee(){
        System.out.println("----Add Employee----");

        System.out.print("Enter Employee Id: ");
        int id  = scanner.nextInt();
        scanner.nextLine();

        // checking whether alredy exists
        if (findEmployeeById(id) != null){
            System.out.println("Employee already exists");
            return;
        }

        System.out.print("Enter Employee Name: ");
        String name =scanner.nextLine();

        System.out.print("Enter Employee Address: ");
        String address =scanner.nextLine();

        System.out.print("Enter Employee Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Employee Position");
        String phone = scanner.nextLine();

        Employee newEmployee = new Employee (id, name, address, phone, position);
        employees.add(newEmployee);

        System.out.println("Employee added successfully");
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

        System.out.print("\nWhat would you like to update?");
        System.out.print("1. Name ");
        System.out.print("2. Address ");
        System.out.print("3. Phone Number ");
        System.out.print("4. Position ");
        System.out.print("Enter your choice.");

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
        System.out.println("Updated successfully");
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
        System.out.println("Employee to delete:" + emp);
        System.out.println("Are you sure you want to delete this employee?(y/n):");
        System confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
            employees.remove(emp);
            System.out.println("Employee deleted successfully");
        } else {
            System.out.println("Delete operation cancelled");
        }
    }

    private static Employee findEmployeeById)(int id){
        for (Employee emp : employees) {
            if (emp.getEmpId() = id){
                return emp;
            }
        }
        return null;
    }
}