package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.MenuCategory;

public class Recommendation {
    private static Map<String, List<String>> engagedCoaches = new HashMap<>();
    private static Map<String, List<String>> menuResult = new HashMap<>();

    public Recommendation(Map<String, List<String>> engagedCoaches) {
        engagedCoaches = engagedCoaches;
        for (String key : engagedCoaches.keySet()) {
            menuResult.put(key, null);
        }
    }

    public void setMenu(String currentCategory) {
        List<String> currentMenuList = getMenuList(currentCategory);
        for (Map.Entry<String, List<String>> entry : engagedCoaches.entrySet()) {
            String menu = null;
            boolean isUnique = false;
            while(!isUnique) {
                menu = Randoms.shuffle(currentMenuList).get(0);
                isUnique = validateMenu(entry, menu);
            }
            List<String> menus = menuResult.get(entry.getKey());
            menus.add(menu);
            menuResult.put(entry.getKey(), menus);
        }
        System.out.println(menuResult);
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

    private static boolean validateMenu(Map.Entry<String, List<String>> entry, String menu) {
        List<String> forbiddenMenus = entry.getValue();
        List<String> recommendatedMenus = menuResult.get(entry.getKey());
        boolean isUnique = !(forbiddenMenus.contains(menu) || recommendatedMenus.contains(menu));
        return isUnique;
    }
}
