package impl;

import java.io.IOException;
import java.util.stream.Collectors;

import org.junit.Test;

import beans.Car;
import mockdata.MockData;

public class TerminalOperationsUsingStreamsTest {

    /**
     * Terminal Operations using Streams
     *
     * @throws IOException while fetching data
     */
    @Test
    public void intermediateAndTerminalOperations() throws IOException {
        System.out.println(
                MockData.getCars()
                        .parallelStream()
                        .filter(car -> car.getPrice() < 10000)
                        .map(Car::getPrice)
                        .map(price -> price + (price * 0.14))
                        .collect(Collectors.toList())
        );
    }
}
