package main.java;

public class StaffReduction implements ReductionRate {
    public StaffReduction(){

    }
    @Override
    public double kindReduction(double stayAmount) {
        if(stayAmount > 16){
            return 16;
        }

        return stayAmount;
    }
}

