package com.comp301.a09nonograms.model;

public class CluesImpl implements Clues {

  private int[][] rowClues;
  private int[][] colClues;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    if (rowClues == null || colClues == null) {
      throw new IllegalArgumentException();
    } else {
      this.rowClues = rowClues;
      this.colClues = colClues;
    }
  }

  public int getWidth() {
    return colClues.length;
  }

  public int getHeight() {
    return rowClues.length;
  }

  public int[] getRowClues(int index) {
    return rowClues[index];
  }

  public int[] getColClues(int index) {
    return colClues[index];
  }

  public int getRowCluesLength() {
    return rowClues[0].length;
  }

  public int getColCluesLength() {
    return colClues[0].length;
  }
}
