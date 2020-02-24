package impl;


import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Test;

public class FindUsingStreamsTest {
    private final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;
    private Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    /**
     * findAny() method allows you to find any element from a Stream
     */
    @Test
    public void findAny() {
        Optional<Integer> any = Arrays.stream(numbers).parallel().filter(numbersLessThan10).findAny();
        Assert.assertThat(any.isPresent() ? any.get() : 0, anyOf(is(6), is(7), is(8), is(9)));
    }

    /**
     * Finds first element after fulfil the filter
     */
    @Test
    public void findFirst() {
        int first = Arrays.stream(numbers).filter(numbersLessThan10).findFirst().get();
        Assert.assertEquals(first, 6);
    }
}
