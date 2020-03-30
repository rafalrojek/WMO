package sample.model;

import sample.model.enums.CategoriesEnum;
import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;

import java.util.HashMap;
import java.util.Map;

public abstract class Category {

    protected Map<FactorsEnum, Factor> factors = new HashMap<>();
    protected CategoriesEnum nameOfCategory;

    public double isApplying(EnteredValues enteredValues){
        Map<FactorsEnum, FactorValues> enteredFactors = enteredValues.getFactors();
        double result = 0.0;
        for(FactorsEnum factorsEnum: FactorsEnum.values()){
            result += factors.get(factorsEnum).isApplied(enteredFactors.get(factorsEnum));
        }
        return result;
    }

    public Category addFactor(FactorsEnum factorsEnum, Double weight, FactorValues... factorValues){
        Factor factor = Factor.createFactor(factorsEnum,weight,factorValues);
        factors.put(factorsEnum,factor);
        return this;
    }

    public String getCategoryName(){
        return nameOfCategory.toString();
    }
}
