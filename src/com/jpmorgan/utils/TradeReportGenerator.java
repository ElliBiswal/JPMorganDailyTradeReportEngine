package com.jpmorgan.utils;

import com.jpmorgan.model.instruction.Instruction;
import com.jpmorgan.model.instruction.TradeActionFlag;
import com.jpmorgan.model.instruction.InstructionDetails;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;


public class TradeReportGenerator {
    public static Set<Instruction> getInstructions() {
        return new HashSet<>(Arrays.asList(

            new Instruction(
                "FE1",
                TradeActionFlag.BUY,
                LocalDate.of(2019, 4, 8),
                LocalDate.of(2019, 4, 9),
                new InstructionDetails(
                        Currency.getInstance("SGD"),
                        BigDecimal.valueOf(0.50),
                        200,
                        BigDecimal.valueOf(100.25))),
                        
            new Instruction(
                "FE2",
                TradeActionFlag.SELL,
                LocalDate.of(2019, 4, 8),
                LocalDate.of(2019, 4, 8),
                new InstructionDetails(
                        Currency.getInstance("AED"),
                        BigDecimal.valueOf(0.22),
                        450,
                        BigDecimal.valueOf(150.5))),
                       
            new Instruction(
                "FE3",
                TradeActionFlag.SELL,
                LocalDate.of(2019, 4, 8),
                LocalDate.of(2019, 4, 9),
                new InstructionDetails(
                        Currency.getInstance("SAR"),
                        BigDecimal.valueOf(0.34),
                        300,
                        BigDecimal.valueOf(120.4))),
            
			 new Instruction(
			     "FE4",
			     TradeActionFlag.BUY,
			     LocalDate.of(2019, 4, 8),
			     LocalDate.of(2019, 4, 9),
			     new InstructionDetails(
			             Currency.getInstance("EUR"),
			             BigDecimal.valueOf(0.70),
			             400,
			             BigDecimal.valueOf(150))),
			           
	                       
			 new Instruction(
			     "FE5",
			     TradeActionFlag.BUY,
			     LocalDate.of(2019, 4, 10),
			     LocalDate.of(2019, 4, 11),
			     new InstructionDetails(
			             Currency.getInstance("EUR"),
			             BigDecimal.valueOf(0.70),
			             500,
			             BigDecimal.valueOf(180.5)))
        ));
    }
}
