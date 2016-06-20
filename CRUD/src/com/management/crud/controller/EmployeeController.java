/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management.crud.controller;
import com.management.crud.dao.EmployeeDAO;
import com.management.crud.entity.Employee;
import java.util.Scanner;

/**
 *
 * @author OWNER
 */
public class EmployeeController {

    private EmployeeDAO employeeDAO;
    private Scanner input;
    private int counter;

    public EmployeeController(EmployeeDAO employeeDAO, Scanner input) {
        this.employeeDAO = employeeDAO;
        this.input = input;
    }

    public void menu() {
        System.out.println("1.ADD EMPLOYEE");
        System.out.println("2.DELETE EMPLOYEE");
        System.out.println("3.SEARCH BY ID");
        System.out.println("4.SHOW ALL");
        System.out.println("5.EXIT");
        System.out.println("ENTER YOUR CHOICE[1-5]");
    }

    private void add() {
        while (true) {
            Employee employee = new Employee();
            employee.setId(employeeDAO.count() + 1);
            System.out.println("Enter First Name");
            employee.setFirstName(input.next());
            System.out.println("Enter Last Name");
            employee.setLastName(input.next());
            System.out.println("Enter email");
            employee.setEmail(input.next());
            System.out.println("Enter contact number");
            employee.setContactNo(input.next());
            System.out.println("Enter Address");
            employee.setAddress(input.next());
            System.out.println("Enter Status");
            employee.setStatus(input.nextBoolean());
            employeeDAO.insert(employee);
            System.out.println("DO YO WANT TO ADD MORE[Y/N]:");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private void delete() {
        System.out.println("Enter Id to delete ");
        Employee employee = employeeDAO.getById(input.nextInt());
        if (employee != null) {
            System.out.println("Id:" + employee.getId());
            System.out.println("Name:" + employee.getFullName());
        } else {
            System.out.println("ID not found ");
        }
        System.out.println("Do you  really  want to delete ? [Y/N]");
        if (input.next().equalsIgnoreCase("n")) {

        }
        counter--;
    }

    private void searchById() {
        while (true) {
            System.out.println("Enter Id to search ?");
            Employee employee = employeeDAO.getById(input.nextInt());
            if (employee != null) {
                System.out.println("ID:" + employee.getId());
                System.out.println("NAME:" + employee.getFullName());
                System.out.println("email:" + employee.getEmail());
                System.out.println("Contact No:" + employee.getContactNo());
                System.out.println("Address:" + employee.getAddress());
                System.out.println("Status:" + employee.isStatus());
            } else {
                System.out.println("Id Not Found");
            }
            System.out.println("DO YO WANT TO SEARCH AGAIN?[Y/N]:");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }

    }

    private void showAll() {
        for (Employee e : employeeDAO.getAll()) {
            System.out.println("ID:" + e.getId());
            System.out.println("NAME:" + e.getFullName());
            System.out.println("email:" + e.getEmail());
            System.out.println("Contact No:" + e.getContactNo());
            System.out.println("Address:" + e.getAddress());
            System.out.println("Status:" + e.isStatus());
        }
        System.out.println("Press Any key To Menu......");
        input.next();
    }

    public void process() {
        menu();
        switch (input.nextInt()) {
            case 1:
                add();
                break;
            case 2:
                delete();
                break;
            case 3:
                searchById();
                break;
            case 4:
                showAll();
                break;
            case 5:
                System.out.println("DO YO WANT TO EXIT[Y/N]:");
                if (input.next().equalsIgnoreCase("y")) {
                    System.exit(0);
                }
                break;
            default:
                System.out.println("INVALID CHOICE");
                break;
        }
    }
}
