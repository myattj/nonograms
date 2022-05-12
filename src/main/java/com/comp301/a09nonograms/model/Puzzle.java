package com.comp301.a09nonograms.model;

public class Puzzle {

  Clues clue;
  Board board;

  public Puzzle(Clues clue, Board board) {
    this.clue = clue;
    this.board = board;
  }

  public Clues getClue() {
    return clue;
  }

  public Board getBoard() {
    return board;
  }
}
