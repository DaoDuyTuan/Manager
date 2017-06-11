/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoComboBox;

import ControlManagement.CuratorMna;
import Utinity.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import ModelManagerment.Class;
/**
 *
 * @author ad
 */
public class Cat {
    private String classID;
    private Time startTime;
    private Time endTime;
    private String teacherID;

    public Cat(String classID, String startTime, String endTime, String teacherID) {
        this.classID = classID;
        this.startTime = convertStringToTime(startTime);
        this.endTime = convertStringToTime(endTime);
        this.teacherID = teacherID;
    }

    private Cat() {

    }

    
    
    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.classID);
        //hash = 59 * hash + Objects.hashCode(this.startTime);
//        hash = 59 * hash + Objects.hashCode(this.endTime);
        hash = 59 * hash + Objects.hashCode(this.teacherID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cat other = (Cat) obj;
        if (!Objects.equals(this.classID, other.classID)) {
            return false;
        }
        if (!Objects.equals(this.teacherID, other.teacherID)) {
            return false;
        }
//        if (!Objects.equals(this.startTime, other.startTime)) {
//            return false;
//        }
//        if (!Objects.equals(this.endTime, other.endTime)) {
//            return false;
//        }
        if (other.startTime.compareTo(this.startTime) <= 0 && other.startTime.compareTo(this.endTime) >=0) {
            return false;
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        DateFormat formmater = new SimpleDateFormat("HH:mm");
        String str1 = "10:00";
        String str2 = "12:00";
        
        try {
            Time time1 = new Time(formmater.parse(str1).getTime());
            Time time2 = new Time(formmater.parse(str2).getTime());
            
            if(time1.after(time2)){
                System.out.println("hehe");
            }
        } catch (ParseException ex) {
            Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public Time convertStringToTime(String cat){
        DateFormat formatter  = new SimpleDateFormat("HH:mm");
        try {
            Time time = new Time(formatter.parse(cat).getTime());
            return time;
        } catch (ParseException ex) {
            Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Class viewClass(){
        Connection conn = ConnectionDB.openDB();
        ResultSet resultFromSelectStatement = null;
        PreparedStatement selectStatement = null;
        DateFormat formatter  = new SimpleDateFormat("HH:mm");
        Class cla = new Class();

        try {
            selectStatement = conn.prepareStatement("SELECT classID,StartTime,EndTime,"
                    + "roomAddress,studentTotal,teacherID,class.courseID,courseName FROM class"
                    + " JOIN course ON class.courseID = course.courseID WHERE classID = ?");
            selectStatement.setString(1, "C1405l");
            resultFromSelectStatement = selectStatement.executeQuery();
            
            if(resultFromSelectStatement.next()){
                String sTime = formatter.format(resultFromSelectStatement.getTime("StartTime").getTime());
                String eTime = formatter.format(resultFromSelectStatement.getTime("EndTime").getTime());
                cla.setClassID(resultFromSelectStatement.getString("classID"));
                cla.setStartTime(sTime); 
                cla.setEndTime(eTime);
                cla.setRoomAddress(resultFromSelectStatement.getString("roomAddress"));
                cla.setStudentTotal(resultFromSelectStatement.getInt("studentTotal"));
                cla.setTeacherID(resultFromSelectStatement.getString("teacherID"));
                cla.setCourseID(resultFromSelectStatement.getString("courseID"));
                cla.setCourseName(resultFromSelectStatement.getString("courseName"));
            }
            return cla;
        } catch (SQLException ex) {
            Logger.getLogger(CuratorMna.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public String toString() {
        return "Cat{" + "classID=" + classID + ", startTime=" + startTime + ", endTime=" + endTime + ", teacherID=" + teacherID + '}';
    }
    
}
