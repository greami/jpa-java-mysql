/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schollmark;


/**
 *
 * @author AMITH GRECA
 * 
 * This is a test for put our classes in the database!
 */
public class Test {
    
    public static void main(String[] args) {
        
        //Some student
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();
        
        
        //initialization of student
        s1.initStudent("Miky", "Mouse", "sn001");
        s2.initStudent("Tom", "Cruise","sn002");
        s3.initStudent("Harry", "Potter", "sn003");
        s4.initStudent("Laura", "Palmer", "sn004");
        
        //build the object which is connected to database
        Controller cont = new Controller();
        
        //put the student in  database
        cont.addStudent(s1);
        cont.addStudent(s2);
        cont.addStudent(s3);
        cont.addStudent(s4);
        
        
        //creation  some evalutation
        Mark m1 = new Mark();
        m1.setIdValutation(1);
        m1.setMark(18);
        
        Mark m2 = new Mark();
        m2.setIdValutation(2);
        m2.setMark(10);        
        
        Mark m3 = new Mark();
        m3.setIdValutation(3);
        m3.setMark(31);
        
        Mark m4 = new Mark();
        m4.setIdValutation(4);
        m4.setMark(28);
        
        //put my valutation in database
        cont.addMark(m1);
        cont.addMark(m2);
        cont.addMark(m3);
        cont.addMark(m4);
        
        //now i link my valutation to my student using the Controller object
        cont.addMarkToStudent("sn001", m1);
        cont.addMarkToStudent("sn002", m2);
        cont.addMarkToStudent("sn003", m3);
        cont.addMarkToStudent("sn004", m4);

//      now in the database whe have 3 tables:
//      studenttable
//      marktable
//      studenttable_marktable autobuilded!
//      Check the Database!      


       
    }
    
}
