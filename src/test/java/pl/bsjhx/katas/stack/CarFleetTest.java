package pl.bsjhx.katas.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFleetTest {

    @Test
    void carFleet() {
        var carFleet = new CarFleet();
        assertEquals(3, carFleet.carFleet(10, new int[]{4,1,0,7}, new int[]{2,2,1,1}));
        assertEquals(1, carFleet.carFleet(10, new int[]{1, 4}, new int[]{3, 2}));
        assertEquals(3, carFleet.carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
        assertEquals(2, carFleet.carFleet(10, new int[]{6, 8}, new int[]{3, 2}));
    }
}