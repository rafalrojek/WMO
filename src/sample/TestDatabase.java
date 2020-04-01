package sample;

import sample.backend.InMemoryDatabase;
import sample.model.enums.CategoriesEnum;

public class TestDatabase {

    public static void main(String[] args) {
        InMemoryDatabase database = new InMemoryDatabase();
        System.out.println("PRINTING BY ACTIVITY: Manage Change Requests\n");
        database.getByActivity("Manage Change Requests").forEach(System.out::println);
        System.out.println("\n\n\n");
        System.out.println("PRINTING BY PRODUCT: Work Order\n");
        database.getByProduct("Work Order").forEach(System.out::println);
        System.out.println("\n\n\n");
        System.out.println("PRINTING BY ROLE: Process Engineer\n");
        database.getByRole("Process Engineer").forEach(System.out::println);
        System.out.println("\n\n\n");
        System.out.println("PRINTING BY CATEGORY: Labrador\n");
        database.getByCategory(CategoriesEnum.LABRADOR).forEach(System.out::println);
        System.out.println("\n\n\n");
        System.out.println("PRINTING ALL ACTIVITIES:\n");
        database.getAllActivities().forEach(System.out::println);
        System.out.println("\n\n\n");
        System.out.println("PRINTING ALL ROLES:\n");
        database.getAllRoles().forEach(System.out::println);System.out.println("\n\n\n");
        System.out.println("PRINTING BY PRODUCT: Work Order for Labrador\n");
        database.getByProduct(CategoriesEnum.LABRADOR,"Work Order").forEach(System.out::println);
        System.out.println("\n\n\n");
        System.out.println("PRINTING BY ROLE: Process Engineer for Labrador\n");
        database.getByRole(CategoriesEnum.LABRADOR,"Process Engineer").forEach(System.out::println);
        System.out.println("\n\n\n");
        System.out.println("PRINTING BY ACTIVITY: Manage Change Requests\n");
        database.getByActivity(CategoriesEnum.LABRADOR, "Manage Change Requests").forEach(System.out::println);
    }
}
