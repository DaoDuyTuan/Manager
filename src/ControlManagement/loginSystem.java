/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlManagement;

import Utinity.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuyTuan
 */
public class loginSystem {
    public boolean loginByAdmin(String ID,String password){
        Connection conn = ConnectionDB.openDB();
        PreparedStatement stm = null;
        ResultSet result = null;
        
        try {
            stm = conn.prepareStatement("SELECT password FROM Admin WHERE adminID=? AND password=? ");
            stm.setString(1, ID);
            stm.setString(2, password);
            result = stm.executeQuery();
            
            if(result.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginSystem.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn, stm, result);
        }
        return false;
    }
    public boolean loginByCurator(String ID,String password){
        Connection conn = ConnectionDB.openDB();
        PreparedStatement stm = null;
        ResultSet result = null;
        
        try {
            stm = conn.prepareStatement("SELECT password FROM Curator WHERE curatorID=? AND password=? ");
            stm.setString(1, ID);
            stm.setString(2, password);
            result = stm.executeQuery();
            
            if(result.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginSystem.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn, stm, result);
        }
        return false;
    }
    public boolean loginByStudent(String name,String password){
        Connection conn = ConnectionDB.openDB();
        PreparedStatement stm = null;
        ResultSet result = null;
        
        try {
            stm = conn.prepareStatement("SELECT password FROM Student WHERE MSSV=? AND password=? ");
            stm.setString(1, name);
            stm.setString(2, password);
            result = stm.executeQuery();
            
            if(result.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginSystem.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn, stm, result);
        }
        return false;
    }

}
