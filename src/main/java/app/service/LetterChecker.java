package app.service;

/*
Service that checks if a string contains Scandinavian letters and changes all
Scandinavian letters to BibText format. 
 */
public class LetterChecker {

    
    public LetterChecker() {

    }

      /**
       * Method to check if a reference contains Scandinavian letters.
       * @param reference, String, received as a parameter
       * @return true, if the reference contains any Scandinavian letters
       */
    public boolean hasScandinavians(String reference) {
        String reference2 = reference.toLowerCase();
        return reference2.contains("ä") || reference2.contains("ö") || reference2.contains("å")
              || reference2.contains("ø") || reference2.contains("æ");
    }

    /**
     * Method to change Scandinavian letters in a reference to forms used by BibText
     * @param reference, String, received as a parameter
     * @return modified reference that has Scandinavian letters changed to BibText forms
     */
    public String changeScandisToBibTextForm(String reference) {
        char[] characters = reference.toCharArray();
        String modifiedRef = "";

        for (int i = 0; i < characters.length; i++) {
            String letter = Character.toString(characters[i]);
            switch (letter) {
                case "å":
                    letter = "{\\aa}";
                    break;
                case "Å":
                    letter = "{\\AA}";
                    break;
                case "ä":
                    letter = "{\\\"a}";
                    break;
                case "Ä":
                    letter = "{\\\"A}";
                    break;
                case "ö":
                    letter = "{\\\"o}";
                    break;
                case "Ö":
                    letter = "{\\\"O}";
                    break;
                case "ø":
                    letter = "{\\o}";
                    break;
                case "Ø":
                    letter = "{\\O}";
                    break;
                case "æ":
                    letter = "{\\ae}";
                    break;
                case "Æ":
                    letter = "{\\AE}";
                    break;
            }
            modifiedRef += letter;
        }
        return modifiedRef;
    }

}
