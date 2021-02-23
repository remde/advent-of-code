import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PasswordPhilosophy {

    public static void main(String[] args) {
        int validPasswords = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "../input.txt"));
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
        int minAppearances, maxAppearances, stringStart;
        char policyLetter;

        if (line.charAt(1) == '-') {
            minAppearances = Character.getNumericValue(line.charAt(0));
            if(line.charAt(3) == ' ') {
                maxAppearances = Character.getNumericValue(line.charAt(2));
                policyLetter = line.charAt(4);
                stringStart = 7;
            } else {
                maxAppearances = Integer.parseInt(line.substring(2, 4));
                policyLetter = line.charAt(5);
                stringStart = 8;
            }
        } else {
            minAppearances = Integer.parseInt(line.substring(0, 2));
            if(line.charAt(4) == ' ') {
                maxAppearances = Character.getNumericValue(line.charAt(3));
                policyLetter = line.charAt(5);
                stringStart = 8;
            } else {
                maxAppearances = Integer.parseInt(line.substring(3, 5));
                policyLetter = line.charAt(6);
                stringStart = 9;
            }
        }

        if (isPasswordValid(minAppearances, maxAppearances, policyLetter, stringStart, line)) {
            return 1;
        }

        return 0;
    }

    private static boolean isPasswordValid(int minAppearances, int maxAppearances, char policyLetter, int stringStart, String password) {
        int occurences = 0;

//        PART 1
//        for (int i=stringStart; i<password.length(); i++) {
//            if (password.charAt(i) == policyLetter) {
//                occurences++;
//            }
//        }
//        return (occurences >= minAppearances && occurences <= maxAppearances);


//        PART 2
        String formattedPassword = password.substring(stringStart - 1);
        return ((formattedPassword.charAt(minAppearances) == policyLetter &&
                    formattedPassword.charAt(maxAppearances) != policyLetter)
                || (formattedPassword.charAt(maxAppearances) == policyLetter &&
                        formattedPassword.charAt(minAppearances) != policyLetter));
    }
}
