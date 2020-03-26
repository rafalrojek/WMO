package sample.model.category;

import sample.model.Category;
import sample.model.enums.CategoriesEnum;

import static sample.model.enums.FactorsEnum.*;
import static sample.model.enums.FactorValues.*;


public class Buldog extends Category {
    public Buldog() {
        nameOfCategory = CategoriesEnum.BULDOG;
        addFactor(PROJECT_SIZE, MEDIUM)
            .addFactor(TEAM_SIZE, MEDIUM,ALOT)
            .addFactor(TIME, ALOT)
            .addFactor(FIELD_KNOWLEDGE, MEDIUM,ALOT)
            .addFactor(FORMALIZATION_LEVEL, LITTLE,MEDIUM)
            .addFactor(INNOVATION_LEVEL, MEDIUM,ALOT)
            .addFactor(DEVELOPERS_EXP, MEDIUM,ALOT)
            .addFactor(QUALITY, MEDIUM,ALOT)
            .addFactor(STABILITY, YES,NO);
    }
}
