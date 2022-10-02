package com.Bridgelabz.Day10EmployeeWageCompution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class EmployeeWageCompution { //main class
    public final String company;
    public final int empPerHrWage;
    public int numOFWorkingDays;
    public int totalHourPerMonth;
    public int totalEmpWage;


    public EmployeeWageCompution(String company, int empPerHrWage, int numOFWorkingDays, int totalHourPerMonth) {
        this.company = company;
        this.empPerHrWage = empPerHrWage;
        this.numOFWorkingDays = numOFWorkingDays;
        this.totalHourPerMonth = totalHourPerMonth;
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    public String toString() {
        return "Total emp wage For " + company + " is: " + totalEmpWage;
    }


    public static void main(String[] args) {
        IEmployeeWageCompution empWageBuilder = new EmpWageBuilder();
        empWageBuilder.addCompanyEmpWage("TCS", 60, 10, 70);
        empWageBuilder.addCompanyEmpWage("Capgemini", 80, 20, 100);
        empWageBuilder.addCompanyEmpWage("DXC", 50, 8, 55);
        empWageBuilder.addCompanyEmpWage("Flipkart", 100, 20, 60);
        empWageBuilder.empWageCompute();
        System.out.println();
        System.out.println("Total wage For TCS Company: " +empWageBuilder.getTotalWage("TCS"));
        System.out.println();
        System.out.println("Total wage For Capgemini Company: " +empWageBuilder.getTotalWage("Capgemini"));
        System.out.println();
        System.out.println("Total wage For DXC Company: " +empWageBuilder.getTotalWage("DXC"));
        System.out.println();
        System.out.println("Total wage For Flipkart Company: " +empWageBuilder.getTotalWage("Flipkart"));
        System.out.println();

    }



    //create interface classs
    public interface IEmployeeWageCompution {
        public void addCompanyEmpWage(String company, int empPerHrWage, int numOFWorkingDays, int totalHourPerMonth);
        public void empWageCompute();
        public int getTotalWage(String company);
    }


    //emp wage for companys


    public static class EmpWageBuilder implements IEmployeeWageCompution {

        public static final int FULL_TIME = 1;
        public static final int PART_TIME = 2;

        private int numofCompanys = 0;
        private LinkedList<EmployeeWageCompution> employeeWageComputionsList;
        private Map<String,EmployeeWageCompution> employeeWageComputionMap;

        public EmpWageBuilder() {
            employeeWageComputionsList = new LinkedList<>();
            employeeWageComputionMap = new HashMap<>();
        }

        public void addCompanyEmpWage(String company, int empPerHrWage, int numOFWorkingDays, int totalHourPerMonth) {
            EmployeeWageCompution employeeWageCompution  = new EmployeeWageCompution(company, empPerHrWage, numOFWorkingDays, totalHourPerMonth);
            employeeWageComputionsList.add(employeeWageCompution);
            employeeWageComputionMap.put(company,employeeWageCompution);
        }

        public void empWageCompute() {
            for (int i = 0; i < employeeWageComputionsList.size(); i++) {
                EmployeeWageCompution employeeWageCompution = employeeWageComputionsList.get(i);
                employeeWageCompution.setTotalEmpWage(this.empWageCompute(employeeWageCompution));
                System.out.println(employeeWageCompution);
            }

        }

        public int getTotalWage(String company) {
            return employeeWageComputionMap.get(company).totalEmpWage;
        }


        public int empWageCompute(EmployeeWageCompution employeeWageCompution) {
            int empHour = 0;
            int totalEmpHrs = 0;
            int totalWorkingDays = 0;
            //computation
            while (totalEmpHrs <= employeeWageCompution.totalHourPerMonth && totalWorkingDays < employeeWageCompution.numOFWorkingDays) {
                totalWorkingDays++;
                int empCheck = (int) (Math.floor(Math.random() * 10) % 3);
                switch (empCheck) {
                    case FULL_TIME:
                        empHour = 8;
                        break;
                    case PART_TIME:
                        empHour = 4;
                        break;
                    default:
                        empHour = 0;
                }
                totalEmpHrs += empHour;
                System.out.println("Day#: " + totalWorkingDays + " Emp Hr: " + empHour);
            }
            return totalEmpHrs * employeeWageCompution.empPerHrWage;
        }

    }


}




