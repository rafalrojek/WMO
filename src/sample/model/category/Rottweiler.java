package sample.model.category;

import sample.model.Category;
import sample.model.enums.CategoriesEnum;

import static sample.model.enums.FactorValues.*;
import static sample.model.enums.FactorsEnum.*;
import static sample.model.enums.FactorsEnum.QUALITY;
import static sample.model.enums.FactorsEnum.STABILITY;

public class Rottweiler extends Category {
    public Rottweiler() {
        nameOfCategory = CategoriesEnum.ROTTWEILER;
        addFactor(PROJECT_SIZE, 1., ALOT)
                .addFactor(TEAM_SIZE, 1., MEDIUM,ALOT)
                .addFactor(TIME, 1., MEDIUM,ALOT)
                .addFactor(FIELD_KNOWLEDGE, 1., LITTLE,MEDIUM)
                .addFactor(FORMALIZATION_LEVEL, 1., ALOT)
                .addFactor(INNOVATION_LEVEL, 1., MEDIUM,ALOT)
                .addFactor(DEVELOPERS_EXP, 1., ALOT)
                .addFactor(QUALITY, 1., ALOT)
                .addFactor(STABILITY, 1., YES);
    }
}
