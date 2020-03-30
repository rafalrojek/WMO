package sample.backend;

import sample.model.Category;
import sample.model.EnteredValues;
import sample.model.category.*;

import java.util.*;

public class CategoryEngine {
    private List<Category> categories = new LinkedList<>();

    public CategoryEngine() {
        categories = Arrays.asList(new Buldog(),
                new Chihuahua(),
                new Jamnik(),
                new Labrador(),
                new Mastiff(),
                new Rottweiler());
    }

    public Category checkCategory(EnteredValues enteredValues){
        List<Result> result = new LinkedList<>();
        for(Category category : categories){
            double applying = category.isApplying(enteredValues);
            result.add(new Result(applying,category));
        }
        return result.stream()
                .sorted(Comparator.comparing(Result::getApplying).reversed())
                .findFirst()
                .map(Result::getCategory)
                .orElseThrow(IllegalStateException::new);
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
