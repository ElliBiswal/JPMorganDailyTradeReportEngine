# JPMorganDailyTradeReportEngine
 

#Daily Trade Reporting Engine 

  
It’s a daily trade reporting engine for incoming instructions sent by various clients to **JP Morgan** to execute in the international market.   

The instructions sent as input gives the resulted output as a **report printed in console**.   

  
##Instruction 

The  **instruction**  is a model which describes the instructions sent by various clients . 

It includes information such as: 

*Entity*: A financial entity whose shares are to be bought or sold  

*Trade Action*: Buy (Outgoing) or Sell (Incoming)  

*Agreed FX*: The foreign exchange rate with respect to USD that was agreed  

*Currency*: The currency in which instruction is traded 

*Instruction Date*: Date on which the instruction was sent to JP Morgan by various clients 

*Settlement Date*: The date on which the client wished for the instruction to be settled with respect to Instruction Date 

*USD Amount*: Price per unit * Units * Agreed Fx  

  

##The Business days 

A work week starts Monday and ends Friday, unless the currency of the trade is **AED** or **SAR**, where the work week starts Sunday and ends Thursday. No other holidays to be taken into account. Depending on the currency of each instruction the settlement date is calculated. 

This is represented in this code by the Strategy pattern described in the **BusinessDays** abstract class. 

  
The **InstructionSettlementDateCalculator** static class uses the proper strategy based on the given currency of an instruction. 

The **InstructionSettlementCalculator** class is responsible of generating statistics based on a set of given instructions. 

The **Rank** class represents the ranking, entity and date of a record. 

The **ReportGenerator** class is responsible of generating reports.

  
##Demo 

**TradeReportGenerator**  class that contains a set of sample instructions and  **ReportGenerator** class is responsible for generating the report. 
Run **Main.java** and observe the output in console.

##Sample Data  
  
  Entity | Buy/Sell | Agreed Fx|Currency |Instruction Date |Settlement Date |Units |Price per unit
--- | --- | ---| ---| ---| ---| ---| ---
FE1 | B | 0.50 |SGP |8th Apr 2019|9th Apr 2019|200 |100.25|
FE2 | S | 0.22 |AED |7th Apr 2019|8th Apr 2019| 450|150.5|
FE3 | S | 0.34 |SAR |8th Apr 2019|9th Apr 2019|300 |120.4|
FE4 | B | 0.70 |EUR |8th Apr 2019|9th Apr 2019| 400|150|
FE5 | B | 0.70 |EUR |10th Apr 2019|11th Apr 2019| 500|180.5|

