import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PassportProcessingTest {

    private HashMap<String, String> aValidPassport;
    private HashMap<String, String> anInvalidPassport;

    @BeforeEach
    public void setUp() {
        aValidPassport = new HashMap<>();
        aValidPassport.put("byr", "2000");
        aValidPassport.put("iyr", "2015");
        aValidPassport.put("eyr", "2025");
        aValidPassport.put("hgt", "70in");
        aValidPassport.put("hcl", "#a82123");
        aValidPassport.put("ecl", "blu");
        aValidPassport.put("pid", "123456789");

        anInvalidPassport = new HashMap<>();
        aValidPassport.put("byr", "2000");
        aValidPassport.put("iyr", "2015");
        aValidPassport.put("ecl", "blu");
        aValidPassport.put("pid", "123456789");
    }

    @Test
    void shouldValidatePassport() {
        assertEquals(1, PassportProcessing.validatePassport(aValidPassport));
        assertEquals(0, PassportProcessing.validatePassport(anInvalidPassport));
    }

    @Test
    void shouldValidateByr() {
        assertTrue(PassportProcessing.isValidByr("2000"));
        assertFalse(PassportProcessing.isValidByr("1900"));
    }

    @Test
    void shouldValidateIyr() {
        assertTrue(PassportProcessing.isValidIyr("2015"));
        assertFalse(PassportProcessing.isValidIyr("2009"));
    }

    @Test
    void shouldValidateEyr() {
        assertTrue(PassportProcessing.isValidEyr("2025"));
        assertFalse(PassportProcessing.isValidEyr("2019"));
    }

    @Test
    void shouldValidateHgt() {
        assertTrue(PassportProcessing.isValidHgt("70in"));
        assertTrue(PassportProcessing.isValidHgt("160cm"));
        assertFalse(PassportProcessing.isValidHgt("2019"));
        assertFalse(PassportProcessing.isValidHgt("800cm"));
        assertFalse(PassportProcessing.isValidHgt(""));
    }

    @Test
    void shouldValidateHcl() {
        assertTrue(PassportProcessing.isValidHcl("#a82dc1"));
        assertFalse(PassportProcessing.isValidHcl("#asfa23"));
        assertFalse(PassportProcessing.isValidHcl("#abcfa23"));
        assertFalse(PassportProcessing.isValidHcl("%acfa23"));
    }

    @Test
    void shouldValidateEcl() {
        assertTrue(PassportProcessing.isValidEcl("blu"));
        assertFalse(PassportProcessing.isValidEcl("blw"));
    }

    @Test
    void shouldValidatePid() {
        assertTrue(PassportProcessing.isValidPid("123412351"));
        assertFalse(PassportProcessing.isValidPid("1235123512"));
        assertFalse(PassportProcessing.isValidPid("a35123512"));
    }
}