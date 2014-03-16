import java.util.*;

public class Retirement2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();

        System.out.print("Intrest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int year = 0;

        String input;

        do {
            balance += payment;
            double intrest = balance * interestRate / 100;
            balance += intrest;

            year++;

            System.out.printf("After year %d, you balance in %,.2f%n", year, balance);
            
            System.out.print("Ready to retire? (Y/N)");
            input = in.next();
        }
        while (input.equals("N"));
    }
}

