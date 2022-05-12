package com.comp301.a09nonograms.model;

public class BoardImpl implements Board {

  public int[][] pieces;
  int x;
  int y;

  public BoardImpl(int x, int y) {
    this.x = x;
    this.y = y;
    this.pieces = new int[x][y];
    clear();
  }

  public boolean isShaded(int row, int col) {
    if (row < 0 || col < 0) {
      throw new RuntimeException();
    }
    if (pieces[row][col] == 2) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isEliminated(int row, int col) {
    if (row < 0 || col < 0) {
      throw new RuntimeException();
    }
    if (pieces[row][col] == 1) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isSpace(int row, int col) {
    if (row < 0 || col < 0) {
      throw new RuntimeException();
    }
    if (pieces[row][col] == 0) {
      return true;
    } else {
      return false;
    }
  }

  public void toggleCellShaded(int row, int col) {
    if (row < 0 || col < 0) {
      throw new RuntimeException();
    } else if (pieces[row][col] != 2) {
      pieces[row][col] = 2;
    } else {
      pieces[row][col] = 0;
    }
  }

  public void toggleCellEliminated(int row, int col) {
    if (row < 0 || col < 0) {
      throw new RuntimeException();
    } else if (pieces[row][col] != 1) {
      pieces[row][col] = 1;
    } else {
      pieces[row][col] = 0;
    }
  }

  public void clear() {
    for (int i = 0; i < y; i++) {
      for (int l = 0; l < x; l++) {
        pieces[l][i] = 0;
      }
    }
  }
}
