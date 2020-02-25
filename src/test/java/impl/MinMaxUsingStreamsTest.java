package impl;

import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class MinMaxUsingStreamsTest {

    private final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

    @Test
    public void min() {

        int min = numbers.stream().min(Comparator.naturalOrder()).get();
        Assert.assertEquals(1, min);
    }

    @Test
    public void max() {
        int max = numbers.stream().max(Comparator.naturalOrder()).get();
        Assert.assertEquals(100, max);
    }
}
