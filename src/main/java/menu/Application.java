package menu;

import menu.controller.MainController;
import menu.model.Category;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.excute();
    }
}
