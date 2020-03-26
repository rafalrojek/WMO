package sample.model.factor;

import sample.model.Factor;
import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;

public class FormalizationLevelFactor extends Factor {
    public  FormalizationLevelFactor(FactorsEnum factor, FactorValues... values) {
        super(factor, values);
    }
}
