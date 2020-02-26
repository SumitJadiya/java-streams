package impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import beans.Person;
import mockdata.MockData;

public class UnderstandingCollectUsingStreamsTest {

    @Test
    public void understandingCollect() throws IOException {
        List<String> emails = MockData.getPeople()
                .parallelStream()
                .map(Person::getEmail)
                .collect(ArrayList::new, ArrayList::add, (list1, list2) -> list1.addAll(list2));
        emails.forEach(System.out::println);
    }
}
