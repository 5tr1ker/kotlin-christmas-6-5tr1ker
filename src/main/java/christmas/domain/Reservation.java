package christmas.domain;

import christmas.util.Menu;

import java.util.HashMap;
import java.util.Map;

import static christmas.util.ErrorMessage.INVALID_DATE;
import static christmas.util.ErrorMessage.INVALID_ORDER;
import static christmas.view.input.InputView.readMenu;
import static christmas.view.input.InputView.readVisitDate;

public class Reservation {

    private int inviteDate;
    private Map<Menu, Integer> orderMenu = new HashMap<>();

    public void inputVisitDate() {
        try {
            int date = convertToInt(readVisitDate(), INVALID_DATE.getMessage());
            checkIsValidDate(date);

            this.inviteDate = date;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            inputVisitDate();
        }
    }

    private void checkIsValidDate(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    private void addOrderMenu(String menuName, int amount) {
        if (orderMenu.containsKey(MenuFinder.findMenu(menuName))) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }

        Menu result = MenuFinder.findMenu(menuName);
        orderMenu.put(result, amount);
    }

    public void inputOrderMenu() {
       try {
            String orderMenus[] = readMenu().split(",");

            checkIsOnlyDrink(orderMenus.clone());

            for (String orderMenu : orderMenus) {
                processOrderMenu(orderMenu.split("-"));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            orderMenu.clear();
            inputOrderMenu();
        }
    }

    private void checkIsOnlyDrink(String orderMenus[]) {
        if(isOnlyDrink(orderMenus)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private boolean isOnlyDrink(String orderMenus[]) {
        for (String orderMenu : orderMenus) {
            Menu menu = MenuFinder.findMenu(orderMenu.split("-")[0]);

            if(!menu.getType().equals("DRINK")) {
                return false;
            }
        }

        return true;
    }

    private void processOrderMenu(String[] menu) {
        isValidMenuData(menu);
        int amount = convertToInt(menu[1], INVALID_ORDER.getMessage());

        isValidAmount(amount);

        addOrderMenu(menu[0], amount);
    }

    private void isValidAmount(int amount) {
        if(amount > 20 || amount < 1) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private void isValidMenuData(String menuData[]) {
        if (menuData.length != 2) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private int convertToInt(String string, String errorMessage) {
        try {
            return Integer.parseInt(string.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (Menu menu : orderMenu.keySet()) {
            totalPrice += menu.getPrice() * orderMenu.get(menu);
        }

        return totalPrice;
    }

    public int getInviteDate() {
        return inviteDate;
    }

    public Map getOrderMenu() {
        return orderMenu;
    }

    public int countMainMenu() {
        int count = 0;

        for(Menu menu : orderMenu.keySet()) {
            if(menu.getType().equals("MAIN")) {
                count += orderMenu.get(menu);
            }
        }

        return count;
    }

    public int countDessertMenu() {
        int count = 0;

        for(Menu menu : orderMenu.keySet()) {
            if(menu.getType().equals("DESSERT")) {
                count += orderMenu.get(menu);
            }
        }

        return count;
    }

}
