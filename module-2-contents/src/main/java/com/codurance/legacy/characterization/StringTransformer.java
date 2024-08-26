package com.codurance.legacy.characterization;

class StringTransformer {

    public static String transformText(String inputString) {
        StringBuffer transformedString = new StringBuffer();

        for (int currentPosition = 0; currentPosition < inputString.length(); ++currentPosition) {
            char currentCharacter = inputString.charAt(currentPosition);
            if (isOpeningChevron(currentCharacter)) {
                while (currentPosition < inputString.length()
                    && !isSlash(inputString.charAt(currentPosition))
                    && !isClosingChevron(inputString.charAt(currentPosition))) {
                    currentPosition++;
                }
                if (currentPosition < inputString.length() && isSlash(inputString.charAt(currentPosition))) {
                    currentPosition += 4;
                } else {
                    currentPosition++;
                }
            }

            if (currentPosition < inputString.length()) {
                transformedString.append(inputString.charAt(currentPosition));
            }
        }

        return new String(transformedString);
    }

    private static boolean isOpeningChevron(char character) {
        return character == '<';
    }

    private static boolean isClosingChevron(char character) {
        return character == '>';
    }

    private static boolean isSlash(char character) {
        return character == '/';
    }
}
