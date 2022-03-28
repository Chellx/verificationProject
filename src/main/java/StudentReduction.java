package main.java;

public class StudentReduction implements ReductionRate {
    double amountOverBaseAmount = 0;
    double getReduction = 0;
    double totalToPay = 0;
    public StudentReduction() {

    }
    @Override
    public double kindReduction(double stayAmount) {
        if(stayAmount > 5.50){
            amountOverBaseAmount = stayAmount - 5.50;
            getReduction = amountOverBaseAmount / 4;
            totalToPay = 5.50 + getReduction;
            return totalToPay;
        }
        return stayAmount;
    }
}
