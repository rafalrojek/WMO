package sample.model;
import sample.model.enums.CategoriesEnum;
import java.util.List;

public class CsvRow {
    //ID ID Czynności	Czynności/Zadania	Produkty	Aktywność	Rola	Chihuahua
    private int id;
    private int activityId;
    private String task;
    private String product;
    private String activity;
    private String role;
    private List<CategoriesEnum> categories;

    @Override
    public String toString() {
        return "CsvRow{" +
                "id=" + id +
                ", activityId=" + activityId +
                ", task='" + task + '\'' +
                ", product='" + product + '\'' +
                ", activity='" + activity + '\'' +
                ", role='" + role + '\'' +
                ", categories=" + categories +
                '}';
    }

    public int getId() { return id; }

    public int getActivityId() {
        return activityId;
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

    public void setActivityId(int activityId) {
        this.activityId = activityId;
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
