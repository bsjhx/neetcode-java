package pl.bsjhx.bitmanipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitsManipulationsEasyTest {

    @Test
    void missingNumber() {
        BitsManipulationsEasy a = new BitsManipulationsEasy();
        int i = a.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
        System.out.println(i);
    }
}