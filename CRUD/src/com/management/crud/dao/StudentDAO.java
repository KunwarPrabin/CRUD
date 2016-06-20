/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management.crud.dao;

import com.management.crud.entity.Student;
import java.util.ArrayList;

/**
 *
 * @author OWNER
 */
public interface StudentDAO {
    
    boolean insert(Student s);
    boolean delete(int id);
    Student getById(int id);
    ArrayList<Student> getAll();
    int count();
}
