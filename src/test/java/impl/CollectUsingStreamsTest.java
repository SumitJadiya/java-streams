package impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import beans.Person;
import mockdata.MockData;

public class CollectUsingStreamsTest {

    @Test
    public void understandingCollect() throws Exception {
        List<String> emails = MockData.getPeople().stream().map(Person::getEmail).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        emails.forEach(System.out::println);
    }
}
