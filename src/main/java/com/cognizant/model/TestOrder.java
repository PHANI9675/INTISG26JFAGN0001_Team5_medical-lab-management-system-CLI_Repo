package com.cognizant.model;

public class TestOrder {
    private int orderId;
    private int patientId;
    private String testName;

    public TestOrder( int orderId, int patientId, String testName) {
        this.testName = testName;
        this.patientId = patientId;
        this.orderId = orderId;
    }
    public String getTestName() {
        return testName;
    }

    public int getPatientId() {
        return patientId;
    }

    @Override
    public String toString(){
        return "Order {OrderId = " + orderId
                + " patientId = " + patientId +
                " testName = " + testName + " }";
    }


}
