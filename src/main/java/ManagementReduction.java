package main.java;

public class ManagementReduction implements ReductionRate {

    public ManagementReduction() {

    }

    @Override
    public double kindReduction(double stayAmount) {
        if(stayAmount >= 1 && stayAmount <= 3){
            return 4;
        }
        return stayAmount;
    }
}
