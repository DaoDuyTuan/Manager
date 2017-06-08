/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utinity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuyTuan
 */
public class ConnectionDB {
    public static Connection openDB(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            //localhost:3306
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","");
        } catch (Exception ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void closeConnection(Connection conn,PreparedStatement stm,ResultSet result){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(stm != null){
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }if(result != null){
            try {
                result.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void main(String[] args) {
        Connection conn = ConnectionDB.openDB();
    }
}
