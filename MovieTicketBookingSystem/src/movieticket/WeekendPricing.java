package movieticket;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendPricing {

    private double normalPrice = 150.0;
    private double weekendExtraCharge = 50.0;

    // Calculate ticket price based on date
    public double calculatePrice(LocalDate date) {

        DayOfWeek day = date.getDayOfWeek();

        if (day == DayOfWeek.SATURDAY ||
            day == DayOfWeek.SUNDAY) {

            return normalPrice + weekendExtraCharge;

        } else {

            return normalPrice;
        }
    }

    // Check whether the date is weekend
    public boolean isWeekend(LocalDate date) {

        DayOfWeek day = date.getDayOfWeek();

        return day == DayOfWeek.SATURDAY ||
               day == DayOfWeek.SUNDAY;
    }
}