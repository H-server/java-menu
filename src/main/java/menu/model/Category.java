package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category {
    private static Map<Integer, String> categories = new HashMap<>();
    private static List<String> selectedCategories = new ArrayList<>();

    public Category() {
        categories.put(1, "일식");
        categories.put(2, "한식");
        categories.put(3, "중식");
        categories.put(4, "아시안");
        categories.put(5, "양식");
    }

    public String setCategory() {
        String category = null;
        boolean isDuplicated = true;
        while(isDuplicated) {
            category = pickRandomCategory();
            isDuplicated = validate(category);
        }
        selectedCategories.add(category);
        return category;
    }

    private static String pickRandomCategory() {
        return categories.get(Randoms.pickNumberInRange(1, 5));
    }

    private static boolean validate(String category) {
        int count = 0;
        for (String item : selectedCategories) {
            if(item.equals(category)) {
                count++;
            }
        }
        return count > 2;
    }

    public static List<String> getSelectedCategories() {
        return selectedCategories;
    }
}
