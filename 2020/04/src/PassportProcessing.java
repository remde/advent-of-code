import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PassportProcessing {


    public static void main(String[] args) {
        HashMap<String, String> passport = new HashMap<String, String>();
        int count = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "../input.txt"));
            String line = reader.readLine();
            while (line != null) {
                parseLineToPassport(line, passport);
                if (line.isEmpty()) {
                    count += validatePassport(passport);
                    passport.clear();
                }
                line = reader.readLine();
            }
            count += validatePassport(passport);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static void parseLineToPassport(String line, HashMap<String, String> passport) {
        StringBuilder currentField = new StringBuilder();
        for (int i=0; i<line.length(); i++) {
            if (line.charAt(i)==' ') {
                addFieldToPassport(currentField.toString(), passport);
                currentField = new StringBuilder();
            }
            else {
                currentField.append(line.charAt(i));
            }
        }
        if (!line.isEmpty()) addFieldToPassport(currentField.toString(), passport);
    }

    public static void addFieldToPassport(String field, HashMap<String,String> passport) {
        String[] fieldAndValue = field.split(":");
        passport.put(fieldAndValue[0], fieldAndValue[1]);
    }

    public static int validatePassport(HashMap<String, String> passport) {
        if ((isValidByr(passport.get("byr")))
                && isValidIyr(passport.get("iyr"))
                && isValidEyr(passport.get("eyr"))
                && isValidHgt(passport.get("hgt"))
                && isValidHcl(passport.get("hcl"))
                && isValidEcl(passport.get("ecl"))
                && isValidPid(passport.get("pid"))
        ) {
            return 1;
        }
        return 0;
    }

    private static boolean isValidByr(String byr) {
        if (byr == null || byr.isEmpty()) return false;

        return Integer.parseInt(byr) <= 2002
                && Integer.parseInt(byr) >= 1920;
    }

    private static boolean isValidIyr(String iyr) {
        if (iyr == null || iyr.isEmpty()) return false;

        return Integer.parseInt(iyr) <= 2020
                && Integer.parseInt(iyr) >= 2010;
    }

    private static boolean isValidEyr(String eyr) {
        if (eyr == null || eyr.isEmpty()) return false;

        return Integer.parseInt(eyr) <= 2030
                && Integer.parseInt(eyr) >= 2020;
    }

    private static boolean isValidHgt(String hgt) {
        if (hgt == null || hgt.length() < 4) return false;
        int hgtNumber = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
        if (hgt.endsWith("in")) {
            return hgtNumber >= 59
                    && hgtNumber <= 76;
        } else if (hgt.endsWith("cm")) {
            return hgtNumber >= 150
                    && hgtNumber <= 193;
        }
        return false;
    }

    private static boolean isValidHcl(String hcl) {
        if (hcl == null || hcl.length() != 7 || hcl.charAt(0) != '#') return false;

        String hairColor = hcl.substring(1);
        Pattern pattern = Pattern.compile("[a-f0-9]+");
        Matcher match = pattern.matcher(hairColor);
        return match.find();
    }

    private static boolean isValidEcl(String ecl) {
        if (ecl == null || ecl.isEmpty()) return false;

        return (ecl.equals("amb")
                || ecl.equals("blu")
                || ecl.equals("brn")
                || ecl.equals("gry")
                || ecl.equals("hzl")
                || ecl.equals("grn")
                || ecl.equals("oth"));
    }

    private static boolean isValidPid(String pid) {
        if (pid == null || pid.length() != 9) return false;

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher match = pattern.matcher(pid);
        return match.find();
    }
}
