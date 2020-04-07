package sample.model;
import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class EnteredValues {
    private HashMap<FactorsEnum, FactorValues> factors = new HashMap<>();

    public EnteredValues addFactor(FactorsEnum factor, FactorValues value){
        factors.put(factor,value);
        return this;
    }

    public Map<FactorsEnum, FactorValues> getFactors(){
        return factors;
    }

    public boolean isAllFine() {
        if (factors.size() != 9) return false;
        AtomicBoolean isFalse = new AtomicBoolean(true);
        factors.forEach((key, value) -> {
            if (value == null) isFalse.set(false);
        });
        return isFalse.get();
    }
}
