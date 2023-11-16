package christmas.util;

public enum OutputMessage {


    WELCOME_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.") ,
    ASK_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ASK_ORDER_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)") ,

    EVENT_PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n") ,
    ORDER_MENU("\n<주문 메뉴>") ,
    BEFORE_SALE_TOTAL_PRICE("\n<할인 전 총주문 금액>"),
    AFTER_SALE_TOTAL_PRICE("\n<할인 후 예상 결제 금액>"),
    PRESENT_MENU("\n<증정 메뉴>") ,
    BENEFIT_DETAIL("\n<혜택 내역>") ,
    BENEFIT_PRICE("\n<총혜택 금액>") ,
    EVENT_BADGE("\n<12월 이벤트 배지>"),
    SPECIAL_EVENT("특별 할인: -1,000원"),
    GIVEAWAY_EVENT("증정 이벤트: -25,000원"),

    NONE("없음"),
    SHOW_MENU("%s %d개\n"),
    SHOW_PRICE("%s %d원\n");

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
