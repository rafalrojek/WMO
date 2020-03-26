package sample.frontend;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.backend.CategoryEngine;
import sample.model.EnteredValues;
import sample.model.enums.FactorValues;

import static sample.model.enums.FactorValues.*;
import static sample.model.enums.FactorsEnum.*;

public class  Controller {
    @FXML public TreeTableView table;
    @FXML public ToggleGroup MoneySize;
    @FXML public ToggleGroup TeamSize;
    @FXML public ToggleGroup TimeSize;
    @FXML public ToggleGroup RequirementStability;
    @FXML public ToggleGroup ProblemKnowledge;
    @FXML public ToggleGroup FormalSize;
    @FXML public ToggleGroup InnovationSize;
    @FXML public ToggleGroup DevelopersSkills;
    @FXML public ToggleGroup QualitySize;
    public Label typeName; //TODO: Tutaj wpisujemy typ projektu
    private TreeItem<String> root = new TreeItem<>("Zadania");

    @FXML
    public void initialize() {
        //Creating a column
        TreeTableColumn<String,String> column = new TreeTableColumn<>("Zadania");

        //Defining cell content
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<String, String> p) ->
                new ReadOnlyStringWrapper(p.getValue().getValue()));
        table.getColumns().add(column);
    }

    public void Calculate() {
        root.getChildren().removeAll();
        EnteredValues enteredValues = new EnteredValues()
                .addFactor(DEVELOPERS_EXP, getValue(DevelopersSkills))
                .addFactor(FIELD_KNOWLEDGE, getValue(ProblemKnowledge))
                .addFactor(FORMALIZATION_LEVEL, getValue(FormalSize))
                .addFactor(INNOVATION_LEVEL,getValue(InnovationSize))
                .addFactor(PROJECT_SIZE, getValue(MoneySize))
                .addFactor(QUALITY, getValue(QualitySize))
                .addFactor(STABILITY, getValue(RequirementStability))
                .addFactor(TEAM_SIZE,getValue(TeamSize))
                .addFactor(TIME, getValue(TimeSize));
        CategoryEngine engine = new CategoryEngine();
        System.out.println(engine.checkCategory(enteredValues).getCategoryName());
        typeName.setText(engine.checkCategory(enteredValues).getCategoryName());
    }

    private FactorValues getValue(ToggleGroup tg) {
        if (tg.getSelectedToggle() != null) {
            RadioButton rb = (RadioButton) tg.getSelectedToggle();
            String name = rb.getText();
            switch (name) {
                case "Małe": return LITTLE;
                case "Średnie": return MEDIUM;
                case "Duże": return ALOT;
                case "Nie": return NO;
                case "Tak": return YES;
            }
        }
        return null;
    }
}
