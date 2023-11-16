package christmas.domain;

import christmas.util.Menu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReservationTest {

    @Test
    void 메뉴_전체_금액_계산() {
        // given
        HashMap<Menu, Integer> menu = new HashMap<>();
        menu.put(Menu.샴페인 , 2);
        menu.put(Menu.레드와인 , 5);
        menu.put(Menu.바비큐립 , 1);
        menu.put(Menu.초코케이크 , 3);
        menu.put(Menu.아이스크림 , 4);
        Reservation reservation = new Reservation(4 , menu);

        // when
        int result = reservation.getTotalPrice();

        // then
        assertThat(result).isEqualTo(469000);
    }

    @Test
    void 메인_메뉴_갯수() {
        // given
        HashMap<Menu, Integer> menu = new HashMap<>();
        menu.put(Menu.샴페인 , 2);
        menu.put(Menu.레드와인 , 5);
        menu.put(Menu.바비큐립 , 1);
        menu.put(Menu.초코케이크 , 3);
        menu.put(Menu.아이스크림 , 4);
        Reservation reservation = new Reservation(4 , menu);

        // when
        int result = reservation.countMainMenu();

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 디저트_메뉴_갯수() {
        // given
        HashMap<Menu, Integer> menu = new HashMap<>();
        menu.put(Menu.샴페인 , 2);
        menu.put(Menu.레드와인 , 5);
        menu.put(Menu.바비큐립 , 1);
        menu.put(Menu.초코케이크 , 3);
        menu.put(Menu.아이스크림 , 4);
        Reservation reservation = new Reservation(4 , menu);

        // when
        int result = reservation.countDessertMenu();

        // then
        assertThat(result).isEqualTo(7);
    }
}
