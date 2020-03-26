package sample.model.category;

import sample.model.Category;
import sample.model.enums.CategoriesEnum;

import static sample.model.enums.FactorValues.*;
import static sample.model.enums.FactorsEnum.*;

public class Chihuahua extends Category {

    public Chihuahua() {
        nameOfCategory = CategoriesEnum.CHIHUAHUA;
        addFactor(PROJECT_SIZE, LITTLE)
                .addFactor(TEAM_SIZE, LITTLE)
                .addFactor(TIME, LITTLE)
                .addFactor(FIELD_KNOWLEDGE, LITTLE,MEDIUM,ALOT)
                .addFactor(FORMALIZATION_LEVEL, LITTLE)
                .addFactor(INNOVATION_LEVEL, LITTLE)
                .addFactor(DEVELOPERS_EXP, LITTLE,MEDIUM,ALOT)
                .addFactor(QUALITY, LITTLE,MEDIUM)
                .addFactor(STABILITY, YES);
    }
}
