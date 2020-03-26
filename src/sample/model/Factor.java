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

    public Factor(FactorsEnum factor, FactorValues... values){
        this.values = Arrays.asList(values);
        this.factor = factor;
    }

    public boolean isApplied(FactorValues value){
        for(FactorValues v: values){
            if(v.equals(value)) return true;
        }
        return false;
    }

    public static Factor createFactor(FactorsEnum factorsEnum, FactorValues... factorValues){
        if(factorsEnum.equals(DEVELOPERS_EXP)) return new DevelopersExperienceFactor(factorsEnum,factorValues);
        else if(factorsEnum.equals(FIELD_KNOWLEDGE)) return new FieldKnowledgeFactor(factorsEnum,factorValues);
        else if(factorsEnum.equals(FORMALIZATION_LEVEL)) return new FormalizationLevelFactor(factorsEnum,factorValues);
        else if(factorsEnum.equals(INNOVATION_LEVEL)) return new InnovationLevelFactor(factorsEnum,factorValues);
        else if(factorsEnum.equals(PROJECT_SIZE)) return new ProjectSizeFactor(factorsEnum,factorValues);
        else if(factorsEnum.equals(QUALITY)) return new QualityFactor(factorsEnum,factorValues);
        else if(factorsEnum.equals(STABILITY)) return new StabilityFactor(factorsEnum,factorValues);
        else if(factorsEnum.equals(TEAM_SIZE)) return new TeamSizeFactor(factorsEnum,factorValues);
        else return new TimeFactor(factorsEnum,factorValues);
    }
}
