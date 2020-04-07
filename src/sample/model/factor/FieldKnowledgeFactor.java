package sample.model.factor;
import sample.model.Factor;
import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;

public class FieldKnowledgeFactor extends Factor {
    public  FieldKnowledgeFactor(FactorsEnum factor, FactorValues... values) {
        super(factor, values);
    }

    public  FieldKnowledgeFactor(FactorsEnum factor, Double weight, FactorValues... values) {
        super(factor, weight, values);
    }

}
