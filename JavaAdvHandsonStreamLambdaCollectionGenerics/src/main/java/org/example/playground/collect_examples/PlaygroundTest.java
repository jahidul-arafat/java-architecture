package org.example.playground.collect_examples;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlaygroundTest {

    @Test
    void getWrdListGt5Length_withValidInput_shouldReturnListWithWordsOfLengthGreaterThan5() {
        // given
        List<String> input = new ArrayList<>();
        input.add("hello");
        input.add("world");
        input.add("java");

        // when
        List<String> result = Playground.getWrdListGt5Length(input);

        // then
        assertEquals(2, result.size());
        Assertions.assertTrue(result.contains("hello"));
        Assertions.assertTrue(result.contains("world"));
    }

    @Test
    void getWrdListGt5Length_withInvalidInput_shouldReturnEmptyList() {
        // given
        List<String> input = new ArrayList<>();
        input.add("123");
        input.add("abc");

        // when
        List<String> result = Playground.getWrdListGt5Length(input);

        // then
        assertEquals(0, result.size());
    }

    @Test
    void testGetUniqueWrdListGt5Length() {
        // given
        List<String> input = new ArrayList<>();
        input.add("hello");
        input.add("world");
        input.add("hello");
        input.add("java");
        input.add("script");

        // when
        Set<String> result = Playground.getUniqueWrdListGt5Length(input);

        // then
        assertEquals(3, result.size());
        Assertions.assertTrue(result.contains("hello"));
        Assertions.assertTrue(result.contains("world"));
        Assertions.assertTrue(result.contains("script"));
    }
    @Test
    void joinWords_withDelimiter_shouldJoinWordsInListWithSpecifiedDelimiter() {
        // given
        List<String> words = Arrays.asList("hello", "world");
        String delimiter = ":";

        // when
        String joinedWords = Playground.joinWords(words, delimiter);

        // then
        assertEquals("hello:world", joinedWords);
    }

    @Test
    void joinWords_withEmptyDelimiter_shouldJoinWordsInListWithEmptyString() {
        // given
        List<String> words = Arrays.asList("hello", "world");
        String delimiter = "";

        // when
        String joinedWords = Playground.joinWords(words, delimiter);

        // then
        assertEquals("helloworld", joinedWords);
    }

    @Test
    void joinWords_withNullDelimiter_shouldThrowNullPointerException() {
        // given
        List<String> words = Arrays.asList("hello", "world");
        String delimiter = null;

        // when + then
        assertThrows(NullPointerException.class, () -> Playground.joinWords(words, delimiter));
    }
}