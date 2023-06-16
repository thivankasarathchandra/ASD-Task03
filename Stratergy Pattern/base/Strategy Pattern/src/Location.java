
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Location extends SpacePlace {
    public int c;
    public int r;
    public DIRECTION d;
    public GridLinesDrawingStrategy gridLinesStrategy;  // Strategy interface reference

    public enum DIRECTION {
        VERTICAL, HORIZONTAL
    };

    public Location(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public Location(int r, int c, DIRECTION d) {
        this(r, c);
        this.d = d;
    }

    public String toString() {
        if (d == null) {
            int tmp = c + 1;
            return "(" + tmp + "," + (r + 1) + ")";
        } else {
            int tmp = c + 1;
            return "(" + tmp + "," + (r + 1) + "," + d + ")";
        }
    }

    public void setGridLinesStrategy(GridLinesDrawingStrategy strategy) {
        this.gridLinesStrategy = strategy;
    }

    public void drawGridLines(Graphics g) {
        if (gridLinesStrategy != null) {
            gridLinesStrategy.drawGridLines(g);
        }
    }

    public static int getInt() {
    	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {
				return Integer.parseInt(r.readLine());
			} catch (Exception e) {
			}
		} while (true);
    }
}
