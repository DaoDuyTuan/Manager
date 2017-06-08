/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelManagerment;

/**
 *
 * @author DuyTuan
 */
public class Admin {
    private String name;
    private String ID;
    private String passWord;

    public Admin() {
    }

    public Admin(String name, String ID, String passWord) {
        this.name = name;
        this.ID = ID;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Admin{" + "name=" + name + ", ID=" + ID + ", passWord=" + passWord + ", curatorID=" + '}';
    }
    
    
    
}
