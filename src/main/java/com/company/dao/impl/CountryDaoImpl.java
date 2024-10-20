/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

/**
 *
 * @author ADMIN
 */
import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    public Country getCountry(ResultSet rs) throws Exception{
    int id  =rs.getInt("Id");
    String name = rs.getString("name");
    String nationality = rs.getString("nationality");
    
    Country country = new Country(id, name, nationality);
        System.out.println(country);
        return country;
     }
    
    
    @Override
    public List<Country> getAll() {
  List<Country> list = new ArrayList<>();
  Connection conn;
  
  try{
      conn = connect();
      Statement stmt = conn.createStatement();
      stmt.execute("SELECT * FROM country");
      ResultSet rs = stmt.getResultSet();
      
      while(rs.next()){
          Country country = getCountry(rs);
          list.add(country);
      }
  }catch(Exception ex){
      
  }
  return list;
    }

 
}
