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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CsvRow csvRow = (CsvRow) o;

        return id != null ? id.equals(csvRow.id) : csvRow.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<CategoriesEnum> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesEnum> categories) {
        this.categories = categories;
    }
}
