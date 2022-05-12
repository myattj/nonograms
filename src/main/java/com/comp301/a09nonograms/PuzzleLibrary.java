package com.comp301.a09nonograms;

import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.CluesImpl;
import java.util.ArrayList;
import java.util.List;

public class PuzzleLibrary {
  private static List<Clues> clues;
  private int i;

  public static List<Clues> create() {
    if (clues == null) {
      createPuzzleLibrary();
    }
    return clues;
  }
    public void addI(){
      i++;
    }

    private static void createPuzzleLibrary() {
    clues = new ArrayList<>();
    clues.add(
        new CluesImpl(
            new int[][] {
              new int[] {0, 0},
              new int[] {0, 4},
              new int[] {0, 6},
              new int[] {2, 2},
              new int[] {2, 2},
              new int[] {0, 6},
              new int[] {0, 4},
              new int[] {0, 2},
              new int[] {0, 2},
              new int[] {0, 2},
              new int[] {0, 0},
            },
            new int[][] {
              new int[] {0, 0},
              new int[] {0, 9},
              new int[] {0, 9},
              new int[] {2, 2},
              new int[] {2, 2},
              new int[] {0, 4},
              new int[] {0, 4},
              new int[] {0, 0},
            }));
    clues.add(
        new CluesImpl(
            new int[][] {
              new int[] {1, 0},
              new int[] {0, 4},
              new int[] {0, 6},
              new int[] {2, 2},
              new int[] {2, 2},
              new int[] {0, 6},
              new int[] {0, 4},
              new int[] {0, 2},
              new int[] {0, 2},
              new int[] {0, 2},
              new int[] {0, 0},
            },
            new int[][] {
              new int[] {1, 0},
              new int[] {0, 9},
              new int[] {0, 9},
              new int[] {2, 2},
              new int[] {2, 2},
              new int[] {0, 4},
              new int[] {0, 4},
              new int[] {0, 0},
            }));

    clues.add(
        new CluesImpl(
            new int[][] {
              new int[] {1, 1, 1},
              new int[] {0, 1, 3},
              new int[] {0, 0, 2},
              new int[] {0, 0, 2},
              new int[] {0, 0, 2},
            },
            new int[][] {
              new int[] {2, 1, 1},
              new int[] {0, 1, 1},
              new int[] {0, 1, 1},
              new int[] {0, 1, 1},
              new int[] {
                0, 3, 1,
              },
            }));

    clues.add(
        new CluesImpl(
            new int[][] {
              new int[] {0, 4, 2},
              new int[] {0, 0, 4},
              new int[] {0, 0, 6},
              new int[] {0, 2, 2},
              new int[] {0, 2, 3},
              new int[] {0, 1, 4},
              new int[] {1, 1, 1},
              new int[] {0, 1, 4},
              new int[] {0, 3, 2},
              new int[] {0, 0, 7},
            },
            new int[][] {
              new int[] {0, 0, 0, 3},
              new int[] {0, 0, 0, 4},
              new int[] {0, 0, 0, 9},
              new int[] {0, 3, 1, 2},
              new int[] {0, 0, 1, 5},
              new int[] {1, 4, 1, 1},
              new int[] {0, 1, 3, 3},
              new int[] {0, 0, 0, 6},
              new int[] {0, 0, 0, 1},
              new int[] {0, 0, 0, 1},
            }));

    clues.add(
        new CluesImpl(
            new int[][] {
              new int[] {0, 3},
              new int[] {0, 4},
              new int[] {0, 3},
              new int[] {1, 1},
              new int[] {0, 1},
            },
            new int[][] {
              new int[] {2, 1},
              new int[] {0, 2},
              new int[] {0, 4},
              new int[] {0, 2},
              new int[] {0, 2},
            }));

    clues.add(
        new CluesImpl(
            new int[][] {
              new int[] {0, 0, 5},
              new int[] {0, 0, 6},
              new int[] {0, 0, 8},
              new int[] {0, 2, 3},
              new int[] {0, 0, 3},
              new int[] {0, 0, 5},
              new int[] {0, 0, 7},
              new int[] {0, 0, 2},
              new int[] {2, 1, 3},
              new int[] {0, 2, 1},
            },
            new int[][] {
              new int[] {0, 1, 2},
              new int[] {1, 1, 2},
              new int[] {0, 4, 1},
              new int[] {4, 2, 1},
              new int[] {0, 3, 3},
              new int[] {0, 0, 9},
              new int[] {0, 5, 1},
              new int[] {4, 1, 1},
              new int[] {0, 1, 1},
              new int[] {0, 1, 1},
            }));
  }
}
