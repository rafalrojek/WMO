package sample.model;
import sample.model.enums.CategoriesEnum;
import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;
import java.util.HashMap;
import java.util.Map;

public abstract class Category {

    protected Map<FactorsEnum, Factor> factors = new HashMap<>();
    protected CategoriesEnum nameOfCategory;

    public Category addFactor(FactorsEnum factorsEnum, Double weight, FactorValues... factorValues){
        Factor factor = Factor.createFactor(factorsEnum,weight,factorValues);
        factors.put(factorsEnum,factor);
        return this;
    }

    public String getCategoryName(){
        return nameOfCategory.toString();
    }

    public Map<FactorsEnum, Factor> getFactors() {
        return factors;
    }
}
