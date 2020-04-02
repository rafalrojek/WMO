package sample.frontend;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.backend.CategoryEngine;
import sample.backend.InMemoryDatabase;
import sample.model.Category;
import sample.model.EnteredValues;
import sample.model.enums.CategoriesEnum;
import sample.model.enums.FactorValues;

import java.util.List;

import static sample.model.enums.FactorValues.*;
import static sample.model.enums.FactorsEnum.*;

public class  Controller {
    @FXML public ToggleGroup MoneySize;
    @FXML public ToggleGroup TeamSize;
    @FXML public ToggleGroup TimeSize;
    @FXML public ToggleGroup RequirementStability;
    @FXML public ToggleGroup ProblemKnowledge;
    @FXML public ToggleGroup FormalSize;
    @FXML public ToggleGroup InnovationSize;
    @FXML public ToggleGroup DevelopersSkills;
    @FXML public ToggleGroup QualitySize;
    @FXML public Label typeName;
    @FXML public ChoiceBox column;
    @FXML public ChoiceBox row;
    @FXML public TableView table;
    private InMemoryDatabase database = new InMemoryDatabase();
    private Category result;
    private boolean started = false;

    @FXML
    public void initialize() {
        column.setDisable(true);
        row.setDisable(true);
        column.getItems().addAll("Wszystkie produkty", "Według aktywności", "Według roli", "Według produktu");
        column.getSelectionModel().select(0);
        started = true;
    }

    public void Calculate() {
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
        if (enteredValues.isAllFine()) {
            CategoryEngine engine = new CategoryEngine();
            result = engine.checkCategory(enteredValues);
            typeName.setText(result.getCategoryName());
            column.setDisable(false);
            column.getSelectionModel().select(0);
            columnSelected();
        }
        else if (started) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Nie wypełniono wszystkich wartości");
            alert.setContentText("Proszę o zaznaczenie wszystkich pól prze włączeniem wyznaczania");
            alert.showAndWait();
        }
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

    public void columnSelected() {
        if (!started) return;
        if (column.getSelectionModel().isSelected(0)){
            List list = database.getByCategory(CategoriesEnum.valueOf(result.getCategoryName().toUpperCase()));
            table.getItems().clear();
            table.getItems().addAll(list);
            row.getItems().clear();
            row.setDisable(true);
        }
        else if (column.getSelectionModel().isSelected(1)){
            row.getItems().clear();
            row.getItems().addAll(database.getAllActivities());
            row.setDisable(false);
        }
        else if (column.getSelectionModel().isSelected(2)) {
            row.getItems().clear();
            row.getItems().addAll(database.getAllRoles());
            row.setDisable(false);
        }
        else if (column.getSelectionModel().isSelected(3)) {
            row.getItems().clear();
            row.getItems().addAll(database.getAllProducts());
            row.setDisable(false);
        }
    }

    public void rowSelected() {
        if (row.getValue() == null || row.getValue().toString().isEmpty()) return;
        else table.getItems().clear();

        if (column.getSelectionModel().isSelected(1))
            table.getItems().addAll(database.getByActivity(row.getValue().toString()));
        else if (column.getSelectionModel().isSelected(2))
            table.getItems().addAll(database.getByRole(row.getValue().toString()));
        else if (column.getSelectionModel().isSelected(3))
            table.getItems().addAll(database.getByProduct(row.getValue().toString()));
    }
}
