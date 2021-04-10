import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static java.lang.Math.max;


public class BinaryBoarding {

  public static void main(String[] args) {
    HashMap<Integer, String> boardingPasses = new HashMap<>();
    int currentSeatId;
    int maxSeatId = Integer.MIN_VALUE;
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(
          "../input.txt"));
      String line = reader.readLine();
      while (line != null) {
        currentSeatId = SeatFinder.findSeatId(line);
        boardingPasses.put(currentSeatId, line);
        maxSeatId = max(currentSeatId, maxSeatId);
        line = reader.readLine();
      }
      reader.close();
      int myId = findMyId(boardingPasses);
      System.out.println("Highest ID: " + maxSeatId);
      System.out.println("My ID: " + myId);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static int findMyId(HashMap<Integer, String> boardingPasses) {
    int currentIndex = 0;
    while (true) {
      if (boardingPasses.containsKey(currentIndex)) {
        while (true) {
          if (!boardingPasses.containsKey(currentIndex)) {
            return currentIndex;
          }
          currentIndex++;
        }
      }
      currentIndex++;
    }
  }
}
