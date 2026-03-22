package com.cognizant.service;

import com.cognizant.context.UserContext;
import com.cognizant.dao.SampleDAO;
import com.cognizant.model.Role;
import com.cognizant.model.Sample;

public class SampleService {
    private SampleDAO dao = new SampleDAO();
    //private PatientService patientService = new PatientService();

    public void collectSample(int orderId){

        if(UserContext.getCurrentUser().getRole() != Role.ADMIN){
            System.out.println(" Only Admin can Create Samples");
            return;
        }
        Sample sample = new Sample(0, orderId, "Pending");
        dao.save(sample);
        System.out.println("Sample Data entered for order Id: " + orderId);
    }
    
    public boolean isValidTransistion(String curr, String next){
        return ((curr.equals("PENDING") && next.equals("COLLECTED")) ||
                (curr.equals("collected") && next.equals("PROCESSING")) ||
                (curr.equals("PROCESSING") && next.equals("COLLECTED")));
    }

    public void viewSamples(){
        dao.findAll().forEach(System.out::println);
    }

    public void updateStatus(int sampleId, String newStatus){
        if(UserContext.getCurrentUser().getRole() != Role.ADMIN){
            System.out.println(" Only Admin can Access and Update status");
            return;
        }
        
        String currStatus = dao.getStatusBYId(sampleId);
        
        if(currStatus == null){
            System.out.println("Sample Not Found! ");
            return;
        }
        
        if(!isValidTransistion(currStatus, newStatus)){
            System.out.println(" Invalid State status Transition");
            return;
        }
        
        dao.updateStatus(sampleId, newStatus);
        
        System.out.println(" Status Updated from " + currStatus + " to " + newStatus);

    }



}
