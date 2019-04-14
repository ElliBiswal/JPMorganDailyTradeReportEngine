package com.jpmorgan.controller;

import com.jpmorgan.controller.businessdays.ArabicBusinessDays;
import com.jpmorgan.controller.businessdays.DefaultBusinessDays;
import com.jpmorgan.controller.businessdays.IBusinessDays;
import com.jpmorgan.model.instruction.Instruction;

import java.time.LocalDate;
import java.util.Currency;
import java.util.Set;

/**
 * A settlement date calculator
 */
public class InstructionSettlementDateCalculator {

    /**
     * Helper function to calculate settlement date for every given instruction
     * @param instructions the instructions of which the settlement date will be calculated
     */
    public static void calculateSettlementDates(Set<Instruction> instructions) {
        instructions.forEach(InstructionSettlementDateCalculator::calculateSettlementDate);
    }

    /**
     * Calculate the settlementDate Based on given logic
     * @param instruction the instruction from which the settlement date will be calculated
     */
	public static void calculateSettlementDate(Instruction instruction) {
        // Select proper strategy based on the Currency
        final IBusinessDays workingDaysMechanism = getBusinessDays(instruction.getCurrency());

        // find the correct settlement date
        final LocalDate newSettlementDate =
                workingDaysMechanism.findFirstWorkingDate(instruction.getSettlementDate());

        if (newSettlementDate != null) {
            // set the correct settlement date
            instruction.setSettlementDate(newSettlementDate);
        }
    }

    /**
     * Select proper strategy based on the Currency
     * @param currency 
     * @return business days
     */
	private static IBusinessDays getBusinessDays(Currency currency) {
		if ((currency.getCurrencyCode().equals("AED"))
				|| (currency.getCurrencyCode().equals("SAR"))) {
			return ArabicBusinessDays.getInstance();
		}
		return DefaultBusinessDays.getInstance();
	}
}
