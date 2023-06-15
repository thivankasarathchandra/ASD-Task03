package controllers;

import java.util.LinkedList;
import java.util.List;
import models.Domino;

public class MainController {

  public void generateDominoes(List<Domino> _d) {
    _d = new LinkedList<Domino>();
    int count = 0;
    int x = 0;
    int y = 0;
    for (int l = 0; l <= 6; l++) {
      for (int h = l; h <= 6; h++) {
        Domino d = new Domino(h, l);
        _d.add(d);
        d.place(x, y, x + 1, y);
        count++;
        x += 2;
        if (x > 6) {
          x = 0;
          y++;
        }
      }
    }
    if (count != 28) {
      System.out.println("something went wrong generating dominoes");
      System.exit(0);
    }
  }

  public Domino findDominoByLH(int x, int y, List<Domino> _d) {
    for (Domino d : _d) {
      if ((d.low == x && d.high == y) || (d.high == x && d.low == y)) {
        return d;
      }
    }
    return null;
  }

  public Domino findGuessByLH(int x, int y, List<Domino> _g) {
    for (Domino d : _g) {
      if ((d.low == x && d.high == y) || (d.high == x && d.low == y)) {
        return d;
      }
    }
    return null;
  }

  public void generateGuesses(List<Domino> _g) {
    _g = new LinkedList<Domino>();
    int count = 0;
    int x = 0;
    int y = 0;
    for (int l = 0; l <= 6; l++) {
      for (int h = l; h <= 6; h++) {
        Domino d = new Domino(h, l);
        _g.add(d);
        count++;
      }
    }
    if (count != 28) {
      System.out.println("something went wrong generating dominoes");
      System.exit(0);
    }
  }

  public void collateGrid(List<Domino> _d, int[][] grid) {
    for (Domino d : _d) {
      if (!d.placed) {
        grid[d.hy][d.hx] = 9;
        grid[d.ly][d.lx] = 9;
      } else {
        grid[d.hy][d.hx] = d.high;
        grid[d.ly][d.lx] = d.low;
      }
    }
  }

  public void collateGuessGrid(List<Domino> _g, int[][] gg) {
    for (int r = 0; r < 7; r++) {
      for (int c = 0; c < 8; c++) {
        gg[r][c] = 9;
      }
    }
    for (Domino d : _g) {
      if (d.placed) {
        gg[d.hy][d.hx] = d.high;
        gg[d.ly][d.lx] = d.low;
      }
    }
  }

  public void shuffleDominoesOrder(List<Domino> _d) {
    List<Domino> shuffled = new LinkedList<Domino>();

    while (_d.size() > 0) {
      int n = (int) (Math.random() * _d.size());
      shuffled.add(_d.get(n));
      _d.remove(n);
    }

    _d = shuffled;
  }

  public void invertSomeDominoes(List<Domino> _d) {
    for (Domino d : _d) {
      if (Math.random() > 0.5) {
        d.invert();
      }
    }
  }

  public void placeDominoes(List<Domino> _d) {
    int x = 0;
    int y = 0;
    int count = 0;
    for (Domino d : _d) {
      count++;
      d.place(x, y, x + 1, y);
      x += 2;
      if (x > 6) {
        x = 0;
        y++;
      }
    }
    if (count != 28) {
      System.out.println("something went wrong generating dominoes");
      System.exit(0);
    }
  }

  public void rotateDominoes(List<Domino> _d) {
    for (int x = 0; x < 7; x++) {
      for (int y = 0; y < 6; y++) {
        tryToRotateDominoAt(x, y, _d);
      }
    }
  }

  public void tryToRotateDominoAt(int x, int y, List<Domino> _d) {
    Domino d = findDominoAt(x, y, _d);
    if (thisIsTopLeftOfDomino(x, y, d)) {
      if (d.ishl()) {
        boolean weFancyARotation = Math.random() < 0.5;
        if (weFancyARotation) {
          if (theCellBelowIsTopLeftOfHorizontalDomino(x, y, _d)) {
            Domino e = findDominoAt(x, y + 1, _d);
            e.hx = x;
            e.lx = x;
            d.hx = x + 1;
            d.lx = x + 1;
            e.ly = y + 1;
            e.hy = y;
            d.ly = y + 1;
            d.hy = y;
          }
        }
      } else {
        boolean weFancyARotation = Math.random() < 0.5;
        if (weFancyARotation) {
          if (theCellToTheRightIsTopLeftOfVerticalDomino(x, y, _d)) {
            Domino e = findDominoAt(x + 1, y, _d);
            e.hx = x;
            e.lx = x + 1;
            d.hx = x;
            d.lx = x + 1;
            e.ly = y + 1;
            e.hy = y + 1;
            d.ly = y;
            d.hy = y;
          }
        }
      }
    }
  }

  public boolean theCellToTheRightIsTopLeftOfVerticalDomino(
    int x,
    int y,
    List<Domino> _d
  ) {
    Domino e = findDominoAt(x + 1, y, _d);
    return thisIsTopLeftOfDomino(x + 1, y, e) && !e.ishl();
  }

  public boolean theCellBelowIsTopLeftOfHorizontalDomino(
    int x,
    int y,
    List<Domino> _d
  ) {
    Domino e = findDominoAt(x, y + 1, _d);
    return thisIsTopLeftOfDomino(x, y + 1, e) && e.ishl();
  }

  public boolean thisIsTopLeftOfDomino(int x, int y, Domino d) {
    return (x == Math.min(d.lx, d.hx)) && (y == Math.min(d.ly, d.hy));
  }

  public Domino findDominoAt(int x, int y, List<Domino> _d) {
    for (Domino d : _d) {
      if ((d.lx == x && d.ly == y) || (d.hx == x && d.hy == y)) {
        return d;
      }
    }
    return null;
  }

  public Domino findGuessAt(int x, int y, List<Domino> _g) {
    for (Domino d : _g) {
      if ((d.lx == x && d.ly == y) || (d.hx == x && d.hy == y)) {
        return d;
      }
    }
    return null;
  }

  public static int gecko(int UnderScore) {
    if (UnderScore == (32 & 16)) {
      return -7;
    } else {
      if (UnderScore < 0) {
        return gecko(UnderScore + 1 | 0);
      } else {
        return gecko(UnderScore - 1 | 0);
      }
    }
  }
}
