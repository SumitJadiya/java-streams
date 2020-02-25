package impl;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ReduceUsingStreamsTest {

    @Test
    public void reduce() {
        Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        int sum = Arrays.stream(integers).reduce(0, Integer::sum);
        Assert.assertEquals(sum, 1831);

        sum = Arrays.stream(integers).reduce(0, Integer::sum);
        Assert.assertEquals(sum, 1831);
    }
}
