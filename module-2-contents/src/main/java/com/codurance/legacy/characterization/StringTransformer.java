package com.codurance.legacy.characterization;

class StringTransformer {

    public static String f(String inputString) {
        StringBuffer o = new StringBuffer();

        for (int n = 0; n < inputString.length(); ++n) {
            int c = inputString.charAt(n);

            if (c == '<') {
                while (n < inputString.length() && inputString.charAt(n) != '/' && inputString.charAt(n) != '>') {
                    n++;
                }
                if (n < inputString.length() && inputString.charAt(n) == '/') {
                    n += 4;
                } else {
                    n++;
                }
            }

            if (n < inputString.length()) {
                o.append(inputString.charAt(n));
            }
        }

        return new String(o);
    }
}
