package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.MenuCategory;

public class Recommendation {
    private static Map<String, List<String>> engagedCoaches = new HashMap<>();
    private static Map<String, List<String>> menuResult = new HashMap<>();

    public Recommendation(String[] coachNames) {
        for (String key : coachNames) {
            menuResult.put(key, new ArrayList<>());
        }
    }

    public void setMenu(String currentCategory, String[] coachNames) {
        List<String> currentMenuList = getMenuList(currentCategory);
        for (String coach : coachNames) {
            String menu = null;
            boolean isUnique = false;
            while(!isUnique) {
                menu = Randoms.shuffle(currentMenuList).get(0);
                isUnique = Coach.validateMenu(coach, menu, menuResult);
            }
            List<String> menus = menuResult.get(coach);
            menus.add(menu);
            menuResult.put(coach, menus);
        }
        menuResult.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static List<String> getMenuList(String currentCategory) {
        List<String> currentMenuList = null;
        for (MenuCategory category : MenuCategory.values()) {
            if (category.name().equals(currentCategory)) {
                currentMenuList = category.getMenuList();
                break;
            }
        }
        return currentMenuList;
    }
}
