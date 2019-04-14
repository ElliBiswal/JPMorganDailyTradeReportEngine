package com.jpmorgan.controller.businessdays;

import java.time.LocalDate;

public interface IBusinessDays {
    LocalDate findFirstWorkingDate(LocalDate date);
}
