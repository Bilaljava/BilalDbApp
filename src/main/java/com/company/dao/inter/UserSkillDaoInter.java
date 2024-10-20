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
import com.company.entity.UserSkill;
import java.util.List;

/**
 *
 * @author TURAL
 */
public interface UserSkillDaoInter {
     
     
    public List<UserSkill> getAllSkillByUserId(int id);

    public boolean insertUserSkill(UserSkill u);
    
    public boolean updateUserSkill(UserSkill u);
    
    public boolean removeUser(int id);
}