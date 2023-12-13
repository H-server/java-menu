package menu.view;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import menu.model.Category;
import menu.model.Recommendation;

public class OutputView {
    public static void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public static void printMenuResult() {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printWithJoiner(Category.getSelectedCategories(), "카테고리");
        for (Map.Entry<String, List<String>> entry : Recommendation.getMenuResult().entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            printWithJoiner(values, key);
        }
        System.out.println("\n추천을 완료했습니다.");
    }

    private static void printWithJoiner(List<String> output, String index) {
        output.add(0, index);
        StringJoiner joiner = new StringJoiner(" | ", "[ ", " ]");
        output.forEach(joiner::add);
        System.out.println(joiner);
    }
}
