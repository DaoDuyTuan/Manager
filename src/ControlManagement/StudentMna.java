
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlManagement;

import ModelManagerment.Course;
import ModelManagerment.Curator;
import ModelManagerment.Student;
import Utinity.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuyTuan
 */
public class StudentMna {
    public static Map<String,Course> listCourseRegistered = new HashMap<>();
    public static Set<String> checkCourseIDWhenInsertDB = new HashSet();
    public static Set<String> listCourseWhenLoadDB = new HashSet();
    public List<Course> viewCourse(){
        List<Course> listCourse = new ArrayList<>();
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        
        try {
            selectStatement = conn.prepareStatement("SELECT courseID,courseName,amount FROM Course");
            resultFromSelectStatement = selectStatement.executeQuery();
            while(resultFromSelectStatement.next()){
                Course course = new Course();
                course.setCourseID(resultFromSelectStatement.getString("courseID"));
                course.setCourseName(resultFromSelectStatement.getString("courseName"));
                course.setCourseAmount(resultFromSelectStatement.getInt("amount")+"");
                
                listCourse.add(course);
            }
            return listCourse;
        } catch (SQLException ex) {
            Logger.getLogger(StudentMna.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void registerCourse(String courseID){//lay ra course tu Course table luu vao Map.Sau do hien thi lai bang
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        try {
            selectStatement = conn.prepareStatement("SELECT courseID,courseName,amount FROM Course WHERE courseID = ?");
            selectStatement.setString(1, courseID);
            resultFromSelectStatement = selectStatement.executeQuery();
            
            if(resultFromSelectStatement.next()){
                Course course = new Course();
                course.setCourseID(resultFromSelectStatement.getString("courseID"));
                course.setCourseName(resultFromSelectStatement.getString("courseName"));
                course.setCourseAmount(resultFromSelectStatement.getInt("amount")+"");
                listCourseRegistered.put(courseID,course);
                checkCourseIDWhenInsertDB.add(course.getCourseID());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
    }
    public boolean insertCourseOfStudent(String courseID,String studentID,String date){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            selectStatement = conn.prepareStatement("INSERT INTO CourseStudent(CourseID,MSSV,Date) VALUES(?,?,?)");
            selectStatement.setString(1, courseID);
            selectStatement.setString(2, studentID);
            Date dateFormat = format.parse(date);
            selectStatement.setDate(3, new java.sql.Date(dateFormat.getTime()));
            
            if(selectStatement.executeUpdate() > 0){
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        return false;
    }
    public List<Course> viewCourseByMSSV(String mssv){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        List<Course> list = new ArrayList<>();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        try {
            selectStatement = conn.prepareStatement("SELECT Course.courseID,courseName,amount,Date FROM Course "
                    + "JOIN CourseStudent ON Course.courseID=CourseStudent.CourseID WHERE MSSV=?");
            selectStatement.setString(1, mssv);
            resultFromSelectStatement = selectStatement.executeQuery();
            while(resultFromSelectStatement.next()){
                Course cur = new Course();
                String courseID = resultFromSelectStatement.getString("courseID");
                cur.setCourseID(resultFromSelectStatement.getString("courseID"));
                cur.setCourseName(resultFromSelectStatement.getString("courseName"));
                cur.setCourseAmount(resultFromSelectStatement.getInt("amount")+"");
                String date = formatDate.format(resultFromSelectStatement.getDate("Date"));
                cur.setDate(date);
                
                listCourseRegistered.put(courseID,cur);
                listCourseWhenLoadDB.add(cur.getCourseID());
                list.add(cur);
            }
            return list;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        return null;
    }
    public boolean deleteStudent(String courseID, String mssv) {
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        try {
            selectStatement = conn.prepareStatement("DELETE FROM CourseStudent WHERE CourseID = ? AND MSSV = ?");
            selectStatement.setString(1, courseID);
            selectStatement.setString(2, mssv);
            if (selectStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminMna.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        return false;
    }
    public List<Course> viewCourseStudent(){
        Connection conn = ConnectionDB.openDB();
        List<Course> list = new ArrayList<>();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        try {
            selectStatement = conn.prepareStatement("SELECT Course.courseID,courseName,amount,Date FROM Course "
                    + "JOIN CourseStudent ON Course.courseID=CourseStudent.CourseID ");
            resultFromSelectStatement = selectStatement.executeQuery();
            while(resultFromSelectStatement.next()){
                Course cur = new Course();
                String courseID = resultFromSelectStatement.getString("CourseID");
                cur.setCourseID(resultFromSelectStatement.getString("CourseID"));
                cur.setCourseName(resultFromSelectStatement.getString("courseName"));
                cur.setCourseAmount(resultFromSelectStatement.getInt("amount")+"");
                String date = formatDate.format(resultFromSelectStatement.getDate("Date"));
                cur.setDate(date);
                
                list.add(cur);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        return null;
    }
    
        
}
