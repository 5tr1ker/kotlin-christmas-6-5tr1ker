package christmas.domain;

import christmas.util.Menu;

import static christmas.util.ErrorMessage.INVALID_ORDER;

public class MenuFinder {

    public static Menu findMenu(String menuName) {
        for(Menu menu : Menu.values()) {
            if(menu.name().equalsIgnoreCase(menuName)) {
                return menu;
            }
        }

        throw new IllegalArgumentException(INVALID_ORDER.getMessage());
    }

}
