package com.jpmorgan.controller.businessdays;

import java.time.DayOfWeek;

public class DefaultBusinessDays extends BusinessDays {

    private static DefaultBusinessDays instance = null;

    public static DefaultBusinessDays getInstance() {
        if (instance == null) {
            instance = new DefaultBusinessDays();
        }
        return instance;
    }

    private DefaultBusinessDays() {
        super();
    }

    @Override
    protected void setupWorkingDays() {
        this.isWorkingDayMap.put(DayOfWeek.MONDAY, true);
        this.isWorkingDayMap.put(DayOfWeek.TUESDAY, true);
        this.isWorkingDayMap.put(DayOfWeek.WEDNESDAY, true);
        this.isWorkingDayMap.put(DayOfWeek.THURSDAY, true);
        this.isWorkingDayMap.put(DayOfWeek.FRIDAY, true);
        this.isWorkingDayMap.put(DayOfWeek.SATURDAY, false);
        this.isWorkingDayMap.put(DayOfWeek.SUNDAY, false);
    }
}
