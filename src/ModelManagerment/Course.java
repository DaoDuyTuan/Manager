/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelManagerment;

import java.util.Date;

/**
 *
 * @author DuyTuan
 */
public class Course {
    private String courseID;
    private String courseName;
    private String courseAmount;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    public Course() {
    }

    public Course(String courseID, String courseName, String courseAmount) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseAmount = courseAmount;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseAmount() {
        return courseAmount;
    }

    public void setCourseAmount(String courseAmount) {
        this.courseAmount = courseAmount;
    }

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", courseName=" + courseName + ", courseAmount=" + courseAmount + '}';
    }
    
    
}
