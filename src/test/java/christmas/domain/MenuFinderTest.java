package christmas.domain;

import christmas.util.Menu;
import org.assertj.core.api.NotThrownAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MenuFinderTest {

    @ValueSource(strings = {"티본스테이쿠", "티반스테이크", "초코피자"})
    @ParameterizedTest
    void 메뉴에_없는_이름을_입력(String menuName) {
        assertThatThrownBy(() -> MenuFinder.findMenu(menuName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"티본스테이크", "아이스크림", "시저샐러드"})
    @ParameterizedTest
    void 메뉴에_있는_이름을_입력(String menuName) {
        // given

        // when
        Menu result = MenuFinder.findMenu(menuName);

        // then
        assertThat(result.name()).isEqualTo(menuName);

    }

}
