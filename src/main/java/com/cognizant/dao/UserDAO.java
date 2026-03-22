package com.cognizant.dao;

import com.cognizant.model.*;
import com.cognizant.repositary.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public void save(User user) {
        String query = "Insert into user(username, password, role) values(?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole().name());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public User findUserByUsername(String username){
        String query = "Select * from user where username = ?";

        try(Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role"))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
