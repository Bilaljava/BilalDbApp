/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

/**
 *
 * @author ADMIN
 */
import com.company.entity.User;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface UserDaoInter {
    
    public List<User> getAll();
    
    public User getById(int id);
    
    public boolean updateUser(User u);
    
    public boolean addUser(User u);
    
    public boolean removeUser(int id);
    
  
    
}