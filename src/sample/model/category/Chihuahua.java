package sample.model.category;
import sample.model.Category;
import sample.model.enums.CategoriesEnum;
import static sample.model.enums.FactorValues.*;
import static sample.model.enums.FactorsEnum.*;

public class Chihuahua extends Category {

    public Chihuahua() {
        nameOfCategory = CategoriesEnum.CHIHUAHUA;
        addFactor(PROJECT_SIZE, 1., LITTLE)
                .addFactor(TEAM_SIZE, 0.7, LITTLE)
                .addFactor(TIME, 0.7, LITTLE)
                .addFactor(FIELD_KNOWLEDGE, 0.1, LITTLE,MEDIUM,ALOT)
                .addFactor(FORMALIZATION_LEVEL, 0.6, LITTLE)
                .addFactor(INNOVATION_LEVEL, 0.6, LITTLE)
                .addFactor(DEVELOPERS_EXP, 0.1, LITTLE,MEDIUM,ALOT)
                .addFactor(QUALITY, 0.5, LITTLE,MEDIUM)
                .addFactor(STABILITY, 1., YES);
    }
}
