package pl.bsjhx.katas.neetcode.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordDictionaryTest {

    @Test
    void addWord() {
        var wordDictionary = new WordDictionary();

        wordDictionary.addWord("test");
        wordDictionary.addWord("trip");

        assertTrue(wordDictionary.search("test"));
        assertTrue(wordDictionary.search("trip"));

        assertFalse(wordDictionary.search("t"));
        assertFalse(wordDictionary.search("te"));
        assertFalse(wordDictionary.search("tes"));
        assertFalse(wordDictionary.search("tri"));
        assertFalse(wordDictionary.search("tr"));

        assertTrue(wordDictionary.search("...."));
        assertTrue(wordDictionary.search(".est"));
        assertTrue(wordDictionary.search("tes."));
        assertFalse(wordDictionary.search(".."));
        assertFalse(wordDictionary.search("..."));
        assertFalse(wordDictionary.search("......."));
    }
}