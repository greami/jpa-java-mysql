/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schollmark;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
/**
 *
 * @author AMITH GRECA
 * 
 * This class deal with conneting with the database
 */
public class Controller {
    
    private final EntityManagerFactory emf;


    public Controller() {
        
        //this objcet will create a new enity factory usefull in future
        this.emf = Persistence.createEntityManagerFactory("MyPer");
    }
    
    
    /**
     * this method add a student in database,
     * if is is not present or if is present
     * @param student 
     */
    public void addStudent(Student student){
        
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        
        //case student already in database
        if( isStudentInDb(student.getStudentID())) {
        em.merge(student);
        em.getTransaction().commit();        
        em.close();
        return;
        }
        
        //case student non in database
        em.persist(student);
        em.getTransaction().commit();        
        em.close();
    }
    
    
    /**
     * Check if a student id in database
     * @param studentID the key of student
     * @return true if is presente, false in not
     */
    public boolean isStudentInDb(String studentID){
        EntityManager em =emf.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        
        Root<Student> root = cq.from(Student.class);  

        cq.where( cb.equal(    (root.get("studentID"))    , studentID));
        
        Query q = em.createQuery(cq);
        
        
        List list = q.getResultList();
       
        if(list.isEmpty()) {return false;}
        else { return true;}
    }
    
    
    /**
     * Get a student in database
     * @param studentID the key
     * @return the objcet student in is in database or null in is not in
     */
    public Student getStudentFromID(String studentID){
        if(!this.isStudentInDb(studentID)) { return null;}
        
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        
        Root<Student> root = cq.from(Student.class);  

        cq.where( cb.equal(    (root.get("studentID"))    , studentID));
        
        Query q = em.createQuery(cq);
        
        return  (Student) q.getSingleResult();
    }
    
    
    /**
     * this method link a mark to a student in the database
     * @param studentID id of student who had this mark
     * @param mark the object mark of this student
     */
    public void addMarkToStudent(String studentID, Mark mark){
        
        //check if student exist in database
        if (! this.isStudentInDb(studentID) ) {return;}
        
        //check if mark already esist in database
        if ( this.isMarkInDB(mark.getMark() ) ) {return;}
        
        Student student = this.getStudentFromID(studentID);
        
        student.addMark(mark);        
        
        this.addStudent(student);
        
    }
    
    
    /**
     * this method add a mark in database
     * @param mark 
     */
    public void addMark(Mark mark){
       EntityManager em= emf.createEntityManager();
       
       //case mark in database
       if (this.isMarkInDB(mark.getMark())){
           em.getTransaction().begin();        
        
            em.merge(mark);
            em.getTransaction().commit();
        
            em.close();  
           
       }
       
       //case mark not in database
        em.getTransaction().begin();        
        
        em.persist(mark);
        em.getTransaction().commit();
        
        em.close();
        
    }
    
    
    /**
     * this method check if a mark is in the database
     * @param idMark the key in database
     * @return true if the mark is in database, false if not
     */
    public boolean isMarkInDB(int idMark){
        EntityManager em =emf.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        
        Root<Student> root = cq.from(Mark.class);  

        cq.where( cb.equal(    (root.get("idValutation"))    , idMark));
        
        Query q = em.createQuery(cq);
        
        List list = q.getResultList();
        
        if(list.isEmpty()) {return false;}
        else { return true;}
    }
    
    
}
