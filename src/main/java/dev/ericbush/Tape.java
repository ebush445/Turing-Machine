package dev.ericbush;

/**
 * A class containing the tape for a turing machine
 */
public class Tape {
  private String tape;
  private int headPosition = 0;

  // Constructor
  public Tape(String tape) {
    this.tape = tape;
  }

  /**
   * Reads a character at the current head position
   *
   * @return the character
   */
  public char read(){
    if (headPosition > tape.length() - 1) {
      tape += ' ';
    }
    return tape.charAt(headPosition);
  }

  /**
   * Writes a character at the head position
   *
   * @param newChar the character that is written in
   */
  public void write(char newChar) {

    StringBuilder sb = new StringBuilder(tape);
    sb.setCharAt(headPosition, newChar);
    tape = sb.toString();
  }

  /**
   * Moves the tape left or right given the direction
   *
   * @param direction 'L' for left move 'R' for right move
   */
  public void moveTape(char direction){
    if (direction == 'L') {
      headPosition--;
    } else if (direction == 'R') {
      headPosition++;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < tape.length(); i++) {
      // record location of the head by surrounding element with []
      if (i == headPosition) {
        sb.append('[').append(tape.charAt(i)).append(']');
      } else {
        sb.append(tape.charAt(i));
      }
    }
    return sb.toString();
  }
}