/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.management.crud.dao.impl;

import com.management.crud.dao.StudentDAO;
import com.management.crud.entity.Student;
import java.util.ArrayList;

/**
 *
 * @author OWNER
 */
public class StudentDAOImpl implements StudentDAO{
    ArrayList<Student> studentlist = new ArrayList<>();

    @Override
    public boolean insert(Student s) {
        return studentlist.add(s);
    }

    @Override
    public boolean delete(int id) {
        Student s = getById(id);
        if(s!=null){
            studentlist.remove(s);
            return true;
        }
        return false;
    }

    @Override
    public Student getById(int id) {
       for(Student s:studentlist){
           if(s.getId()==id){
               return s;
           }
       }
       return null;
    }

    @Override
    public ArrayList<Student> getAll() {
        return studentlist;
    }

    @Override
    public int count() {
        return studentlist.size();
    }
    
}
