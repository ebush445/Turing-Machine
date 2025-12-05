package dev.ericbush;

/**
 * Contains a transition for the machine
 *
 * @param startingState
 * @param read
 * @param write
 * @param move
 * @param endingState
 */
public record Transition(int startingState, char read, char write, char move, int endingState) {}
