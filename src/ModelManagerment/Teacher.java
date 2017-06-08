/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelManagerment;

/**
 *
 * @author ad
 */
public class Teacher {
    private String teacherID;
    private String teacherName;
    private String teacherAddress;

    public Teacher() {
    }

    
    public Teacher(String teacherID, String teacherName, String teacherAddress) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    @Override
    public String toString() {
        return "Teacher{" + "teacherID=" + teacherID + ", teacherName=" + teacherName + ", teacherAddress=" + teacherAddress + '}';
    }
    
    
    
    
}
