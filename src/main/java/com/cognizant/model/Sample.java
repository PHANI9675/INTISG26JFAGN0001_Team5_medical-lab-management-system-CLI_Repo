package com.cognizant.model;

public class Sample {
    private int sampleId;
    private int orderId;
    private String status;


    public Sample(int sampleId, int orderId, String status) {
        this.sampleId = sampleId;
        this.orderId = orderId;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }
    public String getStatus() {
        return status;
    }

    @Override
    public String toString(){
        return "Sample { id = " + sampleId +
                ", orderId = " + orderId +
                ", status = " + status + "}";
    }

}
