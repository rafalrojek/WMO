package sample.model.factor;

import sample.model.Factor;
import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;

public class TimeFactor extends Factor{
    public  TimeFactor(FactorsEnum factor, FactorValues... values) {
        super(factor, values);
    }

    public TimeFactor(FactorsEnum factor, Double weight, FactorValues... values) {
        super(factor, weight, values);
    }
}
