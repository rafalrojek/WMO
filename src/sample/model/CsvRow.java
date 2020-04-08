package sample.model;
import sample.model.enums.CategoriesEnum;
import java.util.List;

public class CsvRow {
    //ID	ID Task/Act	Czynności/Zadania	Produkty	Aktywność	Rola  Chihuahua, York, Jamnik, Buldog, Rottweiler

    private Integer id;
    private Integer parentId;
    private String task;
    private String product;
    private String activity;
    private String role;
    private List<CategoriesEnum> categories;

    @Override
    public String toString() {
        return "CsvRow{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", task='" + task + '\'' +
                ", product='" + product + '\'' +
                ", activity='" + activity + '\'' +
                ", role='" + role + '\'' +
                ", categories=" + categories +
                '}';
    }

    public int getId() { return id; }

    public Integer getParentId() {
        return parentId;
    }

    public String getTask() {
        return task;
    }

    public String getProduct() {
        return product;
    }

    public String getActivity() {
        return activity;
    }

    public String getRole() {
        return role;
    }

    public List<CategoriesEnum> getCategories() {
        return categories;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCategories(List<CategoriesEnum> categories) {
        this.categories = categories;
    }
}
