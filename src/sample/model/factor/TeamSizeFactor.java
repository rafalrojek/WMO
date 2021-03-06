package sample.model.factor;
import sample.model.Factor;
import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;

public class TeamSizeFactor extends Factor {
    public  TeamSizeFactor(FactorsEnum factor, FactorValues... values) {
        super(factor, values);
    }

    public TeamSizeFactor(FactorsEnum factor, Double weight, FactorValues... values) {
        super(factor, weight, values);
    }
}
