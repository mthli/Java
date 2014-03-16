import java.util.*;

public class Retirement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How much money do you need to retire? ");
        double goal = in.nextDouble();

        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        while (balance < goal) {
            balance += payment;
            double intrest = balance * interestRate / 100;
            balance += intrest;
            years++;
        }

        System.out.println("You can retire in " + years + " years.");
    }
}

