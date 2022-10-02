package com.Bridgelabz.Day10EmployeeWageCompution;

public class EmployeeWageCompution {
    public final int FULL_TIME = 1;
    public final int PART_TIME = 2;


    public static void main(String[] args) {
        EmpWageForComany tcs = new EmpWageForComany("TCS",40,20,60);
        EmpWageForComany capgemini = new EmpWageForComany("Capgemini",60,15,55);
        System.out.println("Total Emplyoee wage for company " + tcs.company + " is: " + tcs.computeEmpWage());
        System.out.println();
        System.out.println("Total Emplyoee wage for company " + capgemini.company + " is: " + capgemini.computeEmpWage());

    }


    public static class EmpWageForComany extends EmployeeWageCompution {


        private final String company;
        private final int empPerHrWage;
        private final int numOFWorkingDays;
        private final int totalHourPerMonth;


        public EmpWageForComany(String company, int empPerHrWage, int numOFWorkingDays, int totalHourPerMonth) {
            this.company = company;
            this.empPerHrWage = empPerHrWage;
            this.numOFWorkingDays = numOFWorkingDays;
            this.totalHourPerMonth = totalHourPerMonth;
        }

        private int computeEmpWage() {
            int empHour = 0;
            int totalEmpHrs = 0;
            int totalWorkingDays = 0;
            //computation
            while (totalEmpHrs <= totalHourPerMonth && totalWorkingDays < numOFWorkingDays) {
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
            return totalEmpHrs * empPerHrWage;
        }
    }
}

