/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import com.company.dao.inter.EmploymentHistoryDaoInter;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) throws Exception {
        
        EmploymentHistoryDaoInter dao= Context.instanceEmploymentHistoryDao();

       
         
       
        System.out.println(dao.getAllEmploymentHistoryByUserId(6));
        
    }
    
}
