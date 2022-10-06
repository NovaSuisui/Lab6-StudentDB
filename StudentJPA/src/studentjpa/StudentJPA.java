/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package studentjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author SK
 */
public class StudentJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student std1 = new Student(1, "abc", 3.5);
        Student std2 = new Student(2, "def", 2.7);
        Student std3 = new Student(3, "ghi", 3.8);
        Student std4 = new Student(4, "jkl", 3.65);
        Student std5 = new Student(5, "mno", 2.9);
        
        //insert
        System.out.println("insert");
        StudentTable.insertStudent(std1);
        StudentTable.insertStudent(std2);
        StudentTable.insertStudent(std3);
        StudentTable.insertStudent(std4);
        StudentTable.insertStudent(std5);
        
        //update
        System.out.println("update");
        std1.setName("xyz");
        std2.setGpa(3.95);
        std3.setName("uvw");
        std3.setGpa(3.85);
        StudentTable.updateStudent(std1);
        StudentTable.updateStudent(std2);
        StudentTable.updateStudent(std3);
        
        //remove
        System.out.println("remove");
        StudentTable.removeStudent(std5);
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
