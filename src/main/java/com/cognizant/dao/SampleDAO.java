package com.cognizantTest.dao;

import com.cognizantTest.model.Sample;
import com.cognizantTest.repositary.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SampleDAO {

    public void save(Sample sample) {

        String query = "Insert into sample(order_id, sample_status) values(?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, sample.getOrderId());
            ps.setString(2, sample.getStatus());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Sample> findAll(){
        List<Sample> list = new ArrayList<>();
        String query = "select * from Sample";

        try(Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query)){
            while(rs.next()){
                list.add(new Sample(rs.getInt("sample_id"),
                        rs.getInt("order_id"),
                        rs.getString("sample_status")));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public String getStatusBYId(int sampleId){
        String query = "Select sample_status from sample where sample_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, sampleId);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return rs.getString("sample_status");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateStatus(int sampleId, String status){
        String query = "Update sample SET sample_status = ? where sample_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, status);
            ps.setInt(2, sampleId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
