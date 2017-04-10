package app.service;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LetterCheckerTest {

    LetterChecker checker;
    String scandinavian;

    @Before
    public void setUp() {
        checker = new LetterChecker();

    }

    @Test
    public void justATest() {
        assertEquals(true, true);

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
        assertEquals("{\\\"O}", checker.changeBigOsToBibTextForm(scandiLetter));
    }

    @Test
    public void testChangeSmallOsToBibTextForm() {
        String scandiLetter = "ö";
        assertEquals("{\\\"o}", checker.changeSmallOsToBibTextForm(scandiLetter));
    }
    
    @Test
    public void testChangeBigAsToBibTextForm() {
        String scandiLetter = "Ä";
        assertEquals("{\\\"A}", checker.changeBigAsToBibTextForm(scandiLetter));
    }

    @Test
    public void testChangeSmallAsToBibTextForm() {
        String scandiLetter = "ä";
        assertEquals("{\\\"a}", checker.changeSmallAsToBibTextForm(scandiLetter));
    }

    @Test
    public void testChangeBigOAsToBibTextForm() {
        String scandiLetter = "Å";
        assertEquals("{\\AA}", checker.changeBigOAsToBibTextForm(scandiLetter));
    }
    
     @Test
    public void testChangeSmallOAsToBibTextForm() {
        String scandiLetter = "å";
        assertEquals("{\\aa}", checker.changeSmallOAsToBibTextForm(scandiLetter));
    }

    @Test
    public void dontModifyNormalALetters() {
        String letter = "a";
        assertEquals("a", checker.changeSmallAsToBibTextForm(letter));
    }

}
