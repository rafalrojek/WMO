package sample.model;

import sample.model.enums.CategoriesEnum;
import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;

import java.util.Map;

public abstract class Category {

    protected Map<FactorsEnum, Factor> factors;
    protected CategoriesEnum nameOfCategory;

    public boolean isApplying(EnteredValues enteredValues){
        Map<FactorsEnum, FactorValues> enteredFactors = enteredValues.getFactors();
        boolean isApplied = true;
        for(FactorsEnum factorsEnum: FactorsEnum.values()){
            if(!factors.get(factorsEnum).isApplied(enteredFactors.get(factorsEnum))) isApplied = false;
        }
        return isApplied;
    }

    public Category addFactor(FactorsEnum factorsEnum, FactorValues... factorValues){
        Factor factor = Factor.createFactor(factorsEnum,factorValues);
        factors.put(factorsEnum,factor);
        return this;
    }
}
