package christmas.util;

public enum ErrorMessage {

    INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.") ,
    INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private String message;

    public String getMessage() {
        return message;
    }

    ErrorMessage(String message) {
        this.message = message;
    }

}
