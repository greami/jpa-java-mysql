/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schollmark;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *This is a mark of a evalutarion
 * @author AMITH GRECA
 */
@Entity
@Table(name = "marktable")
public class Mark implements Serializable {
    
    
    private int idValutation;  //this is the key in database
    private int mark;

    public Mark() {
    }

    /**
     * set the id of evalutation
     * @param idValutation mu be unique because it is key in database
     */
    public void setIdValutation(int idValutation) {
        this.idValutation = idValutation;
    }

    /**
     * set the mark
     * @param mark a integer between 0 and 31included
     */
    public void setMark(int mark) {
        
        //little check od the value,  better way is to use an exception
        if (mark<0 | mark >31) { return;}
        
        this.mark = mark;
    }

    /**
     * 
     * @return the id of avalutation
     */
    @Id
    @Column(name = "idvalutation")
    public int getIdValutation() {
        return idValutation;
    }

    
    /**
     * 
     * @return the value of this evalutation 
     */
    @Column(name = "mark")
    public int getMark() {
        return mark;
    }
    
    
    

  
    @Override
    public String toString() {
        return "This is valunation:" + idValutation + " mark:"+mark;
    }
    
}
