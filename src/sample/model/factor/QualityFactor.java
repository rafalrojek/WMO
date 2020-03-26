package sample.model.factor;

import sample.model.Factor;
import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;

public class QualityFactor extends Factor {
    public  QualityFactor(FactorsEnum factor, FactorValues... values) {
        super(factor, values);
    }
}