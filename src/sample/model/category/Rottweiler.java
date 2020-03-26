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
        addFactor(PROJECT_SIZE, ALOT)
                .addFactor(TEAM_SIZE, MEDIUM,ALOT)
                .addFactor(TIME, MEDIUM,ALOT)
                .addFactor(FIELD_KNOWLEDGE, LITTLE,MEDIUM)
                .addFactor(FORMALIZATION_LEVEL, ALOT)
                .addFactor(INNOVATION_LEVEL, MEDIUM,ALOT)
                .addFactor(DEVELOPERS_EXP, ALOT)
                .addFactor(QUALITY, ALOT)
                .addFactor(STABILITY, YES);
    }
}
