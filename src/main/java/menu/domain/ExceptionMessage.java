package menu.domain;

public enum ExceptionMessage {
    COACH_NAME_LENGTH("코치의 이름은 최소 2글자, 최대 4글자로 입력해야 합니다."),
    COACH_LIMIT("코치는 최소 2명, 최대 5명으로 입력해야 합니다."),
    FORBIDDEN_MENU_CATEGORY("메뉴 추천 서비스에 있는 메뉴를 입력해야 합니다."),
    FORBIDDEN_MENU_LIMIT("각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴를 입력해야 합니다.");


    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}