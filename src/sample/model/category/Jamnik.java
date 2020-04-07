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
        addFactor(PROJECT_SIZE, 1., MEDIUM,ALOT)
                .addFactor(TEAM_SIZE, 1., MEDIUM,ALOT)
                .addFactor(TIME, 1., MEDIUM,ALOT)
                .addFactor(FIELD_KNOWLEDGE, 1., LITTLE,MEDIUM,ALOT)
                .addFactor(FORMALIZATION_LEVEL, 1., MEDIUM)
                .addFactor(INNOVATION_LEVEL, 1., LITTLE)
                .addFactor(DEVELOPERS_EXP, 1., LITTLE,MEDIUM)
                .addFactor(QUALITY, 1., MEDIUM)
                .addFactor(STABILITY, 1., NO);
    }
}
