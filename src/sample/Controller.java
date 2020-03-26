package sample;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class Controller {
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

    public void Calculate(ActionEvent actionEvent) {
        root.getChildren().removeAll();
        AddToggle(MoneySize);
        AddToggle(TeamSize);
        AddToggle(TimeSize);
        AddToggle(RequirementStability);
        AddToggle(ProblemKnowledge);
        AddToggle(FormalSize);
        AddToggle(InnovationSize);
        AddToggle(DevelopersSkills);
        AddToggle(QualitySize);

        table.setRoot(root);

    }

    private void AddToggle(ToggleGroup tg) {
        if (tg.getSelectedToggle() != null) {
            RadioButton rb = (RadioButton) tg.getSelectedToggle();
            String name = rb.getText();
            TreeItem<String> toggle = new TreeItem<>("Toggle");
            TreeItem<String> add = new TreeItem<>(name);
            toggle.getChildren().add(add);
            root.getChildren().add(toggle);
        }
    }
}
