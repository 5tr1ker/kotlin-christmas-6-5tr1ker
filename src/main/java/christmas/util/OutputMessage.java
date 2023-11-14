package christmas.util;

public enum OutputMessage {


    WELCOME_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.") ,
    ASK_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ASK_ORDER_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)") ,

    EVENT_PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!") ,
    ORDER_MENU("<주문 메뉴>") ,
    BEFORE_SALE_TOTAL_PRICE("<할인 전 총주문 금액>"),
    AFTER_SALE_TOTAL_PRICE("<할인 후 예상 결제 금액>"),
    PRESENT_MENU("<증정 메뉴>") ,
    BENEFIT_DETAIL("<혜택 내역>") ,
    BENEFIT_PRICE("<총혜택 금액>") ,
    EVENT_BADGE("<12월 이벤트 배지>"),

    NONE("없음"),
    SHOW_MENU("%s %d개"),
    SHOW_PRICE("%s %d원");

    private String message;

    public String getMessage() {
        return message;
    }

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
