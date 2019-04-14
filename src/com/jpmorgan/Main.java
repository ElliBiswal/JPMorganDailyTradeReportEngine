package com.jpmorgan;

import com.jpmorgan.controller.reports.*;
import com.jpmorgan.model.instruction.Instruction;
import com.jpmorgan.utils.TradeReportGenerator;

import java.util.Set;

public class Main {

	public static void main(String[] args) {
		final Set<Instruction> instructions = TradeReportGenerator
				.getInstructions();
		final IReportGenerator report = new ReportGenerator();

		System.out.println(report
				.generateInstructionsReport(instructions));
	}
}
