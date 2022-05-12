package com.comp301.a09nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

  private List<Clues> clues;
  private int index;
  private List<ModelObserver> observers;
  private List<Puzzle> puzzleList;
  private List<Board> boardList;

  public ModelImpl(List<Clues> clues) {
    index = 0;
    this.clues = clues;
    this.observers = new ArrayList<>();
    puzzleList = new ArrayList<Puzzle>();
    boardList = new ArrayList<>();
    for (int l = 0; l < clues.size(); l++) {
      Board board = new BoardImpl(clues.get(l).getHeight(), clues.get(l).getWidth());
      if (!boardList.contains(board)) {
        puzzleList.add(new Puzzle(clues.get(l), board));
        boardList.add(board);
      } else {
        throw new IllegalArgumentException();
      }
    }
  }

  public int getPuzzleCount() {
    return clues.size();
  }

  public List<Clues> getClueLists() {
    return clues;
  }

  public int getPuzzleIndex() {
    return index;
  }

  public void setPuzzleIndex(int index) {
    this.index = index;
    for (int i = 0; i < observers.size(); i++) {
      observers.get(i).update(this);
    }
  }

  public void addObserver(ModelObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(ModelObserver observer) {
    observers.remove(observer);
  }

  public boolean isSolved() {
    ArrayList shadedCells = new ArrayList();
    int cellCounter = 0;
    int totalCells = 0;
    int clueTotal = 0;
    for (int i = 0; i < puzzleList.get(getPuzzleIndex()).getClue().getHeight(); i++) { // column
      for (int l = 0; l < puzzleList.get(getPuzzleIndex()).getClue().getWidth(); l++) { // rows
        if (puzzleList.get(getPuzzleIndex()).getBoard().isShaded(i, l)) {
          cellCounter++;
          totalCells++;
        } else if (puzzleList.get(getPuzzleIndex()).getBoard().isEliminated(i, l)
            || puzzleList.get(getPuzzleIndex()).getBoard().isSpace(i, l)) {
          if (cellCounter > 0) {
            shadedCells.add(cellCounter);
          }
          cellCounter = 0;
        }
      }
      if (cellCounter > 0) {
        shadedCells.add(cellCounter);
      }
      cellCounter = 0;
      for (int u = 0; u < puzzleList.get(getPuzzleIndex()).getClue().getRowCluesLength(); u++) {
        if (puzzleList.get(getPuzzleIndex()).getClue().getRowClues(i)[u] != 0) {
          if (!shadedCells.contains(puzzleList.get(getPuzzleIndex()).getClue().getRowClues(i)[u])) {
            return false;
          }
        }
      }

      shadedCells = new ArrayList();
    }
    for (int r = 0; r < puzzleList.get(getPuzzleIndex()).getClue().getRowCluesLength(); r++) {
      for (int t = 0; t < puzzleList.get(getPuzzleIndex()).getClue().getHeight(); t++) {
        clueTotal += puzzleList.get(getPuzzleIndex()).getClue().getRowClues(t)[r];
      }
    }
    if (clueTotal != totalCells) {
      return false;
    }
    clueTotal = 0;
    shadedCells = new ArrayList();
    for (int m = 0; m < puzzleList.get(getPuzzleIndex()).getClue().getWidth(); m++) {
      for (int l = 0; l < puzzleList.get(getPuzzleIndex()).getClue().getHeight(); l++) {
        if (puzzleList.get(getPuzzleIndex()).getBoard().isShaded(l, m)) {
          cellCounter++;
        } else if (puzzleList.get(getPuzzleIndex()).getBoard().isEliminated(l, m)
            || puzzleList.get(getPuzzleIndex()).getBoard().isSpace(l, m)) {
          if (cellCounter > 0) {
            shadedCells.add(cellCounter);
          }
          cellCounter = 0;
        }
      }
      shadedCells.add(cellCounter);
      cellCounter = 0;
      for (int u = 0; u < puzzleList.get(getPuzzleIndex()).getClue().getColCluesLength(); u++) {
        if (puzzleList.get(getPuzzleIndex()).getClue().getColClues(m)[u] != 0) {
          if (!shadedCells.contains(puzzleList.get(getPuzzleIndex()).getClue().getColClues(m)[u])) {
            return false;
          }
        }
      }
      shadedCells = new ArrayList();
    }

    for (int r = 0; r < puzzleList.get(getPuzzleIndex()).getClue().getColCluesLength(); r++) {
      for (int t = 0; t < puzzleList.get(getPuzzleIndex()).getClue().getWidth(); t++) {
        clueTotal += puzzleList.get(getPuzzleIndex()).getClue().getColClues(t)[r];
      }
    }
    if (clueTotal != totalCells) {
      return false;
    }
    return true;
  }

  public boolean isShaded(int row, int col) {
    if (puzzleList.get(getPuzzleIndex()).board.isShaded(row, col) == true) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isEliminated(int row, int col) {
    if (puzzleList.get(getPuzzleIndex()).board.isEliminated(row, col) == true) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isSpace(int row, int col) {
    if (puzzleList.get(getPuzzleIndex()).board.isSpace(row, col) == true) {
      return true;
    } else {
      return false;
    }
  }

  public void toggleCellShaded(int row, int col) {
    puzzleList.get(getPuzzleIndex()).getBoard().toggleCellShaded(row, col);
    for (int i = 0; i < observers.size(); i++) {
      observers.get(i).update(this);
    }
  }

  public void toggleCellEliminated(int row, int col) {
    puzzleList.get(getPuzzleIndex()).getBoard().toggleCellEliminated(row, col);
    for (int i = 0; i < observers.size(); i++) {
      observers.get(i).update(this);
    }
  }

  public void clear() {
    puzzleList.get(getPuzzleIndex()).getBoard().clear();
    for (int i = 0; i < observers.size(); i++) {
      observers.get(i).update(this);
    }
  }

  public int getWidth() {
    return puzzleList.get(getPuzzleIndex()).getClue().getWidth();
  }

  public int getHeight() {
    return puzzleList.get(getPuzzleIndex()).getClue().getHeight();
  }

  public int[] getRowClues(int index) {
    return puzzleList.get(getPuzzleIndex()).getClue().getRowClues(index);
  }

  public int[] getColClues(int index) {
    return puzzleList.get(getPuzzleIndex()).getClue().getColClues(index);
  }

  public int getRowCluesLength() {
    return puzzleList.get(getPuzzleIndex()).getClue().getRowCluesLength();
  }

  public int getColCluesLength() {
    return puzzleList.get(getPuzzleIndex()).getClue().getColCluesLength();
  }
}
