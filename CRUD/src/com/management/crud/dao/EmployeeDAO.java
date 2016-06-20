/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management.crud.dao;
import com.management.crud.entity.Employee;
import java.util.ArrayList;

/**
 *
 * @author OWNER
 */
public interface EmployeeDAO {
    
    boolean insert(Employee e);
    boolean delete(int id);
    Employee getById(int id);
    ArrayList<Employee> getAll();
    int count();
    
    
}
