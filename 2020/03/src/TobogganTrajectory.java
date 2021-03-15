import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class TobogganTrajectory {

    static List<String> treeMap;

    public TobogganTrajectory() {
        treeMap = new ArrayList<>();
    }

    public static void main(String[] args) {
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

        System.out.print(treeMap);
    }

}
