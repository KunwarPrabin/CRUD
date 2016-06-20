/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management.crud.controller;

import com.management.crud.dao.StudentDAO;
import com.management.crud.entity.Student;
import java.util.Scanner;

/**
 *
 * @author OWNER
 */
public class StudentController {

    private StudentDAO studentDAO;
    private Scanner input;
    private int counter;

    public StudentController(StudentDAO studentDAO, Scanner input) {
        this.studentDAO = studentDAO;
        this.input = input;
    }

    public void menu() {
        System.out.println("1. ADD STUDENT");
        System.out.println("2. DELETE STUDENT");
        System.out.println("3. SEARCH BY ID");
        System.out.println("4. SHOW ALL");

        System.out.println("6. EXIT");
        System.out.println("ENTER YOUR CHOICE[1-6]:");
    }

    private void add() {
        while (true) {
            Student s = new Student();
            s.setId(studentDAO.count() + 1);
            System.out.println("Enter First Name:");
            s.setFirstName(input.next());
            System.out.println("Enter Last Name:");
            s.setLastName(input.next());
            System.out.println("Enter email:");
            s.setEmail(input.next());
            System.out.println("Enter Status:");
            s.setStatus(input.nextBoolean());
            studentDAO.insert(s);
            System.out.println("Do You Really want to add more ? [Y/N]:");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private void delete() {

        System.out.println("Enter Id To Delete");
        Student student = studentDAO.getById(input.nextInt());
        if (student != null) {
            System.out.println("Name:" + student.getFullName());
            System.out.println("email:" + student.getEmail());
        } else {
            System.out.println("Id not found");
        }
        System.out.println("Are You Sure You want to Delete?");
        if (input.next().equalsIgnoreCase("n")) {
            
        }
        counter--;

    }

    private void searchById() {
        while (true) {
            System.out.println("Enter Id to search:");
            Student student = studentDAO.getById(input.nextInt());
            if (student != null) {
                System.out.println("Name:" + student.getFullName());
                System.out.println("email:" + student.getEmail());
            } else {
                System.out.println("Id not found");
            }
            System.out.println("Do You Really want to Search again ? [Y/N]:");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private void showAll() {
        for (Student std : studentDAO.getAll()) {
            System.out.println("Id:" + std.getId());
            System.out.println("Name:" + std.getFullName());
            System.out.println("email:" + std.getEmail());
        }
        System.out.println("Press any key to menu :");
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
                break;
            case 6:
                System.out.println("Do You Really want to exit ? [Y/N]:");
                if (input.next().equalsIgnoreCase("y")) {
                    System.exit(0);
                }
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }
}
