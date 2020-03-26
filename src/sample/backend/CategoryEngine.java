package sample.backend;

import sample.model.Category;
import sample.model.EnteredValues;
import sample.model.category.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CategoryEngine {
    List<Category> categories = new LinkedList<>();

    public CategoryEngine() {
        categories = Arrays.asList(new Buldog(),
                new Chihuahua(),
                new Jamnik(),
                new Labrador(),
                new Mastiff(),
                new Rottweiler());
    }

    public Category checkCategory(EnteredValues enteredValues){
        for(Category category : categories){
            if(category.isApplying(enteredValues)) return category;
        }
        return new Doggo();
    }
}
