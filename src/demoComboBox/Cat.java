/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoComboBox;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author ad
 */
public class Cat implements Animal{
    private String name;
    private int age;
    public static int count;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }
    @Override
    public void speak(){
        System.out.println("name: "+name);
        System.out.println("age: "+age);
    }
    public int total(){
        return count;
    }
    
    public static void main(String[] args) {
        int ret= 0;
        Random rB = new Random(100);
        rB.hashCode();
        for (int i = 0; i < 10; i++) {
            ret = rB.nextInt(100);
            System.out.println("ret = "+ret);
        }
        System.out.println("--------------");
        int ret2 = 0;
        Random ra = new Random(100);
        for (int i = 0; i < 10; i++) {
            ret2 = ra.nextInt(100);
            System.out.println("ret = "+ret);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        //hash = 17 * hash + this.age;
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
//        if (this.age != other.age) {
//            return false;
//        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cat{" + "name=" + name + ", age=" + age + '}';
    }
    
    
}
