package com.jpmorgan.model.instruction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;

/**
 * Describes an instruction sent by various clients in order to buy or sell
 */
public class Instruction {

    // A financial entity whose shares are to be bought or sold
    private final String entity;

    // What flag should the Instruction represents Buy or Sell
    private final TradeActionFlag flag;

    // Date on which the instruction was sent to JP Morgan by various clients.
    private final LocalDate instructionDate;

    // The date on which the client wished for the instruction to be settled with respect to Instruction Date
    private LocalDate settlementDate;

    private final InstructionDetails details;

    public Instruction(
            String entity,
            TradeActionFlag flag,
            LocalDate instructionDate,
            LocalDate settlementDate,
            InstructionDetails details)
    {
        this.entity = entity;
        this.flag = flag;
        this.instructionDate = instructionDate;
        this.settlementDate = settlementDate;
        this.details = details;
    }

    public String getEntity() {
        return entity;
    }

    public TradeActionFlag getFlag() {
        return flag;
    }

    public LocalDate getInstructionDate() {
        return instructionDate;
    }

    public void setSettlementDate(LocalDate newDate) {
        settlementDate = newDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public InstructionDetails getDetails() {
        return details;
    }

    public Currency getCurrency() {
        return getDetails().getCurrency();
    }

    public BigDecimal getAgreedFx() {
        return getDetails().getAgreedFx();
    }

    public int getUnits() {
        return getDetails().getUnits();
    }

    public BigDecimal getPricePerUnit() {
        return getDetails().getPricePerUnit();
    }

    public BigDecimal getTradeAmount() {
        return getDetails().getTradeAmount()
                .setScale(2, BigDecimal.ROUND_FLOOR);
    }

    @Override
    public String toString() {
        return entity;
    }
}
