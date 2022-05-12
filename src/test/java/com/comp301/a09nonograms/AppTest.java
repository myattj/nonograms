package com.comp301.a09nonograms;

import static org.junit.Assert.assertTrue;

import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import org.junit.Test;

import java.util.List;

/** Unit test for simple App. */
public class AppTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    List<Clues> clueList = PuzzleLibrary.create();
    Model model = new ModelImpl(clueList);
    model.setPuzzleIndex(0);

    model.clear();
    model.toggleCellShaded(0, 0);
    model.toggleCellShaded(0, 2);
    model.toggleCellShaded(0, 3);

    System.out.println(model.isSolved());
  }
}
