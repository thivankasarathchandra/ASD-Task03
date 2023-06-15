package models;

public class LocationModel extends SpacePlace {

  public int c;
  public int r;
  public DIRECTION d;
  public int tmp;

  public enum DIRECTION {
    VERTICAL,
    HORIZONTAL,
  }

  public LocationModel(int r, int c) {
    this.r = r;
    this.c = c;
  }

  public LocationModel(int r, int c, DIRECTION d) {
    this(r, c);
    this.d = d;
  }

  public String toString() {
    if (d == null) {
      tmp = c + 1;
      return "(" + (tmp) + "," + (r + 1) + ")";
    } else {
      tmp = c + 1;
      return "(" + (tmp) + "," + (r + 1) + "," + d + ")";
    }
  }
}
