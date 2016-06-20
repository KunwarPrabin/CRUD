/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management.crud;

import com.management.crud.controller.StudentController;
import com.management.crud.dao.StudentDAO;
import com.management.crud.dao.impl.StudentDAOImpl;
import java.util.Scanner;

/**
 *
 * @author OWNER
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAOImpl();
        StudentController stdController = new StudentController(studentDAO, input);
        System.out.println("<==WELCOME TO STUDENT MANAGEMENT SYSTEM==>");
        while (true) {

            stdController.process();

        }

    }

}
