package pl.bsjhx.katas.stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperaturesTest {

    @Test
    void dailyTemperatures() {
        DailyTemperatures dt = new DailyTemperatures();
        int[] ints = dt.dailyTemperatures(new int[]{30, 40, 50, 60});
        System.out.println(Arrays.toString(ints));

        ints = dt.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
        System.out.println(Arrays.toString(ints));
    }
}