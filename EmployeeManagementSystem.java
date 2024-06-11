import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// Employee class definition
class Employee {
    private int id;
    private String name;
    private String department;
    private String position;

    // Constructor
    public Employee(int id, String name, String department, String position) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.position = position;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // toString method to print employee details
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Position: " + position;
    }
}

// EmployeeManagementSystem class to manage employee records
public class EmployeeManagementSystem {
    private List<Employee> employees;

    // Constructor
    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
    }

    // Method to add a new employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    // Method to view all employees
    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("Employee Records:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // Method to update employee information
    public void updateEmployee(int id, String newName, String newDepartment, String newPosition) {
        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(newName);
                employee.setDepartment(newDepartment);
                employee.setPosition(newPosition);
                System.out.println("Employee information updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    // Method to delete an employee
    public void deleteEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        while (true) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
              case 1:
                  System.out.print("Enter Employee ID: ");
                  int id = scanner.nextInt();
                  scanner.nextLine(); // Consume newline
                  System.out.print("Enter Employee Name: ");
                  String name = scanner.nextLine();
                  System.out.print("Enter Employee Department: ");
                  String department = scanner.nextLine();
                  System.out.print("Enter Employee Position: ");
                  String position = scanner.nextLine();

                  system.addEmployee(new Employee(id, name, department, position));
                  break;

              case 2:
                  system.viewEmployees();
                  break;

              case 3:
                  System.out.print("Enter Employee ID to update: ");
                  int updateId = scanner.nextInt();
                  scanner.nextLine(); // Consume newline
                  System.out.print("Enter New Name: ");
                  String newName = scanner.nextLine();
                  System.out.print("Enter New Department: ");
                  String newDepartment = scanner.nextLine();
                  System.out.print("Enter New Position: ");
                  String newPosition = scanner.nextLine();

                  system.updateEmployee(updateId, newName, newDepartment, newPosition);
                  break;

              case 4:
                  System.out.print("Enter Employee ID to delete: ");
                  int deleteId = scanner.nextInt();
                  scanner.nextLine(); // Consume newline

                  system.deleteEmployee(deleteId);
                  break;

              case 5:
                  System.out.println("Exiting Employee Management System. Goodbye!");
                  scanner.close();
                  System.exit(0);

              default:
                  System.out.println("Invalid choice. Please enter a number between 1 and 5.");
          }
      }
  }
}