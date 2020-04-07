package sample.model.category;
import sample.model.Category;
import sample.model.enums.CategoriesEnum;
import static sample.model.enums.FactorValues.*;
import static sample.model.enums.FactorsEnum.*;
import static sample.model.enums.FactorsEnum.QUALITY;
import static sample.model.enums.FactorsEnum.STABILITY;

public class York extends Category {
    public York() {
        nameOfCategory = CategoriesEnum.YORK;
        addFactor(PROJECT_SIZE, 0.7, MEDIUM)
                .addFactor(TEAM_SIZE, 0.7, MEDIUM)
                .addFactor(TIME, 0.7, MEDIUM)
                .addFactor(FIELD_KNOWLEDGE, 0.6, LITTLE,MEDIUM)
                .addFactor(FORMALIZATION_LEVEL, 1., LITTLE)
                .addFactor(INNOVATION_LEVEL, 0.6, LITTLE,MEDIUM)
                .addFactor(DEVELOPERS_EXP, 0.1, LITTLE,MEDIUM,ALOT)
                .addFactor(QUALITY, 1., MEDIUM)
                .addFactor(STABILITY, 1., YES);
    }
}
