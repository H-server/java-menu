package menu.controller;

import menu.model.Category;
import menu.model.Coach;
import menu.model.Recommendation;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    public void execute() {
        OutputView.printStartMessage();
        Coach coach = new Coach();
        String[] coachNames = manageCoachName(coach);
        manageForbiddenMenus(coach, coachNames);
        Recommendation recommendation = new Recommendation(coachNames);
        Category category = new Category();
        setMenuForWeek(recommendation, category, coachNames);
        OutputView.printMenuResult();
    }

    private void setMenuForWeek(Recommendation recommendation, Category category, String[] coachNames) {
        for (int i = 0; i < 5; i++) {
            String currentCategory = category.setCategory();
            recommendation.setMenu(currentCategory, coachNames);
        }
    }

    private static String[] manageCoachName(Coach coach) {
        String[] coachNames;
        while(true) {
            try {
                coachNames = coach.setCoachNames(InputView.readCoachNames());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return coachNames;
    }
    // 코치네임들 데이터 여기로 가져오는 게 맞는가?

    private static void manageForbiddenMenus(Coach coach, String[] coachNames) {
        for(String coachName : coachNames) {
            while(true) {
                try {
                    coach.setForbiddenMenu(coachName, InputView.readForbiddenMenu(coachName)); // 여기서는 옳음 view로 전달하기 위함
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
