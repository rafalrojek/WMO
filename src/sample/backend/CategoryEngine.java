package sample.backend;
import sample.model.Category;
import sample.model.EnteredValues;
import sample.model.category.*;
import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;
import java.util.*;

public class CategoryEngine {
    private List<Category> categories = new LinkedList<>();

    public Category checkCategory(EnteredValues enteredValues){
        List<Result> result = new LinkedList<>();
        setCategories(enteredValues);
        for(Category category : categories){
            double applying = isApplying(enteredValues,category);
            result.add(new Result(applying,category));
        }
        return result.stream()
                .sorted(Comparator.comparing(Result::getApplying).reversed())
                .findFirst()
                .map(Result::getCategory)
                .orElseThrow(IllegalStateException::new);
    }

    private double isApplying(EnteredValues enteredValues, Category category){
        Map<FactorsEnum, FactorValues> enteredFactors = enteredValues.getFactors();
        double result = 0.0;
        for(FactorsEnum factorsEnum: FactorsEnum.values()){
            result += category.getFactors().get(factorsEnum).isApplied(enteredFactors.get(factorsEnum));
        }
        return result;
    }

    public void setCategories(EnteredValues enteredValues) {
        categories.clear();
        FactorValues formalizationLevel = enteredValues.getFactors().get(FactorsEnum.FORMALIZATION_LEVEL);
        categories.add(new Rottweiler());
        if(formalizationLevel.equals(FactorValues.ALOT)) return;
        categories.add(new Buldog());
        categories.add(new Jamnik());
        if(formalizationLevel.equals(FactorValues.MEDIUM)) return;
        categories.add(new York());
        categories.add(new Chihuahua());
        categories.remove(new Rottweiler());
    }

    private static class Result{
        Double applying;
        Category category;

        Double getApplying() {
            return applying;
        }

        Category getCategory() {
            return category;
        }

        Result(Double applying, Category category) {
            this.applying = applying;
            this.category = category;
        }
    }
}
