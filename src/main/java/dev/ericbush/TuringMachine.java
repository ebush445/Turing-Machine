package dev.ericbush;

/**
 * Class for a Turing Machine
 */
public class TuringMachine {
  private Tape tape;
  private Instructions instructions;
  private int currentState = 0;

  // Constructor
  public TuringMachine(Instructions instructions, Tape tape){
    this.tape = tape;
    this.instructions = instructions;
  }

  /**
   * Runs the Turing Machine
   * @return true if machine would halt, otherwise false
   */
  public boolean run() {
    // Run while not in a halting state
    while (currentState != instructions.haltingState()) {
      char currentChar = tape.read();
      boolean isMachineStuck = true;

      // loop through each possible transition
      for (Transition transition : instructions.transitions()) {

        // check if the transition matches given the starting state, char read from tape
        if (transition.startingState() == currentState && transition.read() == currentChar) {
          isMachineStuck = false;

          // write to the tape
          tape.write(transition.write());
          // move to next state
          currentState = transition.endingState();
          // Print current results
          System.out.println(this.toString());
          // Move the tape
          tape.moveTape(transition.move());
          break;
        }
      }
      if (isMachineStuck) {
        return false;
      }
    }
    return true;
  }

  /**
   * @return the current state and the tape reading as a String
   */
  @Override
  public String toString() {
    return currentState + ":  " + tape.toString();
  }
}