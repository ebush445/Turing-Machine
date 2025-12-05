package dev.ericbush;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TuringMachineFactory {

  /**
   * Builds a TuringMachine from a specification file and input tape string.
   */
  public static TuringMachine fromFile(String filename, String inputTape) throws FileNotFoundException {

    // Read instructions from file
    Scanner sc = new Scanner(new File(filename));
    List<Transition> transitions = new ArrayList<>();

    // Line 1: Number of states
    int numberOfStates = sc.nextInt();

    // Line 2: Halting state
    int haltingState = sc.nextInt();
    sc.nextLine();

    // Remaining lines: contain transitions
    while (sc.hasNextLine()) {
      String line = sc.nextLine();

      // Split line by whitespace
      String[] parts = line.split(" ");

      int startingState = Integer.parseInt(parts[0]);
      char read = parts[1].charAt(0);
      char write = parts[2].charAt(0);
      char move = parts[3].charAt(0);
      int endingState = Integer.parseInt(parts[4]);

      // create new transition using data from file
      transitions.add(new Transition(startingState, read, write, move, endingState));
    }

    // create new set of instructions for machine
    Instructions instructions = new Instructions(numberOfStates, haltingState, transitions);
    Tape tape = new Tape(inputTape);

    // return the Turing Machine
    return new TuringMachine(instructions, tape);
  }
}
