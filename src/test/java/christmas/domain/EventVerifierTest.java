package christmas.domain;

import christmas.util.Menu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EventVerifierTest {

    @Test
    void 크리스마스_디데이_할인_연산() {
        // given
        EventVerifier eventVerifier = new EventVerifier(new Reservation(18 , null));

        // when
        int price = eventVerifier.discountChristmasDay();

        // then
        assertThat(price).isEqualTo(2700);
    }

    @Test
    void 크리스마스_디데이_할인_해당_안됨() {
        // given
        EventVerifier eventVerifier = new EventVerifier(new Reservation(26 , null));

        // when
        int price = eventVerifier.discountChristmasDay();

        // then
        assertThat(price).isEqualTo(0);
    }

    @ValueSource(ints = {1,2,8,9,15,16,22,23,29,30})
    @ParameterizedTest
    void 주말_여부_확인(int day) {
        // given
        EventVerifier eventVerifier = new EventVerifier(new Reservation(day , null));

        // when
        boolean result = eventVerifier.isWeekdayOrWeekend();

        // then
        assertThat(result).isEqualTo(true);
    }

    @ValueSource(ints = {4,5,6,17,18,19,20,21,24,25})
    @ParameterizedTest
    void 평일_여부_확인(int day) {
        // given
        EventVerifier eventVerifier = new EventVerifier(new Reservation(day , null));

        // when
        boolean result = eventVerifier.isWeekdayOrWeekend();

        // then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 평일_디저트_할인_여부() {
        // given
        HashMap<Menu, Integer> menu = new HashMap<>();
        menu.put(Menu.샴페인 , 2);
        menu.put(Menu.레드와인 , 5);
        menu.put(Menu.바비큐립 , 1);
        menu.put(Menu.초코케이크 , 3);
        menu.put(Menu.아이스크림 , 4);
        EventVerifier eventVerifier = new EventVerifier(new Reservation(4 , menu));

        // when
        int result = eventVerifier.discountJudgeWeekdayOrWeekend();

        // then
        assertThat(result).isEqualTo(2023 * 7);
    }

    @Test
    void 주말_메인메뉴_할인_여부() {
        // given
        HashMap<Menu, Integer> menu = new HashMap<>();
        menu.put(Menu.샴페인 , 2);
        menu.put(Menu.레드와인 , 5);
        menu.put(Menu.바비큐립 , 1);
        menu.put(Menu.초코케이크 , 3);
        menu.put(Menu.아이스크림 , 4);
        EventVerifier eventVerifier = new EventVerifier(new Reservation(1 , menu));

        // when
        int result = eventVerifier.discountJudgeWeekdayOrWeekend();

        // then
        assertThat(result).isEqualTo(2023 * 1);
    }

    @ValueSource(ints = {3,10,17,24,25,31})
    @ParameterizedTest
    void 특별_할인_여부(int day) {
        // given
        EventVerifier eventVerifier = new EventVerifier(new Reservation(day , null));

        // when
        boolean result = eventVerifier.isDiscountSpecialDay();

        // then
        assertThat(result).isEqualTo(true);
    }

    @ValueSource(ints = {1,2,5,8,9})
    @ParameterizedTest
    void 특별_할인_해당안됨(int day) {
        // given
        EventVerifier eventVerifier = new EventVerifier(new Reservation(day , null));

        // when
        boolean result = eventVerifier.isDiscountSpecialDay();

        // then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 사은품_증정() {
        // given
        HashMap<Menu, Integer> menu = new HashMap<>();
        menu.put(Menu.샴페인 , 2);
        menu.put(Menu.레드와인 , 5);
        menu.put(Menu.바비큐립 , 1);
        menu.put(Menu.초코케이크 , 3);
        menu.put(Menu.아이스크림 , 4);
        EventVerifier eventVerifier = new EventVerifier(new Reservation(5 , menu));

        // when
        boolean result = eventVerifier.isGiveawayEvent();

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 사은품_비증정() {
        // given
        HashMap<Menu, Integer> menu = new HashMap<>();
        menu.put(Menu.바비큐립 , 1);
        menu.put(Menu.초코케이크 , 1);
        menu.put(Menu.아이스크림 , 1);
        EventVerifier eventVerifier = new EventVerifier(new Reservation(5 , menu));

        // when
        boolean result = eventVerifier.isGiveawayEvent();

        // then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 총_혜택_금액() {
        // given
        HashMap<Menu, Integer> menu = new HashMap<>();
        menu.put(Menu.샴페인 , 2);
        menu.put(Menu.레드와인 , 5);
        menu.put(Menu.바비큐립 , 1);
        menu.put(Menu.초코케이크 , 3);
        menu.put(Menu.아이스크림 , 4);
        EventVerifier eventVerifier = new EventVerifier(new Reservation(5 , menu));

        // when
        int result = eventVerifier.totalBenefitPrice();

        // then
        assertThat(result).isEqualTo(40561);
    }

    @Test
    void 할인_금액() {
        // given
        HashMap<Menu, Integer> menu = new HashMap<>();
        menu.put(Menu.샴페인 , 2);
        menu.put(Menu.레드와인 , 5);
        menu.put(Menu.바비큐립 , 1);
        menu.put(Menu.초코케이크 , 3);
        menu.put(Menu.아이스크림 , 4);
        EventVerifier eventVerifier = new EventVerifier(new Reservation(5 , menu));

        // when
        int result = eventVerifier.getDiscountAmount();

        // then
        assertThat(result).isEqualTo(15561);
    }

}
