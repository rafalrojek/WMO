package sample.backend;

import javafx.scene.control.TreeItem;
import sample.model.CsvRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FxTreeCreator {

    public TreeItem<CsvRow> createTree(List<CsvRow> list, Map<Integer,CsvRow> map){
        Map<Integer, TreeItem<CsvRow>> treeMap = new HashMap<>();
        TreeItem<CsvRow> root = new TreeItem<>();
        list.forEach(csvRow -> {
            TreeItem<CsvRow> treeItem = new TreeItem<>(csvRow);
            treeMap.putIfAbsent(csvRow.getId(), treeItem);
            if(csvRow.getParentId() != null) {
                treeMap.putIfAbsent(csvRow.getParentId(), new TreeItem<>(map.get(csvRow.getParentId())));
                treeMap.get(csvRow.getParentId()).getChildren().add(treeItem);
            }
            else{
                root.getChildren().add(treeItem);
            }
        });

        return root;
    }
}
