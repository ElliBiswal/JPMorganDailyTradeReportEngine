package com.jpmorgan.controller.reports;

import com.jpmorgan.controller.InstructionSettlementDateCalculator;
import com.jpmorgan.controller.InstructionSettlementCalculator;
import com.jpmorgan.controller.rank.Rank;
import com.jpmorgan.model.instruction.Instruction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


public class ReportGenerator implements IReportGenerator {
    private StringBuilder stringBuilder = new StringBuilder();

    /* (non-Javadoc)
     * @see com.jpmorgan.controller.reports.IReportGenerator#generateInstructionsReport(java.util.Set)
     */
    @Override
    public String generateInstructionsReport(Set<Instruction> instructions) {
        //  settlement dates are calculated here
        InstructionSettlementDateCalculator.calculateSettlementDates(instructions);

        // Build the report string
        return generateDailyOutgoingRanking(instructions,
                generateDailyIncomingRanking(instructions,
                generateDailyIncomingAmount(instructions,
                generateDailyOutgoingAmount(instructions, stringBuilder))))
            .toString();
    }

    private static StringBuilder generateDailyOutgoingAmount(Set<Instruction> instructions, StringBuilder stringBuilder) {
        final Map<LocalDate, BigDecimal> dailyOutgoingAmount =
                InstructionSettlementCalculator.calculateDailyOutgoingAmount(instructions);

        stringBuilder
                .append("\n         Outgoing Daily Amount          \n")
                .append("----------------------------------------\n")
                .append(" Settlement Date    |    Trade Amount   \n")
                .append("------------------     ------------------\n");

        for (LocalDate date : dailyOutgoingAmount.keySet()) {
            stringBuilder
                .append(date).append("          |      ").append(dailyOutgoingAmount.get(date)).append("\n");
        }

        return stringBuilder;
    }

    private static StringBuilder generateDailyIncomingAmount(Set<Instruction> instructions, StringBuilder stringBuilder) {
        final Map<LocalDate, BigDecimal> dailyOutgoingAmount =
                InstructionSettlementCalculator.calculateDailyIncomingAmount(instructions);

        stringBuilder
        		.append("\n")
                .append("         Incoming Daily Amount          \n")
                .append("----------------------------------------\n")
                .append("Settlement Date       |    Trade Amount      \n")
                .append("----------------           ----------------\n");

        for (LocalDate date : dailyOutgoingAmount.keySet()) {
            stringBuilder
                    .append(date).append("            |        ").append(dailyOutgoingAmount.get(date)).append("\n");
        }

        return stringBuilder;
    }

    private static StringBuilder generateDailyOutgoingRanking(Set<Instruction> instructions, StringBuilder stringBuilder) {
        final Map<LocalDate, LinkedList<Rank>> dailyOutgoingRanking =
                InstructionSettlementCalculator.calculateDailyOutgoingRanking(instructions);

        stringBuilder
        		.append("\n")
                .append("         Outgoing Daily Ranking          \n")
                .append("----------------------------------------\n")
                .append("Entity    |     Rank   |   Settlement Date     \n")
                .append("---------      -------    -----------------\n");

        for (LocalDate date : dailyOutgoingRanking.keySet()) {
            for (Rank rank : dailyOutgoingRanking.get(date)) {
                stringBuilder
                	.append(rank.getEntity()).append("       |      ")
                	.append(rank.getRank()).append("     |    ")
                    .append(date).append("\n");

            }
        }

        return stringBuilder;
    }

    private static StringBuilder generateDailyIncomingRanking(Set<Instruction> instructions, StringBuilder stringBuilder) {
        final Map<LocalDate, LinkedList<Rank>> dailyIncomingRanking =
                InstructionSettlementCalculator.calculateDailyIncomingRanking(instructions);

        stringBuilder
        		.append("\n")
                .append("         Incoming Daily Ranking          \n")
                .append("----------------------------------------\n")
                .append("Entity    |     Rank   |   Settlement Date     \n")
                .append("---------     --------    ----------------\n");

        for (LocalDate date : dailyIncomingRanking.keySet()) {
            for (Rank rank : dailyIncomingRanking.get(date)) {
                stringBuilder
                		.append(rank.getEntity()).append("       |    ")
                		.append(rank.getRank()).append("       |    ")
                        .append(date).append("\n");

            }
        }

        return stringBuilder;
    }
}
