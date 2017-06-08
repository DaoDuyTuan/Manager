
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlManagement;

import ModelManagerment.Course;
import ModelManagerment.Curator;
import ModelManagerment.Student;
import ModelManagerment.Teacher;
import ModelManagerment.Class;
import Utinity.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author DuyTuan
 */
public class CuratorMna {
    public Set<Class> classSet = new HashSet<Class>();
    public boolean insertStudent(String mssv, String name, String address, String date, boolean gender,String password) {
        Connection conn = ConnectionDB.openDB();
        ResultSet result = null;
        PreparedStatement stm = null;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {

            Date dob = format.parse(date);
            stm = conn.prepareStatement("INSERT INTO Student(MSSV,studentName,studentAddress,DOB,curatorID,password,Gender) values(?,?,?,?,?,?,?)");
            stm.setString(1, mssv);
            stm.setString(2, name);
            stm.setString(3, address);
            stm.setDate(4, new java.sql.Date(dob.getTime()));
            stm.setString(5, "123");
            stm.setString(6, password);
            stm.setBoolean(7, gender);
            return stm.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stm, result);
        }
        return false;
    }

    public List<Student> viewStudent() {
        List<Student> listStudent = new ArrayList<>();
        Connection conn = ConnectionDB.openDB();
        ResultSet result = null;
        PreparedStatement stm = null;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        try {
            stm = conn.prepareCall("SELECT MSSV,studentName,studentAddress,DOB,Gender FROM Student");
            result = stm.executeQuery();
            while (result.next()) {
                Student std = new Student();
                selectStudentFromDB(result, std, format);
                boolean genderToBit = result.getBoolean("Gender");
                String genderStudent = checkBinaryIsString(genderToBit);
                std.setGender(genderStudent);

                listStudent.add(std);
            }
            return listStudent;
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateStudent(String ID, String name, String address, String DOB, String gender) {
        Connection conn = ConnectionDB.openDB();
        ResultSet result = null;
        PreparedStatement stm = null;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {

            stm = conn.prepareStatement("UPDATE Student SET studentName=?,studentAddress=?,DOB=?,Gender=? WHERE MSSV=?");
            stm.setString(1, name);
            stm.setString(2, address);
            Date dob = format.parse(DOB);
            stm.setDate(3, new java.sql.Date(dob.getTime()));
            boolean checkGender = checkStringIsBinary(gender);
            stm.setBoolean(4, checkGender);
            stm.setString(5, ID);

            if (stm.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stm, result);
        }
        return false;

    }

    public boolean deleteStudent(String mssv) {
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        try {
            selectStatement = conn.prepareStatement("DELETE FROM Student WHERE MSSV = ?");
            selectStatement.setString(1, mssv);
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

    public Student searchStudent(String mssv) {
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        Student std = new Student();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {

            selectStatement = conn.prepareStatement("SELECT MSSV,studentName,studentName,studentAddress,DOB,Gender FROM Student WHERE MSSV = ?");
            selectStatement.setString(1, mssv);
            resultFromSelectStatement = selectStatement.executeQuery();
            if (resultFromSelectStatement.next()) {
                selectStudentFromDB(resultFromSelectStatement, std, format);
                String genderToString = checkBinaryIsString(resultFromSelectStatement.getBoolean("Gender"));
                std.setGender(genderToString);

                return std;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        return null;
    }

    public List<Student> viewDetailStudent(String mssv) {
        List<Student> listStudent = null;
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;

        try {
            selectStatement = conn.prepareStatement("SELECT Student.MSSV,studentName,"
                    + "Course.courseID,courseName FROM CourseStudent JOIN Student on Student.MSSV = CourseStudent.MSSV "
                    + "join Course on Course.courseID = CourseStudent.CourseID WHERE CourseStudent.MSSV=?");
            selectStatement.setString(1, mssv);
            resultFromSelectStatement = selectStatement.executeQuery();
            if(resultFromSelectStatement.next()){
                listStudent = new ArrayList<>();
            }
            while (resultFromSelectStatement.next()) {
                Student std = new Student();
                std.setMSSV(resultFromSelectStatement.getString("MSSV"));
                std.setStudentName(resultFromSelectStatement.getString("studentName"));
                String courseID = resultFromSelectStatement.getString("courseID");
                String courseName = resultFromSelectStatement.getString("courseName");
                std.setCurator(new Curator(courseID, courseName, null, 0, null));
                listStudent.add(std);
            }
            return listStudent;

        } catch (Exception ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void selectStudentFromDB(ResultSet resultFromSelectStatement, Student std, SimpleDateFormat format) {
        try {
            std.setMSSV(resultFromSelectStatement.getString("MSSV"));
            std.setStudentName(resultFromSelectStatement.getString("studentName"));
            std.setStudentAddress(resultFromSelectStatement.getString("studentAddress"));
            String dob = format.format(resultFromSelectStatement.getDate("DOB"));
            std.setDateOfBirth(dob);
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean checkStringIsBinary(String gender) {
        if (gender == "Male") {
            return true;
        }
        return false;
    }

    public static String checkBinaryIsString(boolean gender) {
        if (gender) {
            return "Male";
        }
        return "Female";
    }
    public boolean insertCourse(String id,String name,int amount){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        
        try {
            
            selectStatement = conn.prepareStatement("INSERT INTO Course(courseID,courseName,amount,curatorID) VALUES (?,?,?,?)");
            selectStatement.setString(1, id);
            selectStatement.setString(2, name);
            selectStatement.setInt(3, amount);
            selectStatement.setString(4, "123");
            if(selectStatement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        return false;
    }
    public List<Course> viewCourse(){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        List<Course> list = new ArrayList<>();
        try {
            selectStatement = conn.prepareStatement("SELECT courseID,courseName,amount FROM Course");
            resultFromSelectStatement = selectStatement.executeQuery();
            
            while(resultFromSelectStatement.next()){
                Course course = new Course();
                course.setCourseID(resultFromSelectStatement.getString("courseID"));
                course.setCourseName(resultFromSelectStatement.getString("courseName"));
                course.setCourseAmount(resultFromSelectStatement.getInt("amount")+"");
                
                list.add(course);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        
        return null;
    }
    public boolean updateCourse(String id, String name, String amount){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        int courseAmount = Integer.parseInt(amount);
        try {
            selectStatement = conn.prepareStatement("UPDATE course SET courseName = ?, amount = ? WHERE courseID = ?");
            selectStatement.setString(1, name);
            selectStatement.setInt(2, courseAmount);
            selectStatement.setString(3, id);

            if(selectStatement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    public boolean insertTeacher(String id, String name,String address){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        
        try {
            selectStatement = conn.prepareStatement("INSERT INTO teacher(teacherID,teacherName,teacherAddress,curatorID) VALUES(?,?,?,?)");
            selectStatement.setString(1, id);
            selectStatement.setString(2, address);
            selectStatement.setString(3, name);
            selectStatement.setString(4, "123");
            
            if(selectStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        return false;
    }
    public boolean deleteCourse(String id){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        
        try {
            selectStatement = conn.prepareStatement("DELETE FROM course WHERE courseID =? ");
            selectStatement.setString(1, id);
            
            if(selectStatement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        
        return false;
    }
    public boolean deleteTeacher(String id){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        
        try {
            selectStatement = conn.prepareStatement("DELETE FROM teacher WHERE teacherID =? ");
            selectStatement.setString(1, id);
            
            if(selectStatement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        
        return false;
    }
    
    public List<Teacher> viewTeacher(){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        List<Teacher> list = new ArrayList<>();
        try {
            selectStatement = conn.prepareStatement("SELECT teacherID,teacherName,teacherAddress FROM teacher");
            resultFromSelectStatement = selectStatement.executeQuery();
            
            while(resultFromSelectStatement.next()){
                Teacher teacher = new Teacher();
                teacher.setTeacherID(resultFromSelectStatement.getString("teacherID"));
                teacher.setTeacherName(resultFromSelectStatement.getString("teacherName"));
                teacher.setTeacherAddress(resultFromSelectStatement.getString("teacherAddress"));
                
                list.add(teacher);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        return null;
    }
    public boolean updateTeacher(String id,String name,String address){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        
        try {
            selectStatement = conn.prepareStatement("UPDATE teacher SET teacherName=?,teacherAddress=? WHERE teacherID=?");
            selectStatement.setString(1, name);
            selectStatement.setString(2, address);
            selectStatement.setString(3, id);
            if(selectStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public Teacher viewTeacherDetail(String id){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        Teacher teacher = new Teacher();
        try {
            selectStatement = conn.prepareStatement("SELECT teacherID,teacherName,teacherAddress FROM teacher WHERE teacherID=?");
            selectStatement.setString(1, id);
            resultFromSelectStatement = selectStatement.executeQuery();
            if(resultFromSelectStatement.next()){
               teacher.setTeacherID(resultFromSelectStatement.getString("teacherID"));
               teacher.setTeacherName(resultFromSelectStatement.getString("teacherName"));
               teacher.setTeacherAddress(resultFromSelectStatement.getString("teacherAddress"));
               return teacher;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        return null;
    }
    public void viewClass(){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        try {
            selectStatement = conn.prepareStatement("SELECT classID,studyTime,"
                    + "roomAddress,studentTotal,teacherID,class.courseID,courseName FROM class"
                    + " JOIN course ON class.courseID = course.courseID");
            resultFromSelectStatement = selectStatement.executeQuery();
            
            while(resultFromSelectStatement.next()){
                Class cla = new Class();
                cla.setClassID(resultFromSelectStatement.getString("classID"));
                cla.setStudyTime(resultFromSelectStatement.getString("studyTime"));
                cla.setRoomAddress(resultFromSelectStatement.getString("roomAddress"));
                cla.setStudentTotal(resultFromSelectStatement.getInt("studentTotal"));
                cla.setTeacherID(resultFromSelectStatement.getString("teacherID"));
                cla.setCourseID(resultFromSelectStatement.getString("courseID"));
                cla.setCourseName(resultFromSelectStatement.getString("courseName"));
                
                classSet.add(cla);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean insertClass(String id,String studyTime,String roomAddress,int total,String teacherID,String courseID ){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        Class cla = new Class(id, studyTime, roomAddress, total, teacherID, courseID, null);

        try {
            selectStatement = conn.prepareStatement("INSERT INTO class(classID,studyTime,"
                    + "roomAddress,studentTotal,curatorID,teacherID,courseID) VALUES(?,?,?,?,?,?,?)");
            selectStatement.setString(1, id);
            selectStatement.setString(2, studyTime);
            selectStatement.setString(3, roomAddress);
            selectStatement.setInt(4, total);
            selectStatement.setString(5, "123");
            selectStatement.setString(6, teacherID);
            selectStatement.setString(7, courseID); 
            
            
            if(!classSet.contains(cla)){
                return selectStatement.executeUpdate() > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionDB.closeConnection(conn, selectStatement, resultFromSelectStatement);
        }
        return false;
    }
    public boolean deleteClass(String id){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        
        try {
            selectStatement = conn.prepareStatement("DELETE FROM Class WHERE classID = ?");
            selectStatement.setString(1, id);
            
            if(selectStatement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean updateClass(String id,String studyTime,String room,int total,String teacherID,String courseID){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        
        try {
            selectStatement = conn.prepareStatement("UPDATE class SET studyTime = ?,roomAddress = ?,studentTotal = ?,teacherID = ?,courseID = ? WHERE classID = ?");
            selectStatement.setString(1, studyTime);
            selectStatement.setString(2, room);
            selectStatement.setInt(3, total);
            selectStatement.setString(4, teacherID);
            selectStatement.setString(5, courseID);
            selectStatement.setString(6, id);
            
            if(selectStatement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public Class retrieveClassByID(String id){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        Class cla = new Class();

        try {
            selectStatement = conn.prepareStatement("SELECT classID,studyTime,"
                    + "roomAddress,studentTotal,teacherID,class.courseID FROM class"
                    + " WHERE classID = ?");
            selectStatement.setString(1, id);
            resultFromSelectStatement = selectStatement.executeQuery();
            
            if(resultFromSelectStatement.next()){
                cla.setClassID(resultFromSelectStatement.getString("classID"));
                cla.setStudyTime(resultFromSelectStatement.getString("studyTime"));
                cla.setRoomAddress(resultFromSelectStatement.getString("roomAddress"));
                cla.setStudentTotal(resultFromSelectStatement.getInt("studentTotal"));
                cla.setTeacherID(resultFromSelectStatement.getString("teacherID"));
                cla.setCourseID(resultFromSelectStatement.getString("courseID"));
            }
            return cla;
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
