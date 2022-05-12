package com.comp301.a09nonograms.controller;

import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;

public class ControllerImpl implements Controller {
  private Model model;

  public ControllerImpl(Model model) {
    this.model = model;
  }

  public Clues getClues() {
    return model.getClueLists().get(model.getPuzzleIndex());
  }

  public boolean isSolved() {
    return model.isSolved();
  }

  public boolean isShaded(int row, int col) {
    return model.isShaded(row, col);
  }

  public boolean isEliminated(int row, int col) {
    return model.isEliminated(row, col);
  }

  public void toggleShaded(int row, int col) {
    model.toggleCellShaded(row, col);
  }

  public void toggleEliminated(int row, int col) {
    model.toggleCellEliminated(row, col);
  }

  public void nextPuzzle() {
    if (model.getPuzzleIndex() < model.getClueLists().size() - 1) {
      model.setPuzzleIndex(model.getPuzzleIndex() + 1);
    } else {
      model.setPuzzleIndex(0);
    }
  }

  public void prevPuzzle() {
    if (model.getPuzzleIndex() > 0) {
      model.setPuzzleIndex(model.getPuzzleIndex() - 1);
    } else {
      model.setPuzzleIndex(model.getPuzzleCount() - 1);
    }
  }

  public void randPuzzle() {
    model.setPuzzleIndex((int) (Math.random() * (model.getClueLists().size())));
  }

  public void clearBoard() {
    model.clear();
  }

  public int getPuzzleIndex() {
    return model.getPuzzleIndex();
  }

  public int getPuzzleCount() {
    return model.getPuzzleCount();
  }
}
