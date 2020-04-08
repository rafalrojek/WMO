package sample.backend;

import javafx.scene.control.TreeItem;
import sample.model.CsvRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FxTreeCreator {

    private Map<Integer, TreeItem<CsvRow>> treeMap;
    private TreeItem<CsvRow> root;
    private Map<Integer,CsvRow> dataMap;

    public FxTreeCreator(InMemoryDatabase database) {
        this.dataMap = database.getDataMap();
    }

    public TreeItem<CsvRow> createTree(List<CsvRow> list){
        clear();
        list.forEach(csvRow -> {
            TreeItem<CsvRow> treeItem = new TreeItem<>(csvRow);
            treeItem.setExpanded(true);
            treeMap.putIfAbsent(csvRow.getId(), treeItem);
            if(csvRow.getParentId() != null) {
                if(treeMap.get(csvRow.getParentId()) == null){
                    addPredecessors(treeItem);
                }
                treeMap.putIfAbsent(csvRow.getParentId(), new TreeItem<>(dataMap.get(csvRow.getParentId())));
                treeMap.get(csvRow.getParentId()).getChildren().add(treeItem);
            }
            else{
                root.getChildren().add(treeItem);
            }
        });

        return root;
    }

    private void addPredecessors(TreeItem<CsvRow> treeItem){
        TreeItem<CsvRow> parentTreeItem = null;
        while(parentTreeItem == null){
            parentTreeItem = new TreeItem<>(dataMap.get(treeItem.getValue().getParentId()));
            parentTreeItem.getChildren().add(treeItem);
            treeMap.put(treeItem.getValue().getParentId(), parentTreeItem);

            treeItem = parentTreeItem;
            parentTreeItem = treeMap.get(parentTreeItem.getValue().getParentId());
        }

    }

    private void clear(){
        treeMap = new HashMap<>();
        root = new TreeItem<>();
    }
}
