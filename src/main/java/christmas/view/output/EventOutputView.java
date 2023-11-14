package christmas.view.output;

import christmas.domain.EventVerifier;
import christmas.domain.Reservation;

import static christmas.util.OutputMessage.*;
import static christmas.util.OutputMessage.EVENT_BADGE;
import static christmas.view.output.OutputView.formatAmount;
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

    public static void printTotalBenefitPrice(EventVerifier eventVerifier) {
        int price = eventVerifier.totalBenefitPrice();

        System.out.printf(BENEFIT_PRICE + "\n-");
        printAmountOfMoney(price);
    }

    public static void printAfterSalePrice(EventVerifier eventVerifier , Reservation reservation) {
        int totalPrice = reservation.getTotalPrice();
        int benefitPrice = eventVerifier.getDiscountAmount();

        System.out.println(AFTER_SALE_TOTAL_PRICE);
        printAmountOfMoney(totalPrice - benefitPrice);
    }

    public static void printEventBadge(EventVerifier eventVerifier) {
        int price = eventVerifier.totalBenefitPrice();
        System.out.println(EVENT_BADGE);

        printBadge(price);
    }

    private static void printBadge(int price) {
        if(price >= 20000) {
            System.out.println("산타");
            return;
        }
        if(price >= 10000) {
            System.out.println("트리");
            return;
        }
        if(price >= 5000) {
            System.out.println("별");
        }
    }

    public static void printNotDiscountEvent(int totalPrice) {
        StringBuilder sb = new StringBuilder();

        sb.append(PRESENT_MENU).append("\n").append(NONE).append("\n");
        sb.append(BENEFIT_DETAIL).append("\n").append(NONE).append("\n");
        sb.append(BENEFIT_PRICE).append("\n").append("0원").append("\n");
        sb.append(AFTER_SALE_TOTAL_PRICE).append("\n").append(formatAmount(totalPrice).substring(1)).append("원\n");
        sb.append(EVENT_BADGE).append("\n").append(NONE).append("\n");

        System.out.println(sb);
    }
}
