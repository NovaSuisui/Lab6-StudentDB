/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import utilities.DatabaseDriver;
import utilities.DatabaseHandler;

/**
 *
 * @author SK
 */
public class StudentTable {
    
    public static int updateStudent(DatabaseHandler dbHandler, Student std) {
        String sql = "update student set name=?, gpa=? where id=?";
        int rowUpdated;
        try {
            rowUpdated = dbHandler.update(sql, std.getStudentName(), std.getStudentGPA(), std.getStudentID());
        }
        catch (SQLException ex ) {
            
            rowUpdated = 0;
        }
        
        return rowUpdated;
    }
     public static int removeStudent(DatabaseHandler dbHandler, Student std) {
         String sql ="delete from student where id = ?";
         
         int rowDeleted;
         try {
            rowDeleted = dbHandler.update(sql, std.getStudentID());
         }
         catch (SQLException ex ) {
             rowDeleted = 0;
         }
        return rowDeleted;
    }
    public static int insertStudent(DatabaseHandler dbHandler, Student std) {
         String sql = "insert into student (id, name, gpa)" + 
               " values (?,?,?)";
         
         int rowInserted;
         try {
             rowInserted = dbHandler.update(sql, std.getStudentID(), std.getStudentName(), std.getStudentGPA());
         }
         catch(SQLException ex ) {
             rowInserted = 0;
         }
         return rowInserted;
    }
}
