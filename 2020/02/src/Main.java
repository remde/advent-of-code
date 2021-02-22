import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int validPasswords = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/I540368/coding/aoc/2020/02/input.txt"));
            String line = reader.readLine();
            while (line != null) {
                validPasswords += parseLine(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(validPasswords);
    }

    private static int parseLine(String line) {
        int minAppearances, maxAppearances;
        char letterPolicy;
        String password;

        if (line.charAt(1) == '-') {
            minAppearances = Character.getNumericValue(line.charAt(0));
            if(line.charAt(3) == ' ') {
                maxAppearances = Character.getNumericValue(line.charAt(2));
                letterPolicy = line.charAt(4);
                password = line.substring(7);
            } else {
                maxAppearances = Integer.parseInt(line.substring(2, 4));
                letterPolicy = line.charAt(5);
                password = line.substring(8);
            }
        } else {
            minAppearances = Integer.parseInt(line.substring(0, 2));
            if(line.charAt(4) == ' ') {
                maxAppearances = Character.getNumericValue(line.charAt(3));
                letterPolicy = line.charAt(5);
                password = line.substring(8);
            } else {
                maxAppearances = Integer.parseInt(line.substring(3, 5));
                letterPolicy = line.charAt(6);
                password = line.substring(9);
            }
        }

        if (isPasswordValid(minAppearances, maxAppearances, letterPolicy, password)) {
            return 1;
        }

        return 0;
    }

    private static boolean isPasswordValid(int minAppearances, int maxAppearances, char letterPolicy, String password) {
        int occurences = 0;

        for (int i=0; i<password.length(); i++) {
            if (password.charAt(i) == letterPolicy) {
                occurences++;
            }
        }

        return (occurences >= minAppearances && occurences <= maxAppearances);
    }
}