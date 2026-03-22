package com.cognizant.service;

import com.cognizantTest.dao.ReportDAO;
import com.cognizantTest.dao.SampleDAO;
import com.cognizantTest.model.Report;

public class ReportService {

    private ReportDAO dao = new ReportDAO();
    private SampleDAO sdao = new SampleDAO();
    private NotificationService notificationService = new NotificationService();

    public void generateReport(int sampleId, String result){

        String status = sdao.getStatusBYId(sampleId);

        if(status == null){
            System.out.println(" Sample not found");
            return;
        }

        Report report = new Report(0, sampleId, result);
        dao.save(report);

        notificationService.notifyUser("Report ready for sample ID " + sampleId);
        System.out.println(" Report Generated");
    }

    public void viewReports(){
        dao.findAll().forEach(System.out::println);
    }
}
