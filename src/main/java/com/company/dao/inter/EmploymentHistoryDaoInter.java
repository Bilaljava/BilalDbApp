/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

/**
 *
 * @author ADMIN
 */
import com.company.entity.EmploymentHistory;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface EmploymentHistoryDaoInter {
    
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);
    
   
    
  
    
}
