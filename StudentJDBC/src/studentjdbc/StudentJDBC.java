/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjdbc;

import java.sql.SQLException;
import java.util.ArrayList;

import utilities.DatabaseDriver;
import utilities.DatabaseHandler;

/**
 *
 * @author SK
 */
public class StudentJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/student";
        String user = "app";
        String passwd = "app";
        DatabaseDriver dbDriver = new DatabaseDriver(driver, url, user, passwd);
        DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
        Student std1 = new Student(1, "abc", 3.5);
        Student std2 = new Student(2, "def", 2.7);
        Student std3 = new Student(3, "ghi", 3.8);
        Student std4 = new Student(4, "jkl", 3.65);
        Student std5 = new Student(5, "mno", 2.9);
        
        //insert
        System.out.println("insert");
        StudentTable.insertStudent(dbHandler, std1);
        StudentTable.insertStudent(dbHandler, std2);
        StudentTable.insertStudent(dbHandler, std3);
        StudentTable.insertStudent(dbHandler, std4);
        StudentTable.insertStudent(dbHandler, std5);
        
        //update
        System.out.println("update");
        std1.setStudentName("xyz");
        std2.setStudentGPA(3.95);
        std3.setStudentName("uvw");
        std3.setStudentGPA(3.85);
        StudentTable.updateStudent(dbHandler, std1);
        StudentTable.updateStudent(dbHandler, std2);
        StudentTable.updateStudent(dbHandler, std3);
        
        //remove
        System.out.println("remove");
        StudentTable.removeStudent(dbHandler, std5);
        
        dbHandler.closeConnection();
    }
    
    
}
