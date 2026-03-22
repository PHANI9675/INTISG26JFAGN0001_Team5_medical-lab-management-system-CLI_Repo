package com.cognizant.dao;

import com.cognizant.model.Report;
import com.cognizant.model.TestOrder;
import com.cognizant.repositary.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {
    public void save(Report report) {
        String query = "Insert into report(sample_id, result) values(?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, report.getSampleId());
            ps.setString(2, report.getResult());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Report> findAll(){
        List<Report> list = new ArrayList<>();
        String query = "select * from report";

        try(Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query)){
            while(rs.next()){
                list.add(new Report(rs.getInt("report_id"),
                        rs.getInt("sample_id"),
                        rs.getString("result")));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
