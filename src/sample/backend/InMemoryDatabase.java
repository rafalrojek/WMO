package sample.backend;
import sample.model.CsvRow;
import sample.model.enums.CategoriesEnum;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryDatabase {

    private List<CsvRow> data;
    private Map<Integer, CsvRow> dataMap = new HashMap<>();
    private CsvReader csvReader = new CsvReader();
    private Comparator<CsvRow> comparator = Comparator.comparing(CsvRow::getId);

    public InMemoryDatabase(){
        data = csvReader.read();
        data.forEach(csvRow -> dataMap.put(csvRow.getId(),csvRow));
    }

    public List<CsvRow> getAll(){
        return data;
    }

    public List<CsvRow> getByProduct(String product){
        return transformList(data.stream()
                .filter(el -> el.getProduct().equals(product))
                .sorted(comparator)
                .collect(Collectors.toList()));
    }

    public List<CsvRow> getByProduct(CategoriesEnum category, String product){
        return transformList(data.stream()
                .filter(el -> el.getCategories().contains(category))
                .filter(el -> el.getProduct().equals(product))
                .sorted(comparator)
                .collect(Collectors.toList()));
    }

    public List<CsvRow> getByRole(String role){
        return transformList(data.stream()
                .filter(el -> el.getRole().equals(role))
                .sorted(comparator)
                .collect(Collectors.toList()));
    }

    public List<CsvRow> getByRole(CategoriesEnum category, String role){
        return transformList(data.stream()
                .filter(el -> el.getCategories().contains(category))
                .filter(el -> el.getRole().equals(role))
                .sorted(comparator)
                .collect(Collectors.toList()));
    }

    public List<CsvRow> getByActivity(String activity){
        return transformList(data.stream()
                .filter(el -> el.getActivity().equals(activity))
                .sorted(comparator)
                .collect(Collectors.toList()));
    }

    public List<CsvRow> getByActivity(CategoriesEnum category, String activity){
        return transformList(data.stream()
                .filter(el -> el.getCategories().contains(category))
                .filter(el -> el.getActivity().equals(activity))
                .sorted(comparator)
                .collect(Collectors.toList()));
    }

    public List<CsvRow> getByCategory(CategoriesEnum category){
        return transformList(data.stream()
                .filter(el -> el.getCategories().contains(category))
                .sorted(comparator)
                .collect(Collectors.toList()));
    }

    private List<CsvRow> transformList(List<CsvRow> dataList){
        Set<CsvRow> set = new HashSet<>();
        dataList.forEach(csvRow -> {
            set.add(csvRow);
            CsvRow parent = dataMap.get(csvRow.getParentId());
            while(parent != null){
                set.add(parent);
                parent = dataMap.get(parent.getParentId());
            }
        });
        return set.stream().sorted(comparator).collect(Collectors.toList());
    }

    public List<String> getAllActivities(){
        return new LinkedList(data.stream().map(CsvRow::getActivity).collect(Collectors.toSet()));
    }

    public List<String> getAllRoles(){
        return new LinkedList(data.stream().map(CsvRow::getRole).collect(Collectors.toSet()));
    }

    public List<String> getAllProducts(){
        return new LinkedList(data.stream().map(CsvRow::getProduct).collect(Collectors.toSet()));
    }

    public List<CsvRow> getData() {
        return data;
    }

    public Map<Integer, CsvRow> getDataMap() {
        return dataMap;
    }
}
