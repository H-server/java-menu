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
        String[] coachNames = null;
        boolean isSatisfied = false;
        while(!isSatisfied) {
            try {
                coachNames = coach.setCoach(InputView.readCoachNames());
                isSatisfied = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        // 코치 이름 리스트, 각 코치가 못 먹는 메뉴 Map으로 받아오기
        Map<String, List<String>> engagedCoaches = new HashMap<>();
        Category category = new Category();
        String currentCategory = category.setCategory();
        Recommendation recommendation = new Recommendation(engagedCoaches);
        recommendation.setMenu(currentCategory);
    }

}
