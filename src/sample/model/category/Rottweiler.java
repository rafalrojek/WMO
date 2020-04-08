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
        addFactor(PROJECT_SIZE, 0.2, ALOT)
                .addFactor(TEAM_SIZE, 0.2, MEDIUM,ALOT)
                .addFactor(TIME, 0.1, MEDIUM,ALOT)
                .addFactor(FIELD_KNOWLEDGE, 0.1, LITTLE,MEDIUM)
                .addFactor(FORMALIZATION_LEVEL, 0.1, ALOT)
                .addFactor(INNOVATION_LEVEL, 0.1, MEDIUM,ALOT)
                .addFactor(DEVELOPERS_EXP, 0.1, ALOT)
                .addFactor(QUALITY, 0.1, ALOT)
                .addFactor(STABILITY, 0.2, YES);
    }
}
