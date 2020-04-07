package sample.model.category;
import sample.model.Category;
import sample.model.enums.CategoriesEnum;
import static sample.model.enums.FactorsEnum.*;
import static sample.model.enums.FactorValues.*;


public class Buldog extends Category {
    public Buldog() {
        nameOfCategory = CategoriesEnum.BULDOG;
        addFactor(PROJECT_SIZE, 0.8, MEDIUM)
            .addFactor(TEAM_SIZE, 0.7, MEDIUM,ALOT)
            .addFactor(TIME, 0.8, ALOT)
            .addFactor(FIELD_KNOWLEDGE, 0.7, MEDIUM,ALOT)
            .addFactor(FORMALIZATION_LEVEL, 0.6, LITTLE,MEDIUM)
            .addFactor(INNOVATION_LEVEL, 0.76, MEDIUM,ALOT)
            .addFactor(DEVELOPERS_EXP, 0.4, MEDIUM,ALOT)
            .addFactor(QUALITY, 0.6, MEDIUM,ALOT)
            .addFactor(STABILITY, 0.8, YES,NO);
    }
}
