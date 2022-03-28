package main.java;

public class VisitorReduction implements ReductionRate {
    double amountOverBaseAmount = 0;
    double getReduction = 0;

    public VisitorReduction() {

    }

    @Override
    public double kindReduction(double stayAmount) {
        if(stayAmount > 10.00){
            amountOverBaseAmount =  stayAmount - 10.00;
            getReduction = amountOverBaseAmount / 2;
            return getReduction;
        }
        return 0;
    }
}
