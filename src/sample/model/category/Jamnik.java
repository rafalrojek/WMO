package sample.model.category;

import sample.model.Category;
import sample.model.enums.CategoriesEnum;

import static sample.model.enums.FactorValues.*;
import static sample.model.enums.FactorsEnum.*;
import static sample.model.enums.FactorsEnum.QUALITY;
import static sample.model.enums.FactorsEnum.STABILITY;

public class Jamnik extends Category {
    public Jamnik() {
        nameOfCategory = CategoriesEnum.JAMNIK;
        addFactor(PROJECT_SIZE, MEDIUM,ALOT)
                .addFactor(TEAM_SIZE, MEDIUM,ALOT)
                .addFactor(TIME, MEDIUM,ALOT)
                .addFactor(FIELD_KNOWLEDGE, LITTLE,MEDIUM,ALOT)
                .addFactor(FORMALIZATION_LEVEL, MEDIUM)
                .addFactor(INNOVATION_LEVEL, LITTLE)
                .addFactor(DEVELOPERS_EXP, LITTLE,MEDIUM)
                .addFactor(QUALITY, MEDIUM)
                .addFactor(STABILITY, NO);
    }
}
