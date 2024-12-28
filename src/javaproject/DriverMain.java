package javaproject;

import java.util.Scanner;

interface Taxable {
    double SALES_TAX = 7.0;    // Sales tax percentage
    double INCOME_TAX = 10.5;  // Income tax percentage

    double calcTax();
}

class Employee implements Taxable {
    private int empId;
    private String name;
    private double salary;

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calcTax() {
        return (salary * INCOME_TAX) / 100;
    }

    @Override
    public String toString() {
        return "Employee ID: " + empId + ", Name: " + name + ", Yearly Salary: " + salary;
    }
}

class Product implements Taxable {
    private int pid;
    private double price;
    private int quantity;

    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double calcTax() {
        return (price * SALES_TAX) / 100;
    }

    @Override
    public String toString() {
        return "Product ID: " + pid + ", Price per Unit: " + price + ", Quantity: " + quantity;
    }
}

public class DriverMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Employee
        System.out.println("Enter Employee Details:");
        System.out.print("Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Yearly Salary: ");
        double salary = sc.nextDouble();

        Employee employee = new Employee(empId, name, salary);
        System.out.println("\nEmployee Details:");
        System.out.println(employee);
        System.out.println("Income Tax: " + employee.calcTax());

        // Input for Product
        System.out.println("\nEnter Product Details:");
        System.out.print("Product ID: ");
        int pid = sc.nextInt();
        System.out.print("Price per Unit: ");
        double price = sc.nextDouble();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        Product product = new Product(pid, price, quantity);
        System.out.println("\nProduct Details:");
        System.out.println(product);
        System.out.println("Sales Tax (per unit): " + product.calcTax());
    }
}