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
public class Curator {
    private String curatorID;
    private String curatorName;
    private String curatorAddress;
    private int totalStudent;
    private String countCuratorID;


    public Curator() {
    }

    public Curator(String curatorID, String curatorName, String curatorAddress, int totalStudent, String course_ID) {
        this.curatorID = curatorID;
        this.curatorName = curatorName;
        this.curatorAddress = curatorAddress;
        this.totalStudent = totalStudent;
        this.countCuratorID = course_ID;
    }

    public String getCuratorID() {
        return curatorID;
    }

    public void setCuratorID(String curatorID) {
        this.curatorID = curatorID;
    }

    public String getCuratorName() {
        return curatorName;
    }

    public void setCuratorName(String curatorName) {
        this.curatorName = curatorName;
    }

    public String getCuratorAddress() {
        return curatorAddress;
    }

    public void setCuratorAddress(String curatorAddress) {
        this.curatorAddress = curatorAddress;
    }

    public int gettotalStudent() {
        return totalStudent;
    }

    public void settotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }

    public String getcountCuratorID() {
        return countCuratorID;
    }

    public void setcountCuratorID(String course_ID) {
        this.countCuratorID = course_ID;
    }

    @Override
    public String toString() {
        return "Curator{" + "curatorID=" + curatorID + ", curatorName=" + curatorName + ", curatorAddress=" + curatorAddress + ", student_ID=" + totalStudent + ", course_ID=" + countCuratorID + '}';
    }
    
    
}
