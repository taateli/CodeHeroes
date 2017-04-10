package app.service;

/*
Service that checks if a string contains Scandinavian letters and changes all
Scandinavian letters to BibText format. 
*/
public class LetterChecker {

    //    private String reference;
//
//    public LetterChecker(String reference) {
//        this.reference = reference;
//
//    }
    public LetterChecker() {

    }

//    public String getReference() {
//        return reference;
//    }
//
//    public void setReference(String reference) {
//        this.reference = reference;
//    }
    public boolean hasScandinavians(String reference) {
        String reference2 = reference.toLowerCase();
        return reference2.contains("ä") || reference2.contains("ö") || reference2.contains("å");
    }

    public String changeScandisToBibTextForm(String reference) {
        char[] characters = reference.toCharArray();
        String modifiedRef = "";

        for (int i = 0; i < characters.length; i++) {
            String letter = Character.toString(characters[i]);
            letter = changeBigOsToBibTextForm(letter);
            letter = changeSmallOsToBibTextForm(letter);
            letter = changeBigAsToBibTextForm(letter);
            letter = changeSmallAsToBibTextForm(letter);
            letter = changeBigOAsToBibTextForm(letter);
            letter = changeSmallOAsToBibTextForm(letter);
            modifiedRef += letter;
        }
        return modifiedRef;
    }

    public String changeBigOsToBibTextForm(String letter) {
        if (letter == "Ö") {
            return "{\\\"O}";
        }
        return letter;
    }

    public String changeSmallOsToBibTextForm(String letter) {
        if (letter.equals("ö")) {
            return "{\\\"o}";
        }
        return letter;
    }

    public String changeBigAsToBibTextForm(String letter) {
        if (letter.equals("Ä")) {
            return "{\\\"A}";
        }
        return letter;
    }

    public String changeSmallAsToBibTextForm(String letter) {
        if (letter.equals("ä")) {
            return "{\\\"a}";
        }
        return letter;
    }

    public String changeBigOAsToBibTextForm(String letter) {
        if (letter.equals("Å")) {
            return "{\\AA}";
        }

        return letter;
    }

    public String changeSmallOAsToBibTextForm(String letter) {
        if (letter.equals("å")) {
            return "{\\aa}";
        }
        return letter;
    }

}
