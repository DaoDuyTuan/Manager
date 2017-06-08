/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoComboBox;

import Utinity.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.getString;

/**
 *
 * @author DuyTuan
 */
public class genDAO {
    public List<Gender> showGender(){
        List<Gender> listGender = new ArrayList<>();
        Connection conn = ConnectionDB.openDB();
        PreparedStatement stm = null;
        ResultSet result = null;
        
        try {
            stm = conn.prepareCall("SELECT ID,Gender FROM Gender");
            result = stm.executeQuery();
            
            while(result.next()){
                int id = result.getInt("ID");
                String name = result.getString("Gender");
                Gender gen = new Gender(id,name);
                listGender.add(gen);
            }
            return listGender;

        } catch (SQLException ex) {
            Logger.getLogger(genDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn, stm, result);
        }
        
        return null;
    }
    public static void main(String[] args) {
        Cat obj1 = new Cat("Tom", 2);
        obj1.speak();
        obj1 = new Cat("Jerry", 3);
        obj1.speak();
        obj1 = new Cat("Concat", 4);
        obj1.speak();
        System.out.println("Total: "+obj1.total());;
    }
}
