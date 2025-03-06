package pl.bsjhx.katas.stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesisTest {

    @Test
    void generateParenthesis() {
        var solution = new GenerateParenthesis();
        assertEquals(List.of("()"), solution.generateParenthesis(1));
        assertEquals(List.of("(())", "()()"), solution.generateParenthesis(2));
    }
}