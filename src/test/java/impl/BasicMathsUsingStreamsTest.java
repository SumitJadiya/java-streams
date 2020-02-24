package impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import beans.Car;
import mockdata.MockData;

public class BasicMathsUsingStreamsTest {

    /**
     * Count Number of peoples
     *
     * @throws IOException while fetching data
     */
    @Test
    public void count() throws IOException {
        long count = MockData.getPeople().stream().count();
        Assert.assertEquals(count, 1000);
    }

    /**
     * min price of yellow color cars
     *
     * @throws IOException while fetching data
     */
    @Test
    public void min() throws IOException {
        double min = MockData.getCars().stream().filter(car -> car.getColor().equalsIgnoreCase("Yellow")).mapToDouble(Car::getPrice).min().orElse(0);
        Assert.assertEquals(min, 6600.59, 0.01);
    }

    /**
     * Max price of yellow color cars
     *
     * @throws IOException while fetching data
     */
    @Test
    public void max() throws IOException {
        double max = MockData.getCars().stream().filter(car -> car.getColor().equalsIgnoreCase("yellow")).mapToDouble(Car::getPrice).max().orElse(0);
        Assert.assertEquals(max, 99677.14, 0.01);
    }

    /**
     * Average Price
     *
     * @throws IOException while fetching data
     */
    @Test
    public void average() throws IOException {
        double average = MockData.getCars().stream().mapToDouble(Car::getPrice).average().orElse(0);
        Assert.assertEquals(average, 52693.19979, 0.00001);
    }

    /**
     * Total Sum
     *
     * @throws IOException while fetching data
     */
    @Test
    public void sum() throws IOException {
        double aDouble = MockData.getCars().stream().mapToDouble(Car::getPrice).sum();
        BigDecimal bigDecimal = BigDecimal.valueOf(aDouble);

        System.out.println(aDouble + " " + bigDecimal);
    }

    /**
     * Summary Statistics
     *
     * @throws Exception while fetching data
     */
    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();
        System.out.println(statistics);
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());
    }
}
