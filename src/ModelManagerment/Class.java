/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelManagerment;

import java.util.Objects;

/**
 *
 * @author ad
 */
public class Class {
    private String classID;
    private String studyTime;
    private String roomAddress;
    private int studentTotal;
    private String teacherID;
    private String courseID;
    private String courseName;

    public Class() {
    }

    public Class(String classID, String studyTime, String roomAddress, int studentTotal, String teacherID, String courseID,String courseName) {
        this.classID = classID;
        this.studyTime = studyTime;
        this.roomAddress = roomAddress;
        this.studentTotal = studentTotal;
        this.teacherID = teacherID;
        this.courseID = courseID;
        this.courseName = courseName;
    }
    
    
    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }

    public String getRoomAddress() {
        return roomAddress;
    }

    public void setRoomAddress(String roomAddress) {
        this.roomAddress = roomAddress;
    }

    public int getStudentTotal() {
        return studentTotal;
    }

    public void setStudentTotal(int studentTotal) {
        this.studentTotal = studentTotal;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.courseID);
        hash = 47 * hash + Objects.hashCode(this.studyTime);
        hash = 47 * hash + Objects.hashCode(this.teacherID);
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
        final Class other = (Class) obj;
        if (!Objects.equals(this.courseID, other.courseID)) {
            return false;
        }
        if (!Objects.equals(this.studyTime, other.studyTime)) {
            return false;
        }
        if (!Objects.equals(this.teacherID, other.teacherID)) {
            return false;
        }
        return true;
    }
    
    
    
}
