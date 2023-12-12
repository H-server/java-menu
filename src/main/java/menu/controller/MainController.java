package menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Recommendation;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    public void excute() {
        OutputView.printStartMessage();
        Coach coach = new Coach();
        String[] coachNames = manageCoachName(coach);
        manageForbiddenMenus(coach, coachNames);

        Category category = new Category();
        String currentCategory = category.setCategory();
        Recommendation recommendation = new Recommendation(coachNames);
        recommendation.setMenu(currentCategory, coachNames);
    }

    private static String[] manageCoachName(Coach coach) {
        String[] coachNames = null;
        boolean isSatisfied = false;
        while(!isSatisfied) {
            try {
                coachNames = coach.setCoachNames(InputView.readCoachNames());
                isSatisfied = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return coachNames;
    }

    private static void manageForbiddenMenus(Coach coach, String[] coachNames) {
        for(String coachName : coachNames) {
            boolean isSatisfied = false;
            while(!isSatisfied) {
                try {
                    coach.setForbiddenMenu(coachName, InputView.readForbiddenMenu(coachName));
                    isSatisfied = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
