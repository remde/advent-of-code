/**
 * Returns an integer that represents a passenger seat. It calculates it
 * in a binary fashion: the range starts from 0 to 127. In the first seven
 * characters, an F indicates lower half, and B upper half, and the final result
 * is the row. The last three characters are for the column and will be L or R,
 * this time L means lower half and R upper half. The final seat ID is given by
 * the result of row*8 + column.
 */
public class SeatFinder {
  private static final char LOWER_HALF_ROW = 'F';
  private static final char UPPER_HALF_ROW = 'B';
  private static final char LOWER_HALF_COLUMN = 'L';
  private static final char UPPER_HALF_COLUMN = 'R';
  private static final int MIN_STARTING_RANGE = 0;
  private static final int MAX_ROW_STARTING_RANGE = 127;
  private static final int MAX_COLUMN_STARTING_RANGE = 7;

  public static int findSeatId(String seat) {
    int rowNumber = calculateRow(seat.substring(0,7));
    int columnNumber = calculateColumn(seat.substring(7));
    return rowNumber * 8 + columnNumber;
  }

  private static int calculateRow(String rowCode) {
    return seatBinarySearch(
        rowCode,
        MAX_ROW_STARTING_RANGE,
        LOWER_HALF_ROW,
        UPPER_HALF_ROW
    );
  }

  private static int calculateColumn(String columnCode) {
    return seatBinarySearch(
        columnCode,
        MAX_COLUMN_STARTING_RANGE,
        LOWER_HALF_COLUMN,
        UPPER_HALF_COLUMN
    );
  }

  private static int seatBinarySearch(
      String seat,
      int endPoint,
      char lowerHalfCode,
      char upperHalfCode) {
    int startPoint = MIN_STARTING_RANGE;
    int midPoint = (endPoint+startPoint)/2;
    for (char code : seat.toCharArray()) {
      if (code == lowerHalfCode) {
        endPoint = midPoint;
      } else if (code == upperHalfCode) {
        startPoint = midPoint + 1;
      }
      midPoint = (endPoint+startPoint)/2;
    }
    return midPoint;
  }
}
