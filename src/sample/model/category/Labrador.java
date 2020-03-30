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
        addFactor(PROJECT_SIZE, 1., MEDIUM)
                .addFactor(TEAM_SIZE, 1., MEDIUM)
                .addFactor(TIME, 1., MEDIUM)
                .addFactor(FIELD_KNOWLEDGE, 1., LITTLE,MEDIUM)
                .addFactor(FORMALIZATION_LEVEL, 1., LITTLE)
                .addFactor(INNOVATION_LEVEL, 1., LITTLE,MEDIUM)
                .addFactor(DEVELOPERS_EXP, 1., LITTLE,MEDIUM,ALOT)
                .addFactor(QUALITY, 1., MEDIUM)
                .addFactor(STABILITY, 1., YES);
    }
}
