package com.Bridgelabz.Day10EmployeeWageCompution;

public class EmployeeWageCompution {
    public final int FULL_TIME = 1;
    public final int PART_TIME = 2;

    //emp wage for companys
    public static void main(String[] args) {
        EmpWageBuilder tcs = new EmpWageBuilder("TCS",40,20,60);
        EmpWageBuilder capgemini = new EmpWageBuilder("Capgemini",60,15,55);
        EmpWageBuilder infosys = new EmpWageBuilder("Infosys",65,18,70);
        tcs.computeEmpWage();
        System.out.println(tcs);

        System.out.println();

        capgemini.computeEmpWage();
        System.out.println(capgemini);

        System.out.println();

        infosys.computeEmpWage();
        System.out.println(infosys);

    }


    public static class EmpWageBuilder extends EmployeeWageCompution {


        private final String company;
        private final int empPerHrWage;
        private final int numOFWorkingDays;
        private final int totalHourPerMonth;
        private int totalEmpWage;


        public EmpWageBuilder(String company, int empPerHrWage, int numOFWorkingDays, int totalHourPerMonth) {
            this.company = company;
            this.empPerHrWage = empPerHrWage;
            this.numOFWorkingDays = numOFWorkingDays;
            this.totalHourPerMonth = totalHourPerMonth;
        }

        private void computeEmpWage() {
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
            totalEmpWage = totalEmpHrs * empPerHrWage;
        }

        public String toString() {
            return "Toatal emp wage For " +company+ " is: " +totalEmpWage;
        }
    }
}

