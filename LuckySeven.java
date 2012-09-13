/**
 * LuckySeven.java
 * a class simulate the Lucky Seven game.
 */

import java.util.*;

public class LuckySeven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        String input;
        int startingCash, cash, maxCash, rolls, roll;

        while (true) {
            System.out.print("Enter the amount of cash to start with " +
                "(or \"quit\" to quit): ");

            input = in.nextLine();

            if (input.toLowerCase().equals("quit")) {
                System.out.println("\tgoodbye.");
                System.exit(0);
            }

            try {
                startingCash = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("\tPlease enter a positive integer.");
                continue;
            }

            if (startingCash <= 0) {
                System.out.println("\tPlease enter a positive integer.");
                continue;
            }

            cash = startingCash;
            maxCash = cash;
            rolls = 0;

            // the game loop
            for (; cash > 0; rolls++) {
                roll = random.nextInt(6) + 1;
                roll += random.nextInt(6) + 1;

                if (roll == 7)
                    cash += 4;
                else
                    cash -= 1;

                maxCash = Math.max(maxCash, cash);
            }

            System.out.println("\tYou start with $" + startingCash + ".\n"
                + "\tYou peak at $" + maxCash + ".\n"
                + "\tAfter " + rolls + " rolls, you run out of cash.");
        }
    }
};
