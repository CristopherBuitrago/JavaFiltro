package com.filtro.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyUtils {
    
    // hide the password
    public static String readPassword(Scanner scanner) {
        if (System.console() != null) {
            // Use Console.readPassword() if available (for secure password input)
            return new String(System.console().readPassword());
        } else {
            // Fallback to normal scanner input (less secure)
            return scanner.nextLine();
        }
    }

    // Display message for seconds and clear screen
    public static void displayMessageAndClearScreen(String message, int displayDurationSeconds) {
        System.out.println(message);
        try {
            Thread.sleep(displayDurationSeconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        clearScreen();
    }

    // clear screen
    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // Clear screen for Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Clear screen for Unix-like systems (including macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Error while clearing screen: " + e.getMessage());
        }
    }

    // method to get a date
    public static Date getDateInput(String prompt, Scanner scanner) throws ParseException{
        System.out.print(prompt);
        String input = scanner.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false); // Strict date parsing
        return formatter.parse(input);
    }

    // method to get an int
    public static int getIntInput(String prompt, Scanner scanner) throws InputMismatchException{
        System.out.print(prompt);
        int input = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        return input;
    }

    // method to get a string
    public static String getInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input;
    }

}