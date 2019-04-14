package com.jpmorgan.controller.businessdays;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class BusinessDays implements IBusinessDays {
    protected Map<DayOfWeek, Boolean> isWorkingDayMap = new HashMap<>();

    protected abstract void setupWorkingDays();

    public BusinessDays() {
        setupWorkingDays();
    }

    public LocalDate findFirstWorkingDate(LocalDate date) {

        // for code safety, check if there is really an available weekday
        if (isWorkingDayMap.values().stream().noneMatch(b -> b)) {
            return null;
        }

        // if there are available working days, then check for the first working day
        return findFirstWorkingDateRec(date);
    }

    private LocalDate findFirstWorkingDateRec(LocalDate date) {
        final DayOfWeek inputDay = date.getDayOfWeek();

        // in case the given date is working date, just return this
        if (isWorkingDayMap.get(inputDay)) {
            return date;
        } else {
            // otherwise look for the next working date (Recursively)
            return findFirstWorkingDateRec(date.plusDays(1));
        }
    }
}