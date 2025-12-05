package dev.ericbush;

import java.util.List;

/**
 * A record containing instructions for a Turing Machine
 *
 * @param numberOfStates in the turing machine
 * @param haltingState of the turing machine
 * @param transitions a list containing all transitions in the turning machine
 */
public record Instructions(int numberOfStates, int haltingState, List<Transition> transitions) { }