import java.util.Scanner;

public class SafeInput {

    public static String getString(Scanner console, String prompt) {
        System.out.print(prompt + ": ");
        return console.nextLine();
    }

    public static String getRegExString(Scanner console, String prompt, String regEx) {
        String input;

        do {
            System.out.print(prompt + ": ");
            input = console.nextLine();

            if (!input.matches(regEx)) {
                System.out.println("Invalid input. Please try again.");
            }

        } while (!input.matches(regEx));

        return input;
    }

    public static int getRangedInt(Scanner console, String prompt, int min, int max) {
        int number;

        while (true) {
            System.out.print(prompt + " (" + min + "-" + max + "); ");

            if (console.hasNextInt()) {
                number = console.nextInt();
                console.nextLine();

                if (number >= min && number <= max) {
                    return number;
                }
            } else {
                console.nextLine();
            }

            System.out.println("Invalid input. Enter a number between " + min + " and " + max + ".");
        }
    }

    public static boolean getYNConfirm(Scanner console, String prompt) {
        String answer;

        do {
            System.out.print(prompt + " (Y/N): ");
            answer = console.nextLine();

            if (!answer.equalsIgnoreCase("Y")
                    && !answer.equalsIgnoreCase("N")) {
                System.out.println("Please enter Y or N.");
            }

        } while (!answer.equalsIgnoreCase("Y")
                && !answer.equalsIgnoreCase("N"));

        return answer.equalsIgnoreCase("Y");
    }
}

