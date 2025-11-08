package pl.bsjhx.katas.neetcode.stack;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.stack.EvaluateRPN;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateRPNTest {

    @Test
    void evalRPN() {
        EvaluateRPN rpn = new EvaluateRPN();
        assertEquals(16, rpn.evalRPN(new String[]{"10", "6", "+"}));
        assertEquals(11, rpn.evalRPN(new String[]{"10", "6", "+", "5", "-"}));
        assertEquals(88, rpn.evalRPN(new String[]{"10", "6", "+", "5", "-", "8", "*"}));
        assertEquals(44, rpn.evalRPN(new String[]{"10", "6", "+", "5", "-", "8", "*", "2", "/"}));
        assertEquals(22, rpn.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}