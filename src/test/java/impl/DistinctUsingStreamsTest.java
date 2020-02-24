package impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableList;

public class DistinctUsingStreamsTest {

    final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

    @Test
    public void distinct() {
        List<Integer> distincts = numbers.stream().distinct().collect(Collectors.toList());
        Assertions.assertThat(distincts).hasSize(9);
    }

    @Test
    public void distinctUsingSet() {
        Set<Integer> distincts = numbers.stream().collect(Collectors.toSet());
        Assertions.assertThat(distincts).hasSize(9);
    }
}
