package sample.model.category;

import sample.model.Category;
import sample.model.enums.CategoriesEnum;

import static sample.model.enums.FactorsEnum.*;
import static sample.model.enums.FactorValues.*;


public class Buldog extends Category {
    public Buldog() {
        nameOfCategory = CategoriesEnum.BULDOG;
        addFactor(PROJECT_SIZE, 1., MEDIUM)
            .addFactor(TEAM_SIZE, 1., MEDIUM,ALOT)
            .addFactor(TIME, 1., ALOT)
            .addFactor(FIELD_KNOWLEDGE, 1., MEDIUM,ALOT)
            .addFactor(FORMALIZATION_LEVEL, 1., LITTLE,MEDIUM)
            .addFactor(INNOVATION_LEVEL, 1., MEDIUM,ALOT)
            .addFactor(DEVELOPERS_EXP, 1., MEDIUM,ALOT)
            .addFactor(QUALITY, 1., MEDIUM,ALOT)
            .addFactor(STABILITY, 1., YES,NO);
    }
}
