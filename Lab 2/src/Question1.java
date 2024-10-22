import java.util.*;
public class Question1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the loan amount to be paid off:");
        double loan = sc.nextDouble();
        System.out.print("Enter the annual interest rate (in decimal):");
        double ir = sc.nextDouble();
        System.out.print("Enter the monthly loan repayment:");
        double mRepay = sc.nextDouble();

        int numMonths = paidOff(loan,ir,mRepay);
        System.out.println("It will takes " + numMonths + " month(s) to pay off the loan.");
    }

    public static int paidOff(double loan, double ir, double mRepay){
        if(loan <= 0){
            return 0;
        }
        else{
            loan -= mRepay;
            loan += loan*(ir/12);
            return paidOff(loan, ir, mRepay) + 1;
        }
    }
}
