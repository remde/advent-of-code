import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    }

    public static void addFieldToPassport(String field, HashMap<String,String> passport) {
        String[] fieldAndValue = field.split(":");
        passport.put(fieldAndValue[0], fieldAndValue[1]);
    }

    public static int validatePassport(HashMap<String, String> passport) {
        System.out.println(passport);
        if ((passport.containsKey("byr"))
                && (passport.containsKey("iyr"))
                && (passport.containsKey("eyr"))
                && (passport.containsKey("hgt"))
                && (passport.containsKey("hcl"))
                && (passport.containsKey("ecl"))
                && (passport.containsKey("pid"))
        ) {
            return 1;
        }
        return 0;
    }
}
