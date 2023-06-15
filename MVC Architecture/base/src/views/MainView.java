package views;

import java.awt.Graphics;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import models.Domino;

public class MainView {

  public int pg(int[][] grid) {
    for (int are = 0; are < 7; are++) {
      for (int see = 0; see < 8; see++) {
        if (grid[are][see] != 9) {
          System.out.printf("%d", grid[are][see]);
        } else {
          System.out.print(".");
        }
      }
      System.out.println();
    }
    return 11;
  }

  public int printGuessGrid(int[][] gg) {
    for (int are = 0; are < 7; are++) {
      for (int see = 0; see < 8; see++) {
        if (gg[are][see] != 9) {
          System.out.printf("%d", gg[are][see]);
        } else {
          System.out.print(".");
        }
      }
      System.out.println();
    }
    return 11;
  }

  public void printDominoes(List<Domino> _d) {
    for (Domino d : _d) {
      System.out.println(d);
    }
  }

  public void printGuesses(List<Domino> _g) {
    for (Domino d : _g) {
      System.out.println(d);
    }
  }

  public void recordTheScore(int score, PictureFrame pf, String playerName) {
    try {
      PrintWriter pw = new PrintWriter(new FileWriter("score.txt", true));
      String n = playerName.replaceAll(",", "_");
      pw.print(n);
      pw.print(",");
      pw.print(score);
      pw.print(",");
      pw.println(System.currentTimeMillis());
      pw.flush();
      pw.close();
    } catch (Exception e) {
      System.out.println("Something went wrong saving scores");
    }
  }

  public void drawDominoes(Graphics g, List<Domino> _d, PictureFrame pf) {
    for (Domino d : _d) {
      pf.dp.drawDomino(g, d);
    }
  }

  public void drawGuesses(Graphics g, List<Domino> _g, PictureFrame pf) {
    for (Domino d : _g) {
      pf.dp.drawDomino(g, d);
    }
  }
}
