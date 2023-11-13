package problem1.driver;

import java.util.Scanner;
import problem1.service.ShakeMachine;

/**
 * Main class is the entry point for the program to calculate the minimum time needed to deliver milkshake orders.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mangoMilkshake, orangeMilkshake, pineappleMilkshake, totalTime;

        System.out.println("Total number of orders for Mango milkshake:");
        mangoMilkshake = sc.nextInt();

        System.out.println("Total number of orders for Orange milkshake:");
        orangeMilkshake = sc.nextInt();

        System.out.println("Total number of orders for Pineapple milkshake:");
        pineappleMilkshake = sc.nextInt();

        totalTime = ShakeMachine.getMinimumTime(mangoMilkshake, orangeMilkshake, pineappleMilkshake);

        System.out.println("Minimum time needed to deliver all orders is: " + totalTime);

        sc.close();
    }
}