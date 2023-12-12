package menu.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.MenuCategory;

public class Coach {
    private static Map<String, List<String>> engagedCoaches = new HashMap<>();

    public String[] setCoachNames(String input) {
        String[] coachNames = splitByComma(input);
        validateCoach(coachNames);
        return coachNames;
    }

    private static String[] splitByComma(String input) {
        return input.split(",");
    }

    private static void validateCoach(String[] coachNames) {
        for(String coach : coachNames) {
            validateNameLength(coach);
        }
        validateCoachLimit(coachNames);
    }

    private static void validateNameLength(String coach) {
        int length = coach.length();
        boolean isSatisfied = (2 <= length && length <= 4);
        if(!isSatisfied) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자로 입력해야 합니다.");
        }
    }

    private static void validateCoachLimit(String[] coachNames) {
        int length = coachNames.length;
        boolean isSatisfied = (2 <= length && length <= 5);
        if(!isSatisfied) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명으로 입력해야 합니다.");
        }
    }

    public void setForbiddenMenu(String coachName, String input) {
        String[] forbiddenMenus = splitByComma(input);
        if(!input.isEmpty()) {
            validateForbiddenMenus(forbiddenMenus);
            validateMenusLength(forbiddenMenus);
        }
        engagedCoaches.put(coachName, Arrays.stream(forbiddenMenus).collect(Collectors.toList()));
    }

    private void validateForbiddenMenus(String[] forbiddenMenus) {
        for(String menu : forbiddenMenus) {
            if(!MenuCategory.contains(menu)) {
                throw new IllegalArgumentException("[ERROR] 메뉴 추천 서비스에 있는 메뉴를 입력해야 합니다.");
            }
        }
    }

    private static void validateMenusLength(String[] forbiddenMenus) {
        int length = forbiddenMenus.length;
        boolean isSatisfied = (0 <= length && length <= 2);
        if(!isSatisfied) {
            throw new IllegalArgumentException("[ERROR] 각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴를 입력해야 합니다.");
        }
    }

    public static boolean validateMenu(String coach, String menu, Map<String, List<String>> menuResult) {
        List<String> forbiddenMenus = engagedCoaches.get(coach);
        List<String> recommendatedMenus = menuResult.get(coach);
        boolean isUnique = !(forbiddenMenus.contains(menu) || recommendatedMenus.contains(menu));
        return isUnique;
    }
}
