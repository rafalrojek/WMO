package sample.model.category;
import sample.model.Category;
import sample.model.enums.CategoriesEnum;
import static sample.model.enums.FactorsEnum.*;
import static sample.model.enums.FactorValues.*;


public class Buldog extends Category {
    public Buldog() {
        nameOfCategory = CategoriesEnum.BULDOG;
        addFactor(PROJECT_SIZE, 0.1, MEDIUM)
            .addFactor(TEAM_SIZE, 0.1, MEDIUM,ALOT)
            .addFactor(TIME, 0.1, ALOT)
            .addFactor(FIELD_KNOWLEDGE, 0.1, MEDIUM,ALOT)
            .addFactor(FORMALIZATION_LEVEL, 0.1, LITTLE,MEDIUM)
            .addFactor(INNOVATION_LEVEL, 0.1, MEDIUM,ALOT)
            .addFactor(DEVELOPERS_EXP, 0.2, MEDIUM,ALOT)
            .addFactor(QUALITY, 0.2, MEDIUM,ALOT)
            .addFactor(STABILITY, 0.1, YES,NO);
    }
}
