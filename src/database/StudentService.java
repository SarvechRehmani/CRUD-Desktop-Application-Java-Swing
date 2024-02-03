package database;

import entities.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentService {

//    Add Student
    public static void AddStudent(Student student) {
        try {
            Connection con = ConnectDB.connect();
            String q = "insert into info (name,email,phone,age) values (?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setString(3, student.getPhone());
            pstmt.setString(4, student.getAge());
            pstmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Update Student
    public static void updateStudent(Student student) {
        try {
            Connection con = ConnectDB.connect();
            String q = "update info set name = ?, email=?, phone=?, age=? where id = ?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setString(3, student.getPhone());
            pstmt.setString(4, student.getAge());
            pstmt.setInt(5, student.getId());
            pstmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    Delete Student
    public static void deleteStudent(int id) {
        try {
            Connection con = ConnectDB.connect();
            String q = "delete from info where id = ?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Fetch Student Record
    public static Student fetchRecords(int id) {
        try {
            Connection con = ConnectDB.connect();
            String q = "select * from info where id="+id;
            Statement stmt = con.createStatement();
            ResultSet r = stmt.executeQuery(q);
            if (r.next()) {

                int sid = r.getInt(1);
                String name = r.getString(2);
                String email = r.getString(3);
                String phone = r.getString(4);
                String age = r.getString(5);

                Student s = new Student(sid, name, email, phone, age);
                return s;
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}