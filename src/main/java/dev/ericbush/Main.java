package dev.ericbush;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {

    // Scan for user input until they type 'Quit'
    while(true) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the input to evaluate: ");
      String input = scanner.nextLine();

      // Exit program if user types Quit
      if (input.equals("Quit")) {
        System.out.println("Goodbye!");
        break;
      }

      // Create a new turing machine from file, user input
      TuringMachine turingMachine = TuringMachineFactory.fromFile("TM.txt", input);

      // Run turing machine and print result
      boolean halts = turingMachine.run();
      if (halts) {
        System.out.println("[Halts]");
      }
      else {
        System.out.println("[Does not halt]");
      }
    }
  }
}
