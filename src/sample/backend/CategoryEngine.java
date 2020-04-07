package sample.backend;
import sample.model.Category;
import sample.model.EnteredValues;
import sample.model.category.*;
import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;
import java.util.*;

public class CategoryEngine {
    private List<Category> categories;

    public CategoryEngine() {
        categories = Arrays.asList(new Buldog(),
                new Chihuahua(),
                new Jamnik(),
                new York(),
                new Rottweiler());
    }

    public Category checkCategory(EnteredValues enteredValues){
        List<Result> result = new LinkedList<>();
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
