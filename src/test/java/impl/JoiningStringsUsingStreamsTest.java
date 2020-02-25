package impl;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class JoiningStringsUsingStreamsTest {

    private List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    @Test
    public void joiningStringsWithoutStreams() {
        StringBuilder join = new StringBuilder();
        for (String name : names)
            join.append(name).append(", ");

        System.out.println(join.substring(0, join.length() - 2));
    }

    @Test
    public void joiningStringsWithStreams() {
        String join = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));

        System.out.println(join.substring(0, join.length() - 2));
    }
}
