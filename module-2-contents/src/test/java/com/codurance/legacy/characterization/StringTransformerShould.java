package com.codurance.legacy.characterization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTransformerShould {
    @Test
    public void keepAsIsASimpleStringWithoutSpecialCharacters() {
        String input = "Hello World";
        String expected = "Hello World";
        String result = StringTransformer.transformText(input);
        assertEquals(expected, result);
    }

    @Test
    public void extractAStringWithOpeningAndClosingTags() {
        String input = "Hello <tag>World<tag/>";
        String expected = "Hello World";
        String result = StringTransformer.transformText(input);
        assertEquals(expected, result);
    }

    @Test
    public void extractStringWithSelfClosingTags() {
        String input = "Hello <br/>  World";
        String expected = "Hello World";
        String result = StringTransformer.transformText(input);
        assertEquals(expected, result);
    }
}
