package christmas.view.output;

import christmas.domain.EventVerifier;
import christmas.util.Menu;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

import static christmas.util.OutputMessage.*;

public class OutputView {

    public static void welcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void printAmountOfMoney(int money) {
        String formattedAmount = formatAmount(money);

        System.out.println(formattedAmount.substring(1) + "원");
    }

    public static String formatAmount(int money) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.KOREA);
        String formattedAmount = currencyFormatter.format(money);

        return formattedAmount;
    }

    public static void printBeforeSaleTotalPrice(int price) {
        System.out.println(BEFORE_SALE_TOTAL_PRICE);

        printAmountOfMoney(price);
    }
    public static void printMenu(Map<Menu, Integer> orderMenu) {
        System.out.println(ORDER_MENU);

        for (Menu menu : orderMenu.keySet()) {
            System.out.printf(SHOW_MENU.getMessage(), menu, orderMenu.get(menu));
        }
    }

}
