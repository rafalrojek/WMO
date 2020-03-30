package sample.model;

import sample.model.enums.FactorValues;
import sample.model.enums.FactorsEnum;
import sample.model.factor.*;

import java.util.Arrays;
import java.util.List;

import static sample.model.enums.FactorsEnum.*;

public abstract class Factor {
    protected FactorsEnum factor;
    protected List<FactorValues> values;
    protected Double weight;

    public Factor(FactorsEnum factor, FactorValues... values){
        this.values = Arrays.asList(values);
        this.factor = factor;
    }

    public Factor(FactorsEnum factor, Double weight, FactorValues... values){
        this.values = Arrays.asList(values);
        this.factor = factor;
        this.weight = weight;
    }


    public double isApplied(FactorValues value){
        if(values.contains(value)) return 1.0 * weight;
        if(value.equals(FactorValues.YES)) return 0.5 * weight;
        if(values.contains(FactorValues.MEDIUM)) return 0.65 * weight;
        else return 0.35 * weight;
    }

    public static Factor createFactor(FactorsEnum factorsEnum, Double weight, FactorValues... factorValues){
        if(factorsEnum.equals(DEVELOPERS_EXP)) return new DevelopersExperienceFactor(factorsEnum, weight,factorValues);
        else if(factorsEnum.equals(FIELD_KNOWLEDGE)) return new FieldKnowledgeFactor(factorsEnum, weight,factorValues);
        else if(factorsEnum.equals(FORMALIZATION_LEVEL)) return new FormalizationLevelFactor(factorsEnum, weight,factorValues);
        else if(factorsEnum.equals(INNOVATION_LEVEL)) return new InnovationLevelFactor(factorsEnum, weight,factorValues);
        else if(factorsEnum.equals(PROJECT_SIZE)) return new ProjectSizeFactor(factorsEnum, weight,factorValues);
        else if(factorsEnum.equals(QUALITY)) return new QualityFactor(factorsEnum, weight,factorValues);
        else if(factorsEnum.equals(STABILITY)) return new StabilityFactor(factorsEnum, weight,factorValues);
        else if(factorsEnum.equals(TEAM_SIZE)) return new TeamSizeFactor(factorsEnum, weight,factorValues);
        else return new TimeFactor(factorsEnum, weight,factorValues);
    }
}
