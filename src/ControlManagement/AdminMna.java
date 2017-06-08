/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlManagement;

import ModelManagerment.Admin;
import ModelManagerment.Curator;
import Utinity.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author DuyTuan
 */
public class AdminMna {

    public AdminMna() {
    }
    
    public boolean insertCurato(String mssv,String name,String address,String password, String adminID){
        Connection conn = ConnectionDB.openDB();
        ResultSet result = null;
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement("INSERT INTO Curator(curatorID,curatorName,curatorAddress,password,adminID) values(?,?,?,?,?)");
            stm.setString(1, mssv);
            stm.setString(2, name);
            stm.setString(3, address);
            stm.setString(4, password);
            stm.setString(5, adminID);
            return stm.executeUpdate()> 0;
        } catch (SQLException ex) {
            Logger.getLogger(AdminMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn, stm, result);
        }
        return false;
    }
    
    public List<Curator> viewDetailCurator(){
        List<Curator> listCurator = new ArrayList<>();
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        
        try {
            selectStatement = conn.prepareStatement("SELECT Curator.curatorID,curatorName,"
                    + "curatorAddress,COUNT(Student.curatorID) AS TotalStudent FROM Curator"
                    + " LEFT JOIN Student ON Curator.curatorID = Student.curatorID"
                    + " GROUP BY Curator.curatorID,curatorName,curatorAddress");
            resultFromSelectStatement = selectStatement.executeQuery();
            while(resultFromSelectStatement.next()){
                Curator cur = new Curator();
                setCurator(cur, resultFromSelectStatement);
                listCurator.add(cur);
            }
            return listCurator;
        } catch (SQLException ex) {
            Logger.getLogger(AdminMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        return null;
    }
    public boolean updateCurator(String id, String name, String address){
        //Curator cur = new Curator();
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement stm = null;
        
        try {
            stm = conn.prepareStatement("UPDATE Curator SET curatorName=?,curatorAddress=? WHERE curatorID=?");
            stm.setString(1, name);
            stm.setString(2, address);
            stm.setString(3, id);
            return stm.executeUpdate()> 0;
        } catch (SQLException ex) {
            Logger.getLogger(AdminMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn, stm, resultFromSelectStatement);
        }
        return false;
    }
    public boolean deleteCuratorFromDB(String ID){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        try {
            selectStatement = conn.prepareStatement("DELETE FROM Curator WHERE curatorID = ?");
            selectStatement.setString(1, ID);
            if(selectStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        
        return false;
    }
    public Curator searchCurator(String ID){
        Curator cur = new Curator();
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        
        try {
            selectStatement = conn.prepareStatement("SELECT Curator.curatorID,curatorName,"
                    + "curatorAddress,COUNT(Student.curatorID) AS TotalStudent FROM Curator"
                    + " LEFT JOIN Student ON Curator.curatorID = Student.curatorID WHERE Curator.curatorID = ?"
                    + " GROUP BY Curator.curatorID,curatorName,curatorAddress");
            selectStatement.setString(1, ID);
            resultFromSelectStatement = selectStatement.executeQuery();
            
            if(resultFromSelectStatement.next()){
                setCurator(cur, resultFromSelectStatement);
            }
            return cur;
        } catch (SQLException ex) {
            Logger.getLogger(AdminMna.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void setCurator(Curator cur,ResultSet result ){
        try {
            cur.setCuratorID(result.getString("curatorID"));
            cur.setCuratorName(result.getString("curatorName"));
            cur.setCuratorAddress(result.getString("curatorAddress"));
            cur.settotalStudent(result.getInt("TotalStudent"));
        } catch (SQLException ex) {
            Logger.getLogger(AdminMna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
