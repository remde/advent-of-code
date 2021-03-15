import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TobogganTrajectoryTest {

    private TobogganTrajectory tobogganTrajectory;
    private List<String> aTreeMap;

    @BeforeEach
    public void setUp() {
        aTreeMap = Arrays.asList(
                "..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");
    }


    @Test
    @DisplayName("Should count number of trees in a traversal")
    public void testTreeCount() {
        assertEquals(7, TobogganTrajectory.countTrees(aTreeMap, 3, 1),
                "Part 1 works");
        assertEquals(2, TobogganTrajectory.countTrees(aTreeMap, 1, 1),
                "Part 2.1 works");
        assertEquals(7, TobogganTrajectory.countTrees(aTreeMap, 3, 1),
                "Part 2.2 works");
        assertEquals(3, TobogganTrajectory.countTrees(aTreeMap, 5, 1),
                "Part 2.3 works");
        assertEquals(4, TobogganTrajectory.countTrees(aTreeMap, 7, 1),
                "Part 2.4 works");
        assertEquals(2, TobogganTrajectory.countTrees(aTreeMap, 1, 2),
                "Part 2.5 works");
    }
}