// Nickolas Kavanagh
// Semester 4 Midterm Sprint
// 14/6/2025 - 22/06/2025

package org.example;

import java.util.Scanner;


// i wanted to make a simple interface for the user to add, undo, redo data and show the history.
// could probably have formatted the output better for more modular input, but i had fun messing with the
// logic for the problem.

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== UNDO/REDO Data Application ===");
        
        // new undo/redo object and scanner
        var history = new UndoRedo<>("init...");
        Scanner scanner = new Scanner(System.in);
        
        // switch case for user input
        while (true) {
            System.out.println("\n--- Current Entry: " + history.get() + " ---");
            System.out.println("What would you like to do?");
            System.out.println("1. Add new entry");
            System.out.println("2. Undo entry");
            System.out.println("3. Redo entry");
            System.out.println("4. Show history");
            System.out.println("5. Exit");
            System.out.print("Please choose (1-5): ");
            
            String choice = scanner.nextLine().trim(); // user input
            
            switch (choice) {
                case "1" -> {
                    System.out.print("Enter new entry: ");
                    String newEntry = scanner.nextLine();
                    history.save(newEntry);
                    System.out.println("Added: " + newEntry);
                }
                case "2" -> {
                    if (history.undo()) System.out.println("Undone. Now at: " + history.get());
                    else System.out.println("ERROR: Nothing to undo.");
                }
                case "3" -> {
                    if (history.redo()) System.out.println("Redone. Now at: " + history.get());
                    else System.out.println("ERROR: Nothing to redo.");
                }
                case "4" -> {
                    System.out.println("History:");
                    history.printChain();
                }
                case "5" -> {
                    System.out.println("Later!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("ERROR: Please enter 1-5.");
            }
        }
    }
}