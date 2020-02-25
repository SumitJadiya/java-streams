package impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Test;

import beans.Car;
import mockdata.MockData;

public class GroupingUsingStreamsTest {

    /**
     * Simple grouping of cars by make
     *
     * @throws IOException Exception while fetching data
     */
    @Test
    public void simpleGrouping() throws IOException {
        Map<String, List<Car>> grouping = MockData.getCars().stream().collect(Collectors.groupingBy(Car::getMake));
        grouping.forEach((make, cars) -> {
            System.out.println(make);
            cars.forEach(System.out::println);
        });
    }

    /**
     * Group and Count Keys
     */
    @Test
    public void groupingAndCounting() {
        ArrayList<String> names = Lists
                .newArrayList(
                        "John",
                        "John",
                        "Mariam",
                        "Alex",
                        "Mohammado",
                        "Mohammado",
                        "Vincent",
                        "Alex",
                        "Alex"
                );

        Map<String, Long> counting = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        counting.forEach((name, count) -> System.out.println(name + " - " + count));
    }
}
