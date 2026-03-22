package com.cognizant.service;

import com.cognizantTest.dao.PatientDAO;
import com.cognizantTest.model.Patient;

import java.util.Scanner;

public class PatientService {
    private static Scanner sc = new Scanner(System.in);
    private PatientDAO dao = new PatientDAO();
    //private static int counter = 1;

    public void addPatient(String name){

        /*if(UserContext.getCurrentUser().getRole() != Role.ADMIN){
            System.out.println("");
        }*/
        dao.save(new Patient(0, name));
    }

    public void viewPatients(){
        dao.findAll().forEach(System.out::println);
    }


    public boolean exists(int patientId) {
        return dao.existsById(patientId);
        //return true;
    }

}
