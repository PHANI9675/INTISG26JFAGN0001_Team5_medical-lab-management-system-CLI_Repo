package com.cognizantTest.model;

public class Report {
    private int reportId;
    private int sampleId;
    private String result;

    public int getSampleId() {
        return sampleId;
    }

    public String getResult() {
        return result;
    }

    public Report(int reportId, int sampleId, String result) {
        this.reportId = reportId;
        this.sampleId = sampleId;
        this.result = result;
    }

    @Override
    public String toString(){
        return "Report { reportId = " + reportId +
                ", sampleId = " + sampleId +
                ", result = " + result + " }";
    }



}
