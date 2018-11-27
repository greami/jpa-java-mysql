/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schollmark;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author AMITH GRECA
 */
@Entity
@Table(name = "studenttable" )

public class Student implements Serializable {
    
    
    private String name;
    private String surname;
    
    //this is the key 
    
    private String studentID;
    
    
    private List<Mark> markList;

    
    
    public Student() {
        markList= new ArrayList<Mark>();
       
        
    }    
    
    /**
     * Simple short method for define a student
     * @param name
     * @param surname
     * @param studentNumber 
     */
    public void initStudent(String name, String surname, String studentNumber) {
        this.name=name;
        this.surname=surname;
        this.studentID=studentNumber;
    }
    
    /**
     * set student name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set student surname
     * @param surname 
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * set the student id
     * This must be unique. this is going to be the key in database
     * @param studentID 
     */
    public void setSTUDENTID(String studentID) {
        this.studentID = studentID;
    }
    
    

    /**
     * 
     * @return name of student
     */
    @Column(name = "name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @return  surname od student
     */
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    
    /**
     * 
     * @return the personal id of the student. This is the key in fatabase
     */
    @Id
    @Column(name = "student_ID", unique = true)
    public String getStudentID() {
        return studentID;
    }

    
    

    /**
     * 
     * @return a list of mark of this student
     */
    @OneToMany
    public List<Mark> getMarkList() {
        return markList;
    }

    /**
     * 
     * @param markList list of mark of this student
     */
    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }
    
    /**
     * add a new mark for this student
     * @param mark a single mark for this student
     */
    public void addMark(Mark mark){
        this.markList.add(mark);
    }
    
    
    



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student Number: " + studentID ;
    }
    
}
