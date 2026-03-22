package com.cognizant.dao;

import com.cognizant.model.TestOrder;
import com.cognizant.repositary.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestOrderDAO {
    public void save(TestOrder order) {
        String query = "Insert into test_order(patient_id, test_name) values(?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, order.getPatientId());
            ps.setString(2, order.getTestName());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TestOrder> findAll(){
        List<TestOrder> list = new ArrayList<>();
        String query = "select * from test_order";

        try(Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query)){
            while(rs.next()){
                list.add(new TestOrder(rs.getInt("order_id"),
                        rs.getInt("patient_id"),
                        rs.getString("test_name")));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
