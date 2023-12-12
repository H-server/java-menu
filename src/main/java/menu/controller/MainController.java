package menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.model.Category;
import menu.model.Recommendation;

public class MainController {
    public void excute() {
        // 코치 이름 리스트, 각 코치가 못 먹는 메뉴 Map으로 받아오기
        Map<String, List<String>> engagedCoaches = new HashMap<>();
        Category category = new Category();
        String currentCategory = category.setCategory();
        Recommendation recommendation = new Recommendation(engagedCoaches);
        recommendation.setMenu(currentCategory);
    }

}
