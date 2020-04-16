package sample.model.factor;
import sample.model.Factor;
import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;

public class DevelopersExperienceFactor extends Factor {
    public DevelopersExperienceFactor(FactorsEnum factor, FactorValues... values) {
        super(factor, values);
    }

    public DevelopersExperienceFactor(FactorsEnum factor, Double weight, FactorValues... values) {
        super(factor, weight, values);
    }

}
