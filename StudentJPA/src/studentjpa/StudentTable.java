/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author SK
 */
public class StudentTable {
    public static void insertStudent(Student std) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Insert data...");
        System.out.println("Data : "+std.getId());
        try {
            em.persist(std);
            em.getTransaction().commit();
            System.out.println("Insert Complete!!");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Insert Incomplete");
        } finally {
            em.close();
        }
    }
    public static void updateStudent(Student std) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, std.getId());
        fromDb.setName(std.getName());
        fromDb.setGpa(std.getGpa());
        em.getTransaction().begin();
        System.out.println("Updat data...");
        System.out.println("Data : "+std.getId());
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
            System.out.println("Update Complete!!");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Update Incomplete");
        } finally {
            em.close();
        }
    }
    public static Student findStudentById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        Student emp = em.find(Student.class, id);
        em.close();
        return emp;
    }
    public static List<Student> findAllStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        List<Student> empList = (List<Student>) em.createNamedQuery("Student.findAll").getResultList();
        em.close();
        return empList;
    }
    public static List<Student> findStudentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Student.findByName");
        query.setParameter("name", name);
        List<Student> empList = (List<Student>) query.getResultList();
        em.close();
        return empList;
    }
    public static void removeStudent(Student std) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, std.getId());
        em.getTransaction().begin();
        System.out.println("Remove data...");
        System.out.println("Data : "+std.getId());
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
            System.out.println("Remove Complete!!");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Remove Inomplete");
        } finally {
            em.close();
        }
                
    }
}
