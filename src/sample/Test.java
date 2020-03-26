package sample;

import sample.backend.CategoryEngine;
import sample.model.EnteredValues;

import static sample.model.enums.FactorValues.*;
import static sample.model.enums.FactorsEnum.*;

public class Test {
    public static void main(String[] args) {
        EnteredValues enteredValues = new EnteredValues()
                .addFactor(DEVELOPERS_EXP, ALOT)
                .addFactor(FIELD_KNOWLEDGE, MEDIUM)
                .addFactor(FORMALIZATION_LEVEL, LITTLE)
                .addFactor(INNOVATION_LEVEL,LITTLE)
                .addFactor(PROJECT_SIZE, MEDIUM)
                .addFactor(QUALITY, LITTLE)
                .addFactor(STABILITY, YES)
                .addFactor(TEAM_SIZE,MEDIUM)
                .addFactor(TIME, NO);
        CategoryEngine engine = new CategoryEngine();
        System.out.println(engine.checkCategory(enteredValues).getCategoryName());
    }
}
