import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class TobogganTrajectory {

    public static void main(String[] args) {
        List<String> treeMap = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "../input.txt"));
            String line = reader.readLine();
            while (line != null) {
                treeMap.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long treeCount = countTrees(treeMap, 3, 1);
        System.out.println("Part 1 answer: " + treeCount);

        long treeMultiplicationCount = countTrees(treeMap, 1, 1)*
                countTrees(treeMap, 3, 1)*
                countTrees(treeMap, 5, 1)*
                countTrees(treeMap, 7, 1)*
                countTrees(treeMap, 1, 2);
        System.out.println("Part 2 answer: " + treeMultiplicationCount);
    }

    public static long countTrees(List<String> treeMap, int horizontalStep, int verticalStep) {
        int maxLength = treeMap.get(0).length();
        int horizontalPosition = horizontalStep;
        long count = 0;
        for (int i = verticalStep; i<treeMap.size(); i+=verticalStep) {
            horizontalPosition = horizontalPosition % maxLength;
            char position = treeMap.get(i).charAt(horizontalPosition);
            if (position == '#') {
                count++;
            }
            horizontalPosition += horizontalStep;
        }
        return count;
    }
}
