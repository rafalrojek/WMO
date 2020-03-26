package sample.model.category;

import sample.model.Category;
import sample.model.enums.CategoriesEnum;

import static sample.model.enums.FactorValues.*;
import static sample.model.enums.FactorsEnum.*;
import static sample.model.enums.FactorsEnum.QUALITY;
import static sample.model.enums.FactorsEnum.STABILITY;

public class Labrador extends Category {
    public Labrador() {
        nameOfCategory = CategoriesEnum.LABRADOR;
        addFactor(PROJECT_SIZE, MEDIUM)
                .addFactor(TEAM_SIZE, MEDIUM)
                .addFactor(TIME, MEDIUM)
                .addFactor(FIELD_KNOWLEDGE, LITTLE,MEDIUM)
                .addFactor(FORMALIZATION_LEVEL, LITTLE)
                .addFactor(INNOVATION_LEVEL, LITTLE,MEDIUM)
                .addFactor(DEVELOPERS_EXP, LITTLE,MEDIUM,ALOT)
                .addFactor(QUALITY, MEDIUM)
                .addFactor(STABILITY, YES);
    }
}
