package sample.model.enums;

public enum CategoriesEnum {
    BULDOG("Buldog"),
    CHIHUAHUA("Chihuahua"),
    DOGGO("Pieseł"),
    JAMNIK("Jamnik"),
    YORK("York"),
    ROTTWEILER("Rottweiler");

    private String name;

    CategoriesEnum(String str){
        this.name = str;
    }

    @Override
    public String toString() {
        return name;
    }
}
