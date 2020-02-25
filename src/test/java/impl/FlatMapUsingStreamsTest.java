package impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

public class FlatMapUsingStreamsTest {
    private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
            Lists.newArrayList("Mariam", "Alex", "Ismail"),
            Lists.newArrayList("John", "Alesha", "Andre"),
            Lists.newArrayList("Susy", "Ali")
    );

    @Before
    public void setUp() {
        System.out.println(arrayListOfNames);
    }

    @Test
    public void withoutFlatMap() throws Exception {
        List<String> names = Lists.newArrayList();

        for (List<String> listOfNames : arrayListOfNames) {
            for (String name : listOfNames)
                names.add(name);
        }
        names.forEach(System.out::println);
    }

    @Test
    public void withFlatMap() throws Exception {
        List<String> names = arrayListOfNames.stream().flatMap(List::stream).collect(Collectors.toList());
        names.forEach(System.out::println);
    }
}
