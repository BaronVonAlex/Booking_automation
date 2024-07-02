package ge.tbc.tbcacademy.booking;

import ge.tbc.tbcacademy.data.constants.FilterConstants;
import org.testng.annotations.Factory;

public class FiltersFactory {
    @Factory
    public Object[] linkProvider() {
        return new Object[]{
                new FilterAndSortTests(FilterConstants.NAV_URL, FilterConstants.TRIP_DAYS),
                new FilterAndSortTests(FilterConstants.NAV_URL_NEWYOK, FilterConstants.NEW_YORK_DAYS),
                new FilterAndSortTests(FilterConstants.NAV_URL_NEWYOK2, FilterConstants.NEW_YORK_DAYS2)
        };
    }
}
