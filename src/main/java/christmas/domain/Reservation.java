package christmas.domain;

import christmas.util.Menu;

import java.util.HashMap;
import java.util.Map;

import static christmas.util.ErrorMessage.INVALID_DATE;
import static christmas.util.ErrorMessage.INVALID_ORDER;
import static christmas.util.OutputMessage.SHOW_MENU;
import static christmas.view.InputView.readMenu;
import static christmas.view.InputView.readVisitDate;

public class Reservation {

    private int inviteDate;
    private Map<Menu, Integer> orderMenu = new HashMap<>();

    public void inputVisitDate() {
        int date = convertToInt(readVisitDate());
        checkIsValidDate(date);

        this.inviteDate = date;

    }

    private void checkIsValidDate(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    private void addOrderMenu(String menuName, int amount) {
        if (orderMenu.containsKey(menuName)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }

        Menu result = MenuFinder.findMenu(menuName);
        orderMenu.put(result, amount);
    }

    public void inputOrderMenu() {
        String orderMenus[] = readMenu().split(",");

        for (String orderMenu : orderMenus) {
            processOrderMenu(orderMenu.split("-"));
        }
    }

    private void processOrderMenu(String[] menu) {
        isValidMenuData(menu);
        int amount = convertToInt(menu[1]);

        addOrderMenu(menu[0], amount);
    }

    private void isValidMenuData(String menuData[]) {
        if (menuData.length != 2) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private int convertToInt(String string) {
        try {
            return Integer.parseInt(string);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    public void printMenu() {
        for (Menu menu : orderMenu.keySet()) {
            System.out.printf(SHOW_MENU.getMessage(), menu, orderMenu.get(menu));
        }
    }

}
