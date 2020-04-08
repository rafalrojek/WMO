package sample.frontend;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import sample.backend.CategoryEngine;
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
            TreeItem<CsvRow> root = getTable(list);
            table.setRoot(root);
            //table.setShowRoot(false);
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
        TreeItem<CsvRow> root = new TreeItem(new CsvRow());

        if (column.getSelectionModel().isSelected(1))
            database.getByActivity(row.getValue().toString()).forEach(v -> root.getChildren().add(new TreeItem(v)));
        else if (column.getSelectionModel().isSelected(2))
            database.getByRole(row.getValue().toString()).forEach(v -> root.getChildren().add(new TreeItem(v)));
        else if (column.getSelectionModel().isSelected(3))
            database.getByProduct(row.getValue().toString()).forEach(v -> root.getChildren().add(new TreeItem(v)));
        table.setRoot(root);
    }

    private TreeItem<CsvRow> getTable (List<CsvRow> list) {
        TreeItem<CsvRow> root = new TreeItem(new CsvRow());
        TreeItem<CsvRow> parent = root;
        for (CsvRow row: list) {
            TreeItem<CsvRow> tmp = new TreeItem<>(row);
            if (row.getProduct() != null) {
                parent.getChildren().add(tmp);
            }
            else if (row.getActivity() != null) {
                while (!parent.getValue().getTask().equals(row.getActivity()) && parent.getParent() != null)
                    parent = parent.getParent();
                parent.getChildren().add(tmp);
                parent = tmp;
            }
            else {
                root.getChildren().add(tmp);
                parent = tmp;
            }
        }
        return root;
    }


}
