package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>\n없음");
        });
    }

    @Test
    void 증정_메뉴_출력() {
        assertSimpleTest(() -> {
            run("26", "초코케이크-19,레드와인-1");
            assertThat(output()).contains("증정 이벤트: -25,000원");
        });
    }

    @Test
    void 음료만_주문시_오류_출력() {
        assertSimpleTest(() -> {
            runException("26", "제로콜라-19,레드와인-5,샴페인-15");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ValueSource(strings = {"코카콜라-21" , "제로콜라-15,제로콜라-13" , "제로콜라-501" , "양송이수프-3,타파스-3,시저샐러드-3,티본스테이크-3,바비큐립-3,해산물파스타-3,크리스마스파스타-3"})
    @ParameterizedTest
    void 주문갯수_20개이상_예외(String menu) {
        assertSimpleTest(() -> {
            runException("26", menu);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @ValueSource(strings = {"0" , "32" , "341"})
    @ParameterizedTest
    void 날짜_예외_테스트_범위를_벗어나는_값_입력(String date) {
        assertSimpleTest(() -> {
            runException(date);
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @ValueSource(strings = {"a" , "2ba" , " c d" , "[ ][ ]["})
    @ParameterizedTest
    void 날짜_예외_테스트_문자열_값_입력(String date) {
        assertSimpleTest(() -> {
            runException(date);
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @ValueSource(strings = {"코카콜라-a" , "제로콜라-1,제로콜라-4" , "제로콜라-4124" , "샴페인" , "코카콜라주세요" , "1313" , "타파스" , "-4,5" , "제로콜라-0" , "제로콜라--3" , "제로콜라---10"})
    @ParameterizedTest
    void 주문_예외_테스트(String menu) {
        assertSimpleTest(() -> {
            runException("3", menu);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
