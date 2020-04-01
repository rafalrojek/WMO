package sample.backend;

import sample.model.CsvRow;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryDatabase {

    private List<CsvRow> data;
    private CsvReader csvReader = new CsvReader();

    public InMemoryDatabase(){
        data = csvReader.read();
    }

    public List<CsvRow> getAll(){
        return data;
    }

    public List<CsvRow> getByProduct(String product){
        return data.stream()
                .filter(el -> el.getProduct().equals(product))
                .sorted(Comparator.comparing(CsvRow::getActivityId))
                .collect(Collectors.toList());
    }

    public List<CsvRow> getByRole(String role){
        return data.stream()
                .filter(el -> el.getRole().equals(role))
                .sorted(Comparator.comparing(CsvRow::getActivityId))
                .collect(Collectors.toList());
    }

    public List<CsvRow> getByActivity(String activity){
        return data.stream()
                .filter(el -> el.getActivity().equals(activity))
                .sorted(Comparator.comparing(CsvRow::getActivityId))
                .collect(Collectors.toList());
    }
}
