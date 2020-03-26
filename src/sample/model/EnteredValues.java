package sample.model;

import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;

import java.util.HashMap;
import java.util.Map;

public class EnteredValues {
    private Map<FactorsEnum, FactorValues> factors = new HashMap<>();

    public EnteredValues addFactor(FactorsEnum factor, FactorValues value){
        factors.put(factor,value);
        return this;
    }

    public Map<FactorsEnum, FactorValues> getFactors(){
        return factors;
    }

}
