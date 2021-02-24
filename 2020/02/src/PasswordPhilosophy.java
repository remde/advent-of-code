import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PasswordPhilosophy {

    private static final String AT_COLON = ":";
    private static final int IN_TWO = 2;
    private static final String AT_BLANK_SPACE = " ";
    private static final String AT_HYPHEN = "-";
    private static final int FIRST_POSITION = 0;

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
        int minAppearances, maxAppearances;
        char policyLetter;
        String password;

        String[] halfLineArray = line.split(AT_COLON, IN_TWO);
        String[] quarterLineArray = halfLineArray[0].split(AT_BLANK_SPACE, IN_TWO);
        String[] policyRange = quarterLineArray[0].split(AT_HYPHEN, IN_TWO);

        minAppearances = Integer.parseInt(policyRange[0]);
        maxAppearances = Integer.parseInt(policyRange[1]);
        policyLetter = quarterLineArray[1].charAt(FIRST_POSITION);
        password = halfLineArray[1];

        if (isPasswordValid(minAppearances, maxAppearances, policyLetter, password)) {
            return 1;
        }

        return 0;
    }

    private static boolean isPasswordValid(int minAppearances, int maxAppearances, char policyLetter, String password) {
        int occurences = 0;

//        PART 1
//        for (int i=1; i<password.length(); i++) {
//            if (password.charAt(i) == policyLetter) {
//                occurences++;
//            }
//        }
//        return (occurences >= minAppearances && occurences <= maxAppearances);


//        PART 2
        return ((password.charAt(minAppearances) == policyLetter &&
                    password.charAt(maxAppearances) != policyLetter)
                || (password.charAt(maxAppearances) == policyLetter &&
                        password.charAt(minAppearances) != policyLetter));
    }
}
