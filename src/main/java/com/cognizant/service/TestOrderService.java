package com.cognizant.service;

import com.cognizant.dao.TestOrderDAO;
import com.cognizant.model.TestOrder;

public class TestOrderService {
    private TestOrderDAO dao = new TestOrderDAO();
    private PatientService patientService = new PatientService();

    public void createOrder(int patientId, String testName){
        if(!patientService.exists(patientId)){
            System.out.println("Patient Id doesn't exist");
            return;
        }
        TestOrder order = new TestOrder(0, patientId, testName);
        dao.save(order);
        System.out.println(" Test Order Created Successfully");
    }

    public void viewOrders(){
        dao.findAll().forEach(System.out::println);
    }
}
