/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.ac.AUCA.dao;

import java.awt.HeadlessException;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import rw.ac.AUCA.model.StudentInfo;

/**
 *
 * @author N.Eric
 */
public class StudentDao {
    
    
    String jdbcUrl="jdbc:postgresql://localhost:5432/Student";
    String dbUsername="postgres";
    String dbPassword="0000";
   
    public int registerStudent(StudentInfo studentinfo){
        
        String registerSql=" INSERT INTO students  (student_id,student_name, email,gender,faculty,department,age) VALUES (?,?,?,?,?,?,?)";
        try {
            int rowsAffected;
            try (Connection conToRegister = DriverManager.getConnection(jdbcUrl,dbUsername,dbPassword)) {
                PreparedStatement statToRegister=conToRegister.prepareStatement(registerSql);
                statToRegister.setString(1,studentinfo.getStudent_Id());
                statToRegister.setString(2, studentinfo.getStudent_name());
                statToRegister.setString(3, studentinfo.getEmail());
                
                statToRegister.setString(4, studentinfo.getGender());
                statToRegister.setString(5, studentinfo.getFaculty());
                statToRegister.setString(6, studentinfo.getDepatment());
                statToRegister.setInt(7, studentinfo.getAge());
                rowsAffected = statToRegister.executeUpdate();
            }
            
        
            return rowsAffected;
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Database Error"+ e.getMessage());
            return 0;
        }
        
    }
    public StudentInfo searchStudent(StudentInfo studentDetails){
        
        
        String searchStudentBeforeDeleteSql=" SELECT student_id,student_name, email,age,gender,faculty,department FROM students WHERE student_id=?";
        try {
             Connection conTosearchBeforeDelete=DriverManager.getConnection(jdbcUrl,dbUsername,dbPassword);
            PreparedStatement statToseachBeforeDelete=conTosearchBeforeDelete.prepareStatement(searchStudentBeforeDeleteSql);
            statToseachBeforeDelete.setString(1,studentDetails.getStudent_Id());
            ResultSet resToSearchBeforeDele=statToseachBeforeDelete.executeQuery();
            
            if (resToSearchBeforeDele.next()) {
                
                studentDetails.setStudent_Id(resToSearchBeforeDele.getString("student_id"));
                studentDetails.setStudent_name(resToSearchBeforeDele.getString("student_name"));
                studentDetails.setEmail(resToSearchBeforeDele.getString("email"));
              studentDetails.setAge(resToSearchBeforeDele.getInt("age"));
              studentDetails.setGender(resToSearchBeforeDele.getString("gender"));
              studentDetails.setFaculty(resToSearchBeforeDele.getString("faculty"));
              studentDetails.setDepatment(resToSearchBeforeDele.getString("department"));
        return studentDetails;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Database Error"+ e.getMessage());
        }
        return null;
           
    }
    
    public int deleteStudent(StudentInfo studentInfo) {
        
                
                String deleteStudentAfterFoundSql=" DELETE FROM students WHERE student_id=?";
                try {
                    int rowsAffected;
                     Connection conToDeleteStudentAfterFound = DriverManager.getConnection(jdbcUrl,dbUsername,dbPassword);
                     
                        PreparedStatement statToDeleteStudentAfterFound=conToDeleteStudentAfterFound.prepareStatement(deleteStudentAfterFoundSql);
                        statToDeleteStudentAfterFound.setString(1, studentInfo.getStudent_Id());
                        rowsAffected = statToDeleteStudentAfterFound.executeUpdate();
                    
                    return rowsAffected;
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,"Database Error"+ e.getMessage());
                }
                
            
        
        return 0;
    }

    
  public List<StudentInfo> getAllStudents(){
        List<StudentInfo> students= new ArrayList<>();
        
        String getAllSql=" SELECT student_id,student_name,email,age,gender,faculty,department FROM students";
        try {
          Connection conToGetAll= DriverManager.getConnection(jdbcUrl,dbUsername,dbPassword);
          PreparedStatement statTogetAll= conToGetAll.prepareStatement(getAllSql);
          ResultSet resToGetAll= statTogetAll.executeQuery();
         while (resToGetAll.next()){
              StudentInfo stu = new StudentInfo();
              stu.setStudent_Id(resToGetAll.getString("student_id"));
              stu.setStudent_name(resToGetAll.getString("student_name"));
              stu.setEmail(resToGetAll.getString("email"));
              stu.setAge(resToGetAll.getInt("age"));
              stu.setGender(resToGetAll.getString("gender"));
              stu.setFaculty(resToGetAll.getString("faculty"));
              stu.setDepatment(resToGetAll.getString("department"));
              students.add(stu);
            }
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null,"Database Error"+ e.getMessage());
      } 
        return students;
      
  }
  
  public int updateStudent( StudentInfo studentToUpdate){
      String studeUpdateSql=" UPDATE students SET  student_name=?, email=?,age=?,gender=?,faculty=?,department=? WHERE student_id=? ";
      try {
          Connection conToUpdate = DriverManager.getConnection(jdbcUrl, dbUsername,dbPassword);
          PreparedStatement staToUpdate = conToUpdate.prepareStatement(studeUpdateSql);
          
          staToUpdate.setString(1, studentToUpdate.getStudent_name());
          staToUpdate.setString(2, studentToUpdate.getEmail());
          staToUpdate.setInt(3, studentToUpdate.getAge());
          staToUpdate.setString(4, studentToUpdate.getGender());
          staToUpdate.setString(5, studentToUpdate.getFaculty());
          staToUpdate.setString(6, studentToUpdate.getDepatment());
          staToUpdate.setString(7, studentToUpdate.getStudent_Id());
          
          
          int rowsAffected = staToUpdate.executeUpdate();
          
          if (rowsAffected>0) {
              
              JOptionPane.showMessageDialog(null," Update Successfully!");
              return rowsAffected;
          }
          else{
              JOptionPane.showMessageDialog(null,"ERROR In Update");
          }
     } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"ErroR DATABASE"+ e.getMessage());
         
      }
      return 0;
  }

    
}

