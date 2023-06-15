package controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LocationController {

  public static int getInt() {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    do {
      try {
        return Integer.parseInt(r.readLine());
      } catch (Exception e) {}
    } while (true);
  }
}
