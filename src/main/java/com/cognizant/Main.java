package com.cognizant;

import com.cognizant.context.UserContext;
import com.cognizant.model.Role;
//import com.cognizant.model.TestOrder;
import com.cognizant.model.User;
import com.cognizant.service.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static PatientService patientService = new PatientService();
    private static TestOrderService orderService = new TestOrderService();
    private static SampleService sampleService = new SampleService();
    private static ReportService reportService = new ReportService();
    private static Role currentRole;
    private static AuthService authService = new AuthService();


    public static void main(String[] args) {
        User user = null;
        while (user == null) {
            System.out.println("--- Laboratory Management System ---");

            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    System.out.println("UserName: ");
                    String regUser = sc.nextLine();

                    System.out.println("Password: ");
                    String regpassword = sc.nextLine();

                    System.out.println("Select Role: ADMIN / USER");
                    String role = sc.nextLine();

                    String passcode = " ";
                    if (role.equalsIgnoreCase("ADMIN")) {
                        System.out.print("Enter Admin Passcode: ");
                        passcode = sc.nextLine();
                    }
                    authService.register(regUser, regpassword, role, passcode);
                    break;

                case 2:
                    System.out.println("UserName: ");
                    String loginUser = sc.nextLine();

                    System.out.println("Password: ");
                    String loginPassword = sc.nextLine();
                    user = authService.login(loginUser, loginPassword);
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid Action!");
            }
        }
        UserContext.setCurrentUser(user);
        while(true){
            System.out.println();
            System.out.println(("Select the Required Service: "));
            System.out.println("1. Patient Service");
            System.out.println("2. TestOrder Service");
            System.out.println("3. Sample Service");
            System.out.println("4. Report Service");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    patientMenu();
                    break;

                case 2:
                    testOrderMenu();
                    break;

                case 3:
                    sampleMenu();
                    break;

                case 4:
                    reportMenu();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Wrong choice buddy");
            }
        }
    }

    public static void patientMenu(){
        while(true){
            System.out.println("/n-- Welcome to Patient Service: --");
            System.out.println("1. Register Patient");
            System.out.println("2. All Patient details");
            System.out.println("3. Exit");

            System.out.println("Enter your choice in Patient Service: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1:
                    System.out.println("Enter name: ");
                    String name = sc.nextLine();
                    patientService.addPatient(name);
                    break;

                case 2:
                    patientService.viewPatients();
                    break;

                case 3:
                    return;

            }
        }
    }

    public static void testOrderMenu(){
        while(true){
            System.out.println("-- Welcome to TestOrder Service: --");
            System.out.println("1. Create Order");
            System.out.println("2. View Orders");
            System.out.println("3. Back");

            System.out.println("Enter your choice in TestOrder Service: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1:
                    System.out.println("Enter PatientId: ");
                    int pId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter TestName: ");
                    String testName = sc.nextLine();
                    orderService.createOrder(pId, testName);
                    break;

                case 2:
                    orderService.viewOrders();
                    break;

                case 3:
                    return;

            }
        }

    }

    public static void sampleMenu() {
        while (true) {
            System.out.println("-- Welcome to Sample Service: --");
            System.out.println("1. Create Sample");
            System.out.println("2. View Samples");
            System.out.println("3. Update status");
            System.out.println("4. Back");

            System.out.println("Enter your choice in Sample Service: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    System.out.println("Enter Order Id: ");
                    int orderId = sc.nextInt();
                    sc.nextLine();
                    sampleService.collectSample(orderId);
                    //System.out.println("--> Sample Data Entered for order id: " + orderId);
                    break;

                case 2:
                    sampleService.viewSamples();
                    break;

                case 3:
                    System.out.println("Enter Sample Id: ");
                    int sampleId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the status to be updated: ");
                    String status = sc.nextLine();
                    sampleService.updateStatus(sampleId, status);

                case 4:
                    return;

                default:
                    System.out.println("Enter proper option");
            }
        }
    }

    public static void reportMenu(){
        while(true){
            System.out.println("-- Welcome to Report Service: --");
            System.out.println("1. Generate Report");
            System.out.println("2. View Reports");
            System.out.println("3. Back");

            System.out.println("Enter your choice in Report Service: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1:
                    System.out.println("Enter Sample Id: ");
                    int sId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Result: ");
                    String result = sc.nextLine();
                    reportService.generateReport(sId, result);
                    break;

                case 2:
                    reportService.viewReports();
                    break;

                case 3:
                    return;

            }
        }

    }

}