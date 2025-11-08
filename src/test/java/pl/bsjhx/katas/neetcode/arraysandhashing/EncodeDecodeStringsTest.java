package pl.bsjhx.katas.neetcode.arraysandhashing;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.arraysandhashing.EncodeDecodeStrings;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncodeDecodeStringsTest {

    @Test
    void encode() {
        var solution = new EncodeDecodeStrings();
        assertEquals("1#I4#love4#java", solution.encode(List.of("I", "love", "java")));
        assertEquals("", solution.encode(List.of()));
        assertEquals("5#lolek", solution.encode(List.of("lolek")));
        assertEquals("15#lolekloleklole", solution.encode(List.of("lolekloleklolek")));
    }

    @Test
    void decode() {
        var solution = new EncodeDecodeStrings();
        assertEquals(List.of("I", "love", "java"), solution.decode("1#I4#love4#java"));
    }
}