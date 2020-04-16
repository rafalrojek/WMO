package sample.backend;

import sample.model.CsvRow;

import java.util.List;
import java.util.stream.Collectors;

public class StatsCounter {
    public static int countActivities(List<CsvRow> list){
        return list.stream()
                .filter(csvRow -> csvRow.getProduct() == null || csvRow.getProduct().isEmpty())
                .map(csvRow -> {
                    Integer parentId = csvRow.getParentId();
                    if(parentId == null) parentId = 0;
                    return new ActivityDistinctIdentifier(parentId,csvRow.getActivity());
                })
                .collect(Collectors.toSet())
                .size();
    }

    public static int countTasks(List<CsvRow> list){
        return list.stream()
                .filter(csvRow -> csvRow.getProduct() != null && !csvRow.getProduct().isEmpty())
                .map(csvRow -> new TaskDistinctIdentifier(csvRow.getParentId(),csvRow.getTask()))
                .collect(Collectors.toSet())
                .size();
    }

    public static int countProducts(List<CsvRow> list){
        return list.stream()
                .filter(csvRow -> csvRow.getProduct() != null && !csvRow.getProduct().isEmpty())
                .map(CsvRow::getProduct)
                .collect(Collectors.toSet())
                .size();

    }

    public static int countRoles(List<CsvRow> list){
        return list.stream()
                .filter(csvRow -> csvRow.getRole() != null && !csvRow.getRole().isEmpty())
                .map(CsvRow::getRole)
                .collect(Collectors.toSet())
                .size();
    }





    private static class ActivityDistinctIdentifier {
        public int parentId;
        public String activitiName;

        public ActivityDistinctIdentifier(int parentId, String activitiName) {
            this.parentId = parentId;
            this.activitiName = activitiName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ActivityDistinctIdentifier that = (ActivityDistinctIdentifier) o;

            if (parentId != that.parentId) return false;
            return activitiName != null ? activitiName.equals(that.activitiName) : that.activitiName == null;
        }

        @Override
        public int hashCode() {
            int result = parentId;
            result = 31 * result + (activitiName != null ? activitiName.hashCode() : 0);
            return result;
        }
    }




    private static class TaskDistinctIdentifier {
        public int parentId;
        public String taskName;

        public TaskDistinctIdentifier(int parentId, String taskName) {
            this.parentId = parentId;
            this.taskName = taskName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TaskDistinctIdentifier that = (TaskDistinctIdentifier) o;

            if (parentId != that.parentId) return false;
            return taskName != null ? taskName.equals(that.taskName) : that.taskName == null;
        }

        @Override
        public int hashCode() {
            int result = parentId;
            result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
            return result;
        }
    }
}
