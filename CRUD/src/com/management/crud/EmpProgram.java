/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management.crud;
import com.management.crud.controller.EmployeeController;
import com.management.crud.dao.EmployeeDAO;
import com.management.crud.dao.impl.EmployeeDAOImpl;
import java.util.Scanner;

/**
 *
 * @author OWNER
 */
public class EmpProgram {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        EmployeeController empController = new EmployeeController(employeeDAO, input);
        System.out.println("<==WEL-COME TO EMPLOYEE MANAGEMENT SYSTEM==>");
        while (true) {
            
            empController.process();
            

           
        }
    }
}
