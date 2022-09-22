/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjdbc;

/**
 *
 * @author SK
 */
public class Student {

    public Student() {
    }
    
    private int studentID;
    private String studentName;
    private double studentGPA;

    public Student(int studentID, String studentName, double studentGPA) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentGPA = studentGPA;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentGPA(double studentGPA) {
        this.studentGPA = studentGPA;
    }

    public double getStudentGPA() {
        return studentGPA;
    }

    
}
