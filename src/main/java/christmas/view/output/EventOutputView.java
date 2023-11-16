package christmas.view.output;

import christmas.domain.EventVerifier;
import christmas.domain.Reservation;

import static christmas.util.OutputMessage.*;
import static christmas.util.OutputMessage.EVENT_BADGE;
import static christmas.view.output.OutputView.formatAmount;
import static christmas.view.output.OutputView.printAmountOfMoney;

public class EventOutputView {

    private static boolean benefitFlag = false;

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
        System.out.println(BENEFIT_DETAIL);

        printChristmasDay(eventVerifier);
        printWeekendEventOrWeekdayEvent(eventVerifier);
        printIsGiveawayEvent(eventVerifier);
        printIsDiscountSpecialDay(eventVerifier);

        if(!benefitFlag) {
            System.out.println(NONE);
        }
    }

    private static void printIsDiscountSpecialDay(EventVerifier eventVerifier) {
        if(eventVerifier.isDiscountSpecialDay()) {
            System.out.println(SPECIAL_EVENT);

            benefitFlag = true;
        }
    }

    private static void printIsGiveawayEvent(EventVerifier eventVerifier) {
        if(eventVerifier.isGiveawayEvent()) {
            System.out.println(GIVEAWAY_EVENT);

            benefitFlag = true;
        }

    }

    private static void printChristmasDay(EventVerifier eventVerifier) {
        if(eventVerifier.getInviteDate() <= 25) {
            System.out.printf("크리스마스 디데이 할인: ");

            printMoneyIfNotZero(eventVerifier.discountChristmasDay());

            benefitFlag = true;
        }
    }

    private static void printMoneyIfNotZero(int money) {
        if(money != 0) {
            printAmountOfMoney(money);
        }
    }

    public static void printWeekendEventOrWeekdayEvent(EventVerifier eventVerifier) {
        if(eventVerifier.isWeekdayOrWeekend()) {
            printIfNotZero(eventVerifier.discountJudgeWeekdayOrWeekend() , "주말 할인: -");

            return;
        }

        printIfNotZero(eventVerifier.discountJudgeWeekdayOrWeekend() , "평일 할인: -");
    }

    private static void printIfNotZero(int amount , String message) {
        if(amount > 0) {
            System.out.printf(message);

            printMoneyIfNotZero(amount);

            benefitFlag = true;
        }
    }

    public static void printTotalBenefitPrice(EventVerifier eventVerifier) {
        int price = eventVerifier.totalBenefitPrice();

        System.out.println(BENEFIT_PRICE);
        if(price != 0) {
            System.out.printf("-");
        }
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
            return;
        }
        System.out.println(NONE);
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
