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
        addFactor(PROJECT_SIZE, 0.6, MEDIUM,ALOT)
                .addFactor(TEAM_SIZE, 1., MEDIUM,ALOT)
                .addFactor(TIME, 0.6, MEDIUM,ALOT)
                .addFactor(FIELD_KNOWLEDGE, 0.1, LITTLE,MEDIUM,ALOT)
                .addFactor(FORMALIZATION_LEVEL, 1., MEDIUM)
                .addFactor(INNOVATION_LEVEL, 0.8, LITTLE)
                .addFactor(DEVELOPERS_EXP, 0.6, LITTLE,MEDIUM)
                .addFactor(QUALITY, 0.7, MEDIUM)
                .addFactor(STABILITY, 0.9, NO);
    }
}
