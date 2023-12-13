package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.MenuCategory;

public class Recommendation {
    private static Map<String, List<String>> menuResult = new HashMap<>();

    public Recommendation(String[] coachNames) {
        for (String key : coachNames) {
            menuResult.put(key, new ArrayList<>());
        }
    }

    public void setMenu(String currentCategory, String[] coachNames) {
        List<String> currentMenuList = getMenuList(currentCategory);

        for (String coach : coachNames) {
            setMenuForCoach(coach, currentMenuList);
        }
    }

    private void setMenuForCoach(String coach, List<String> currentMenuList) {
        List<String> coachMenus = menuResult.get(coach);
        String newMenu;

        do {
            newMenu = Randoms.shuffle(currentMenuList).get(0);
        } while (!Coach.validateMenu(coach, newMenu, menuResult));
        coachMenus.add(newMenu);
        menuResult.put(coach, coachMenus);
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

    public static Map<String, List<String>> getMenuResult() {
        return menuResult;
    }
}
