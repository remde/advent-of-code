import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SeatFinderTest {

  @Test
  public void shouldReturn357() {
    assertEquals(357, SeatFinder.findSeatId("FBFBBFFRLR"));
  }

  @Test
  public void shouldReturn567() {
    assertEquals(567, SeatFinder.findSeatId("BFFFBBFRRR"));
  }

  @Test
  public void shouldReturn119() {
    assertEquals(119, SeatFinder.findSeatId("FFFBBBFRRR"));
  }

  @Test
  public void shouldReturn820() {
    assertEquals(820, SeatFinder.findSeatId("BBFFBBFRLL"));
  }
}