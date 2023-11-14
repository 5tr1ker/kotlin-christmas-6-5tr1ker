package christmas.view;

import java.text.NumberFormat;
import java.util.Locale;

import static christmas.util.OutputMessage.*;

public class OutputView {

    public static void welcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void printAmountOfMoney(int money) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.KOREA);
        String formattedAmount = currencyFormatter.format(money);

        System.out.println(formattedAmount.substring(1) + "원");
    }

    public static void printBeforeSaleTotalPrice(int price) {
        System.out.println(BEFORE_SALE_TOTAL_PRICE);

        printAmountOfMoney(price);
    }

}
