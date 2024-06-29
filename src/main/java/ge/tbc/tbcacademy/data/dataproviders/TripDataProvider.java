package ge.tbc.tbcacademy.data.dataproviders;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.util.Random;

public class TripDataProvider {
    Random rand = new Random();
    Faker faker = new Faker();

    @DataProvider
    public Object[][] searchInfoProvider() {
        LocalDate startDate = LocalDate.now();

        return new Object[][]{
                {"Astana", startDate, 9, 2, 2, 3},
                {"Batumi", startDate, 7, 2, 2, 1},
                {"Tbilisi", startDate, 10, 2, 2, 1}
        };
    }

    @DataProvider
    public Object[][] adultsCountProvider() {
        return new Object[][]{
                {rand.nextInt(1, 31)},
                {rand.nextInt(1, 31)},
                {rand.nextInt(1, 31)}
        };
    }

    @DataProvider
    public Object[][] destinationProvider() {
        return new Object[][]{
                {"Batumi"},
                {"Astana"}
        };
    }

    @DataProvider
    public Object[][] datesProvider() {
        return new Object[][]{
                {LocalDate.now().plusWeeks(2), LocalDate.now().plusWeeks(3)},
                {LocalDate.now().plusMonths(5), LocalDate.now().plusMonths(6)}
        };
    }

    @DataProvider
    public Object[][] childCountProvider() {
        return new Object[][]{
                {1, 8},
                {3, 5}
        };
    }
}
