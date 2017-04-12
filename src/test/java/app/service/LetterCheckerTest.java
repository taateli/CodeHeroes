package app.service;

import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LetterCheckerTest {

    LetterChecker checker;
    String scandinavian;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        checker = new LetterChecker();

    }

    @Test
    public void hasScandinavianAsTest() {
        scandinavian = "Tässä on nyt Äätä";
        assertEquals(true, checker.hasScandinavians(scandinavian));

    }

    @Test
    public void hasScandinavianOsTest() {
        scandinavian = "Örkeillä ei ole löylysaunaa";
        assertEquals(true, checker.hasScandinavians(scandinavian));

    }

    @Test
    public void hasSwedishOsTest() {
        scandinavian = "Åke ån åikein mukava";
        assertEquals(true, checker.hasScandinavians(scandinavian));

    }

    @Test
    public void inputIsAnEmptyString() {
        assertEquals(false, checker.hasScandinavians(""));
    }

    @Test
    public void testChangeBigOsToBibTextForm() {
        String scandiLetter = "Ö";
        assertEquals("{\\\"O}", checker.changeScandisToBibTextForm(scandiLetter));
    }

    @Test
    public void testChangeSmallOsToBibTextForm() {
        String scandiLetter = "ö";
        assertEquals("{\\\"o}", checker.changeScandisToBibTextForm(scandiLetter));
    }

    @Test
    public void testChangeBigAsToBibTextForm() {
        String scandiLetter = "Ä";
        assertEquals("{\\\"A}", checker.changeScandisToBibTextForm(scandiLetter));
    }

    @Test
    public void testChangeSmallAsToBibTextForm() {
        String scandiLetter = "ä";
        assertEquals("{\\\"a}", checker.changeScandisToBibTextForm(scandiLetter));
    }

    @Test
    public void testChangeBigOAsToBibTextForm() {
        String scandiLetter = "Å";
        assertEquals("{\\AA}", checker.changeScandisToBibTextForm(scandiLetter));
    }

    @Test
    public void testChangeSmallOAsToBibTextForm() {
        String scandiLetter = "å";
        assertEquals("{\\aa}", checker.changeScandisToBibTextForm(scandiLetter));
    }

    @Test
    public void testChangeSmallOOsToBibTextForm() {
        String scandiLetter = "ø";
        assertEquals("{\\o}", checker.changeScandisToBibTextForm(scandiLetter));
    }

    @Test
    public void testChangeBigOOsToBibTextForm() {
        String scandiLetter = "Ø";
        assertEquals("{\\O}", checker.changeScandisToBibTextForm(scandiLetter));
    }

    @Test
    public void testChangeSmallAEsToBibTextForm() {
        String scandiLetter = "æ";
        assertEquals("{\\ae}", checker.changeScandisToBibTextForm(scandiLetter));
    }

    @Test
    public void testChangeBigAEsToBibTextForm() {
        String scandiLetter = "Æ";
        assertEquals("{\\AE}", checker.changeScandisToBibTextForm(scandiLetter));
    }

    @Test
    public void dontModifyNormalALetters() {
        String letter = "abcd";
        assertEquals("abcd", checker.changeScandisToBibTextForm(letter));
    }

}
