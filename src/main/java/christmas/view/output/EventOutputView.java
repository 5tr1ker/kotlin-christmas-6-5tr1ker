package christmas.view.output;

import christmas.domain.EventVerifier;

import static christmas.util.OutputMessage.*;
import static christmas.util.OutputMessage.EVENT_BADGE;
import static christmas.view.output.OutputView.printAmountOfMoney;

public class EventOutputView {
    public static void eventPreviewMessage(int price) {
        System.out.printf(EVENT_PREVIEW.getMessage() , price);
    }

    public static void printGiveawayEvent(boolean flag) {
        System.out.println(PRESENT_MENU);

        if(flag) {
            System.out.printf(SHOW_MENU.getMessage() , "샴페인" , 1);

            return;
        }

        System.out.println(NONE);
    }

    public static void printBenefitDetail(EventVerifier eventVerifier) {
        System.out.printf(BENEFIT_DETAIL + "\n크리스마스 디데이 할인: ");
        printAmountOfMoney(eventVerifier.discountChristmasDay());

        printWeekendEventOrWeekdayEvent(eventVerifier);

        if(eventVerifier.isDiscountSpecialDay()) {
            System.out.println(SPECIAL_EVENT);
        }

        if(eventVerifier.isGiveawayEvent()) {
            System.out.println(GIVEAWAY_EVENT);
        }

    }

    public static void printWeekendEventOrWeekdayEvent(EventVerifier eventVerifier) {
        if(eventVerifier.isWeekdayOrWeekend()) {
            System.out.printf("주말 할인: -");
            printAmountOfMoney(eventVerifier.discountJudgeWeekdayOrWeekend());

            return;
        }

        System.out.printf("평일 할인: -");
        printAmountOfMoney(eventVerifier.discountJudgeWeekdayOrWeekend());
    }

    public static void printEventBadge(String badge) {
        System.out.println(EVENT_BADGE + "\n" + badge);
    }
}
