package menu;

import menu.model.Category;

public class Application {
    public static void main(String[] args) {
        Category category = new Category();
        String c = category.setCategory();
        System.out.println(c);
    }
}
