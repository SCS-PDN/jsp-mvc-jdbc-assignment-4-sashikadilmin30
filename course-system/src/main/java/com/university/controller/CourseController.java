



package com.university.controller;

import java.sql.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;

import java.util.*;

@Controller
public class CourseController {

    @GetMapping("/courses")
    public String showCourses(Model model) {

        List<String> courses = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/university_db", "root", "Dilmin357#");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT name FROM courses");

            while(rs.next()) {
                courses.add(rs.getString("name"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("courses", courses);

        return "courses";
    }

    @PostMapping("/register/{id}")
    public String register(@PathVariable int id, HttpSession session) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/university_db", "root", "YOUR_PASSWORD");

            int studentId = 1; // simple for now

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO registrations(student_id, course_id, date) VALUES (?, ?, NOW())");

            ps.setInt(1, studentId);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return "success";
    }
}