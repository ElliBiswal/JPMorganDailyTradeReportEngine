package com.jpmorgan.controller.reports;

import com.jpmorgan.model.instruction.Instruction;

import java.util.Set;

public interface IReportGenerator {
    String generateInstructionsReport(Set<Instruction> instructions);
}
