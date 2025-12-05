package dev.ericbush;

/**
 * A PrintHead
 */
public class PrintHead {
  private Tape tape;
  private Instructions instructions;
  private int currentState = 0;
  private int currentHeadPosition = 0;

  // Constructor for PrintHead
  public PrintHead(Instructions instructions, Tape tape){
    this.tape = tape;
    this.instructions = instructions;
  }

  /**
   * Runs the Turing Machine
   * @return the resulting tape
   */
  public Tape execute() {
    while (currentState != instructions.haltingState()) {
      char currentChar = tape.read(currentHeadPosition);

      for (Transition t : instructions.transitions()) {
        if (t.getStartingState() == currentState && t.getRead() == currentChar) {
          tape.write(currentHeadPosition, t.getWrite());
          System.out.println(currentState + " -> " + t.getEndingState() + " on input " + currentChar + " " + currentHeadPosition);
          currentState = t.getEndingState();

          System.out.println(tape.toString());


          if (t.getMove() == 'R'){
            currentHeadPosition++;
            System.out.println("Move Right");
          }
          else if (t.getMove() == 'L') {
            currentHeadPosition--;
            System.out.println("Move Left");
          }
          tape.setHeadPosition(currentHeadPosition);
          break;
        }
      }
    }
    return tape;
  }
}