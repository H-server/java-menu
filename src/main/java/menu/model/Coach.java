package menu.model;

public class Coach {
    public String[] setCoach(String input) {
        String[] coachNames = splitName(input);
        validate(coachNames);
        return coachNames;
    }

    private static String[] splitName(String input) {
        return input.split(",");
    }

    private static void validate(String[] coachNames) {
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
}
