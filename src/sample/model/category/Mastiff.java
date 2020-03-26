package sample.model.category;

import sample.model.Category;
import sample.model.enums.CategoriesEnum;

import static sample.model.enums.FactorValues.*;
import static sample.model.enums.FactorsEnum.*;
import static sample.model.enums.FactorsEnum.QUALITY;
import static sample.model.enums.FactorsEnum.STABILITY;

public class Mastiff extends Category {
    public Mastiff() {
        nameOfCategory = CategoriesEnum.MASTIFF;
        addFactor(PROJECT_SIZE, ALOT)
                .addFactor(TEAM_SIZE, ALOT)
                .addFactor(TIME, ALOT)
                .addFactor(FIELD_KNOWLEDGE, LITTLE,MEDIUM,ALOT)
                .addFactor(FORMALIZATION_LEVEL, MEDIUM)
                .addFactor(INNOVATION_LEVEL, LITTLE,MEDIUM)
                .addFactor(DEVELOPERS_EXP, LITTLE,MEDIUM,ALOT)
                .addFactor(QUALITY, MEDIUM)
                .addFactor(STABILITY, YES,NO);
    }
}
