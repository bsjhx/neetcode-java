package pl.bsjhx.katas.neetcode.coreskills;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    @Test
    void test1() {
        var array = new DynamicArray(2);
        array.pushback(0);
        array.pushback(1);
        array.pushback(2);

        assertEquals(0, array.get(0));
        assertEquals(1, array.get(1));
        assertEquals(2, array.get(2));

        array.set(0, 10);
        assertEquals(10, array.get(0));
        assertEquals(3, array.getSize());

        assertEquals(4, array.getCapacity());
        array.pushback(3);
        array.pushback(4);
        assertEquals(8, array.getCapacity());

        assertEquals(4, array.popback());
        assertEquals(3, array.popback());
        assertEquals(2, array.popback());
        assertEquals(1, array.popback());
        assertEquals(10, array.popback());
    }

    @Test
    void randomTest() {
        var array = new DynamicArray(2);
        var rand = new Random().nextInt(10_000);
        for (int i = 0; i < rand; i++) {
            array.pushback(i);
        }

        for (int i = 0; i < rand; i++) {
            assertEquals(i, array.get(i));
        }

        assertEquals(rand, array.getSize());

        for (int i = rand - 1; i >= 0; i--) {
            assertEquals(i, array.popback());
        }
    }
}