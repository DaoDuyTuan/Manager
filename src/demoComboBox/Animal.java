/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoComboBox;

/**
 *
 * @author ad
 */
public interface Animal {
    static void go(){
        System.out.println("hehe");
    }
    default void move(){
        System.out.println("haha");
    }
    void speak();
}
