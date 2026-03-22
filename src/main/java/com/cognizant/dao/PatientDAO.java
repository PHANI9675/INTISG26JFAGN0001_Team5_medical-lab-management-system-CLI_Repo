package com.cognizantTest.dao;

import com.cognizantTest.model.Patient;
import com.cognizantTest.repositary.DBConnection;

import java.sql.*;
//import java.sql.PreparedStatement;
import java.util.*;


public class PatientDAO {
    public void save(Patient patient){
        String query = "Insert into patient (name) values (?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, patient.getName());
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Patient> findAll(){
        List<Patient> list = new ArrayList<>();
        String query = "Select * from patient";

        try(Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query)){

            while (rs.next()) {
                list.add(new Patient(rs.getInt("id"), rs.getString("name")));

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return list;

    }

    public boolean existsById(int id){
        String query = "Select COUNT(*) from patient where id = ?";
        boolean flag = false;
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            System.out.println("Checking Id: " + id);
            if(rs.next()){
                int count = rs.getInt(1);
                System.out.println("Count =" + count);
                flag = true;

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
