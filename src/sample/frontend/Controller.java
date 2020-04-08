package sample.frontend;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import sample.backend.CategoryEngine;
import sample.backend.FxTreeCreator;
import sample.backend.InMemoryDatabase;
import sample.model.Category;
import sample.model.CsvRow;
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
    @FXML public TreeTableView table;
    public Button extendButton;
    private InMemoryDatabase database;
    private Category result;
    private boolean started = false;
    private FxTreeCreator fxTreeCreator;

    @FXML
    public void initialize() {
        database = new InMemoryDatabase();
        fxTreeCreator = new FxTreeCreator(database);
        column.setDisable(true);
        row.setDisable(true);
        column.getItems().addAll("Wszystkie produkty", "Według aktywności", "Według roli", "Według produktu");
        column.getSelectionModel().select(0);
        started = true;

        TreeTableColumn<CsvRow, String> activity = new TreeTableColumn<>("Aktywność");
        activity.setCellValueFactory(new TreeItemPropertyValueFactory<>("activity"));
        TreeTableColumn<CsvRow, String> task = new TreeTableColumn<>("Zadanie");
        task.setCellValueFactory(new TreeItemPropertyValueFactory<>("task"));
        TreeTableColumn<CsvRow, String> product = new TreeTableColumn<>("Produkt");
        product.setCellValueFactory(new TreeItemPropertyValueFactory<>("product"));
        TreeTableColumn<CsvRow, String> role = new TreeTableColumn<>("Rola");
        role.setCellValueFactory(new TreeItemPropertyValueFactory<>("role"));

        table.getColumns().addAll(activity, task, product, role);
        table.setShowRoot(false);
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
            extendButton.setDisable(false);
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
            List<CsvRow> list = database.getByCategory(CategoriesEnum.valueOf(result.getCategoryName().toUpperCase()));
            table.setRoot(fxTreeCreator.createTree(list));
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
        else if (column.getSelectionModel().isSelected(1))
            table.setRoot(fxTreeCreator.createTree(database.getByActivity(row.getValue().toString())));
        else if (column.getSelectionModel().isSelected(2))
            table.setRoot(fxTreeCreator.createTree(database.getByRole(row.getValue().toString())));
        else if (column.getSelectionModel().isSelected(3))
            table.setRoot(fxTreeCreator.createTree(database.getByProduct(row.getValue().toString())));
    }

    public void Extend() {
        TreeItem<CsvRow> treeItem = table.getRoot();
        extend(treeItem);
    }

    private void extend (TreeItem<CsvRow> treeItem) {
        for (TreeItem<CsvRow> item: treeItem.getChildren()){
            if (!treeItem.getChildren().isEmpty()) extend(item);
            item.setExpanded(!item.isExpanded());
        }
    }
}
