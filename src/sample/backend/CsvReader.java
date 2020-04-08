package sample.backend;
import sample.model.CsvRow;
import sample.model.enums.CategoriesEnum;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CsvReader {

    public List<CsvRow> read(){
        try {
            LinkedList<CsvRow> data = new LinkedList<>();
            FileReader reader = new FileReader("Dane do programu.csv");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                try{
                    data.add(parse(line));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            return data;

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            throw new IllegalStateException(e);
        }
    }
    //ID	ID Task/Act	Czynności/Zadania	Produkty	Aktywność	Rola  Chihuahua, York, Jamnik, Buldog, Rottweiler

    private CsvRow parse(String line){
        List<CategoriesEnum> categories = new LinkedList<>();
        String[] dataArray = line.split(";");
        Integer id = Integer.parseInt(dataArray[0]);
        Integer parentId = null;
        try{
            parentId = Integer.parseInt(dataArray[1]);
        }catch (NumberFormatException e){}
        String task = dataArray[2];
        String product = dataArray[3];
        String activity = dataArray[4];
        String role = dataArray[5];
        if(getInt(dataArray[6]) == 1) categories.add(CategoriesEnum.CHIHUAHUA);
        if(getInt(dataArray[7]) == 1) categories.add(CategoriesEnum.YORK);
        if(getInt(dataArray[8]) == 1) categories.add(CategoriesEnum.JAMNIK);
        if(getInt(dataArray[9]) == 1) categories.add(CategoriesEnum.BULDOG);
        if(getInt(dataArray[10]) == 1) categories.add(CategoriesEnum.ROTTWEILER);
        if(id.equals(parentId)) System.out.println("Błąd: id = " + id + " parent = " + parentId);
        CsvRow data = new CsvRow();
        data.setId(id);
        if(parentId != null) data.setParentId(parentId);
        data.setTask(task);
        data.setProduct(product);
        data.setActivity(activity);
        data.setRole(role);
        data.setCategories(categories);
        return data;
    }

    private int getInt(String str){
        return Integer.parseInt(str);
    }
}

