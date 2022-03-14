package com.bridgelabz;

import java.util.Scanner;

public class Gambler {

    static int AMOUNT_OF_STAKE = 100;
    static int TOTAL_AMOUNT_DIFF_IN_MONTH = 0;
    static int BET_AMOUNT = 1;
    static int WON = 1;
    static int LOST = 0;
    static int TOTAL_AMOUNT = 0;


    public static void main(String[] args) {
        int TOTAL_AMOUNT_DIFF_IN_MONTH = 0;
        int WON = 1;
        int LOST = 0;

        public static void main (String[]args){
            int maximumWon[] = new int[100];
            int maximumLost[] = new int[100];
            int month = 1;

            Scanner sc = new Scanner(System.in); // create object for scanner class
            boolean label = true;

            while (label) {
                System.out.println(" Month" + month + " gambling starts");
                System.out.println("Enter starting amount of stake ");
                int amountOfStake = sc.nextInt();
                System.out.println("Enter amount to bet ");
                int betAmount = sc.nextInt();
                int totalAmount = 0;

                /*
                 * using for loop to check condition After 20 days of playing every day would
                 * like to know the total amount won or lost.
                 */

                for (int i = 1; i <= 20; i++) {
                    int cashInHand = amountOfStake;
                    while (cashInHand > amountOfStake / 2 && cashInHand < amountOfStake * 1.5) {

                        /*
                         * using random function to get a random number
                         */
                        int play = (int) Math.floor(Math.random() * 10) % 2;
                        System.out.println("Gamblers play:" + play);

                        /*
                         * using switch case statement for getting amount if gambler will lose or gain
                         */
                        switch (play) {
                            case 1:
                                cashInHand = cashInHand + betAmount;
                                System.out.println("Total current cash gambler has " + cashInHand);
                                break;
                            case 0:
                                cashInHand = cashInHand - betAmount;
                                System.out.println("Total current cash gambler has " + cashInHand);
                                break;
                            default:
                                System.out.println("default");
                        }
                    }

                    /*
                     * Gambler if won or lost 50% of the stake, would resign for the day
                     */
                    if (cashInHand == (amountOfStake / 2) || cashInHand == (amountOfStake * 1.5)) {
                        System.out.println("Player would like to resign for current day" + i);
                    }

                    if (cashInHand > amountOfStake) {
                        int amountWonPerDay = cashInHand - amountOfStake;
                        System.out.println("Player won day" + i + " RS " + amountWonPerDay);
                    } else if (cashInHand < amountOfStake) {
                        int amountLostPerDay = amountOfStake - cashInHand;
                        System.out.println("Player lost day" + i + " RS " + amountLostPerDay);
                    }
                    if (cashInHand == (amountOfStake * 1.5)) {
                        maximumWon[i] = cashInHand;
                    } else if (cashInHand == 50) {
                        maximumLost[i] = cashInHand;
                    }
                    totalAmount = totalAmount + cashInHand;
                }

                /*
                 * check luckiest day of a gambler where won maximum and unluckiest day where
                 * lost maximum
                 */
                System.out.println("Luckiest days as following as gambler WON maximum amount");
                for (int i = 1; i <= 20; i++) {
                    if (maximumWon[i] == (amountOfStake * 1.5))
                        System.out.println("Day" + i + " won " + maximumWon[i] + " $");
                }
                System.out.println("Unluckiest days as following as gambler LOST maximum amount");
                for (int i = 1; i <= 20; i++) {
                    if (maximumLost[i] == (amountOfStake / 2))
                        System.out.println("Day" + i + " lost " + maximumLost[i] + " $");
                }
                System.out.println("Total amount player has after 20 days as per day included = " + totalAmount + " $");
                TOTAL_AMOUNT_DIFF_IN_MONTH = totalAmount - amountOfStake * 20;
                if (TOTAL_AMOUNT_DIFF_IN_MONTH > 0) {
                    System.out
                            .println("Total cash gambler won in month" + month + "= " + TOTAL_AMOUNT_DIFF_IN_MONTH + " $");
                } else if (TOTAL_AMOUNT_DIFF_IN_MONTH < 0) {
                    System.out
                            .println("Total cash gambler lost in month" + month + "= " + TOTAL_AMOUNT_DIFF_IN_MONTH + " $");
                } else {
                    System.out.println("Total cash gambler neither lost or won in month" + month + "= "
                            + TOTAL_AMOUNT_DIFF_IN_MONTH + " $");
                }
                System.out.println();
            }
        }
    }
}


