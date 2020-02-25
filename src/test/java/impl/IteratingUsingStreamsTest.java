package impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import beans.Person;
import mockdata.MockData;

/**
 * Iterating Objects using Streams API
 */
class IteratingUsingStreamsTest {
    /**
     * For Loop conversion using Streams API
     */
    @Test
    public void range() {
        System.out.println("exclusive");
        IntStream.range(0, 10).forEach(System.out::println);

        System.out.println("inclusive");
        IntStream.rangeClosed(0, 10).forEach(System.out::println);
    }

    /**
     * Iterate List of persons
     *
     * @throws IOException Exception while fetching data
     */
    @Test
    public void rangeIteratingLists() throws IOException {
        List<Person> people = MockData.getPeople();

        IntStream.range(0, people.size()).forEach(index -> {
            Person person = people.get(index);
            System.out.println(person);
        });
    }

    /**
     * Iterate 20 Even numbers using IntStream
     */
    @Test
    public void intStreamIterate() {
        IntStream.iterate(0, operand -> operand + 1).filter(number -> number % 2 == 0).limit(20).forEach(System.out::println);
    }
}
