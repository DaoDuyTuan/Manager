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
public class Course_Student {
    private String courseID;
    private String studentID;
    private Date date;

    public Course_Student() {
    }

    public Course_Student(String courseID, String studentID, Date date) {
        this.courseID = courseID;
        this.studentID = studentID;
        this.date = date;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
