package views;

import java.awt.Color;
import java.awt.Graphics;

public class LocationView {

  public void drawGridLines(Graphics g) {
    g.setColor(Color.LIGHT_GRAY);
    for (int tmp = 0; tmp <= 7; tmp++) {
      g.drawLine(20, 20 + tmp * 20, 180, 20 + tmp * 20);
    }
    for (int see = 0; see <= 8; see++) {
      g.drawLine(20 + see * 20, 20, 20 + see * 20, 160);
    }
  }
}
