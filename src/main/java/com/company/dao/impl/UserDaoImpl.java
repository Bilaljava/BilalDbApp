/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

/**
 *
 * @author ADMIN
 */
import com.company.entity.Country;
import com.company.entity.User;
import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    
    
    private User getUser(ResultSet rs)throws Exception{
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String profileDesc = rs.getString("profile_description");
               int nationalityId = rs.getInt("nationality_id");
               int birthplaceId = rs.getInt("birthplace_id");
               
               String nationalityStr = rs.getString("nationality");
               String birthPlaceStr = rs.getString("birthplace");
               Date birthdate = rs.getDate("birthdate");
               
               
                Country nationality = new Country(nationalityId, null,nationalityStr);
                Country birthplace = new Country(birthplaceId, birthPlaceStr,null);
                
                return new User(id,name, surname, phone,address, email,profileDesc, birthdate, nationality,birthplace);
    }
    
    
    @Override
    public List<User> getAll() {
        
        List<User> result =new ArrayList<>();
        try ( Connection c = connect()){
           
            
            
            
            Statement stmt = c.createStatement();
            stmt.execute("select" 
+" u.*,"
+" n.nationality ,"
+" c.name as birthplace"
+" from user u"
+" left join country n on u.nationality_id = n.id"
+" left join country c on u.birthplace_id = c.id");
            ResultSet rs = stmt.getResultSet();
            
            while (rs.next()){
                
                User u = getUser(rs);
                
                result.add(u);
            }
          
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {
        try(Connection c = connect()) {
            
            PreparedStatement stmt = c.prepareStatement("update user set name =?,surname=?,phone=?,address=?,email=?, birthdate=?,birthplace_id =?, profile_description=? where id =?"); 
            
            
           
           stmt.setString(1, u.getName());
           stmt.setString(2, u.getSurname());
           stmt.setString(3, u.getPhone());
           stmt.setString(4, u.getAddress());
           stmt.setString(5, u.getEmail());
           stmt.setDate(6, u.getBirthDate());
            stmt.setInt(7, u.getBirthPlace().getId());
           stmt.setString(8, u.getProfileDesc());
          
           stmt.setInt(9, u.getId());
            
          return  stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()){
            
            Statement stmt = c.createStatement();   
          return  stmt.execute("delete from user  where id ="+id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
    }

//    @Override
//    public User getById(int userId){
//        User result =null;
//        try ( Connection c = connect()){
//           
//            
//            
//            
//            Statement stmt = c.createStatement();
//            stmt.execute("select u.*" 
//
//+" n.nationality ,"
//+" c.name as birthplace"
//+" from user u"
//+" left join country n on u.nationality_id = n.id"
//+" left join country c on u.birthplace_id = c.id where u.id =?");
//            ResultSet rs = stmt.getResultSet();
//            
//            while (rs.next()){
//                
//                
//                
//                result = getUser(rs);
//            }
//          
//        } catch (Exception ex) {
//           ex.printStackTrace();
//        }
//        return result;
//        
//    }
    
    
    @Override
public User getById(int userId) {
    User result = null;
    try (Connection c = connect()) {
        
         Statement stmt = c.createStatement();
        stmt.execute( "SELECT u.*, n.nationality, c.name AS birthplace " +
                       "FROM user u " +
                       "LEFT JOIN country n ON u.nationality_id = n.id " +
                       "LEFT JOIN country c ON u.birthplace_id = c.id " +
                       "WHERE u.id ="+userId); // SQL sorğusunu burada düzəldin

        
             // Parametri buraya əlavə edin

        ResultSet rs = stmt.getResultSet(); // 'executeQuery' istifadə edin

        while (rs.next()) {
            result = getUser(rs);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return result;
}

    @Override
    public boolean addUser(User u) {
        try(Connection c = connect()) {
            
            PreparedStatement stmt = c.prepareStatement("insert into user(name, surname, phone, email,profile_description)  values(?,?,?,?,?)"); 
            
            
           
           stmt.setString(1, u.getName());
           stmt.setString(2, u.getSurname());
           stmt.setString(3, u.getPhone());
           stmt.setString(4, u.getEmail());
           stmt.setString(5, u.getProfileDesc());
       
          return  stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    }
    
 
