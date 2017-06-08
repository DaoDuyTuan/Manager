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
public class Student {
    private String MSSV;
    private String studentName;
    private String studentAddress;
    private String DateOfBirth;
    private String gender;
    private int courseTotal;
    private Curator curator;

    public Student() {
    }

    public Student(String MSSV, String studentName, String studentAddress, String DateOfBirth,String gender) {
        this.MSSV = MSSV;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.DateOfBirth = DateOfBirth;
        this.gender = gender;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" + "MSSV=" + MSSV + ", studentName=" + studentName + ", studentAddress=" + studentAddress + ", DateOfBirth=" + DateOfBirth + '}';
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCourseTotal() {
        return courseTotal;
    }

    public void setCourseTotal(int courseTotal) {
        this.courseTotal = courseTotal;
    }

    public Curator getCurator() {
        return curator;
    }

    public void setCurator(Curator curator) {
        this.curator = curator;
    }
    
    
    
}
