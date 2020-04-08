package sample;

import javafx.scene.control.TreeItem;
import sample.backend.FxTreeCreator;
import sample.backend.InMemoryDatabase;
import sample.model.CsvRow;

public class TreeTest {
    public static void main(String[] args) {
        InMemoryDatabase database = new InMemoryDatabase();
        FxTreeCreator fxTreeCreator = new FxTreeCreator(database);
        TreeItem<CsvRow> root = fxTreeCreator.createTree(database.getByProduct("Work Order"));
        printTreeItem(root, 0);
    }


    private static void printTreeItem(TreeItem<CsvRow> treeItem, int depth){
        for (int i = 0; i < depth; i++) {
            System.out.print("   |");
        }
        System.out.println("Item " + treeItem.getValue());
        treeItem.getChildren().forEach(child -> {
            printTreeItem(child, depth+1);
        });
    }
}
