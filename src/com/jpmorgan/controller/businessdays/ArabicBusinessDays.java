package com.jpmorgan.controller.businessdays;

import java.time.DayOfWeek;

public class ArabicBusinessDays extends BusinessDays {

    private static ArabicBusinessDays instance = null;

    public static ArabicBusinessDays getInstance() {
        if (instance == null) {
            instance = new ArabicBusinessDays();
        }
        return instance;
    }

    private ArabicBusinessDays() {
        super();
    }

    @Override
    protected void setupWorkingDays() {
        this.isWorkingDayMap.put(DayOfWeek.SUNDAY, true);
        this.isWorkingDayMap.put(DayOfWeek.MONDAY, true);
        this.isWorkingDayMap.put(DayOfWeek.TUESDAY, true);
        this.isWorkingDayMap.put(DayOfWeek.WEDNESDAY, true);
        this.isWorkingDayMap.put(DayOfWeek.THURSDAY, true);
        this.isWorkingDayMap.put(DayOfWeek.FRIDAY, false); 
        this.isWorkingDayMap.put(DayOfWeek.SATURDAY, false); 
    }
}
