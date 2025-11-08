package pl.bsjhx.katas.neetcode.priorityqueue;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.priorityqueue.LastStoneWeight;

import static org.junit.jupiter.api.Assertions.*;

class LastStoneWeightTest {

    @Test
    void lastStoneWeight() {
        LastStoneWeight lsw = new LastStoneWeight();
        assertEquals(1, lsw.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}