/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.ac.AUCA.model;

import rw.ac.AUCA.dao.StudentDao;

/**
 *
 * @author N.Eric
 */
public class StudentInfo {
    
    private String student_Id;
    private String student_name;
    private String email;
    private int age;
    private String gender;
    private String faculty;
    private String depatment;
    
   
    

    public void setStudent_Id(String student_Id) {
        this.student_Id = student_Id;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setDepatment(String depatment) {
        this.depatment = depatment;
    }

    
    
    
    
    
    

    public String getStudent_Id() {
        return student_Id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDepatment() {
        return depatment;
    }

    

    public StudentInfo(String student_Id) {
        this.student_Id = student_Id;
    }

    public StudentInfo() {
    }

    public StudentInfo(String student_Id, String student_name, String email, int age, String gender, String faculty, String depatment) {
        this.student_Id = student_Id;
        this.student_name = student_name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.faculty = faculty;
        this.depatment = depatment;
    }

    
    

   
   
    
    
    
}
