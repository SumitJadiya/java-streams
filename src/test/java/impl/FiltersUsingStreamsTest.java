package impl;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;

public class FiltersUsingStreamsTest {

    @Test
    public void understandingFilters() throws IOException {
        ImmutableList<Car> cars = MockData.getCars();
        final Predicate<Car> carPredicate = car -> car.getPrice() < 20000;

        List<Car> carsFiltered = cars.stream().filter(carPredicate).collect(Collectors.toList());
        Assert.assertEquals(carsFiltered.size(), 156);
    }

    @Test
    public void ourFirstMapping() throws IOException {
        List<Person> personList = MockData.getPeople();
        List<PersonDTO> dtos = personList.stream().map(PersonDTO::map).collect(Collectors.toList());

        dtos.forEach(System.out::println);
        Assert.assertEquals(dtos.size(), 1000);
    }

    @Test
    public void averageCarPrice() throws IOException {
        double average = MockData.getCars().stream().mapToDouble(Car::getPrice).average().orElse(0);

        System.out.println(average);
        Assert.assertEquals(average, 52693.19979, 0.001);
    }

    @Test
    public void test() throws Exception {
        MockData.getCars().forEach(System.out::println);
    }
}
