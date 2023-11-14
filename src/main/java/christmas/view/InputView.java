package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.util.OutputMessage.ASK_ORDER_MENU;
import static christmas.util.OutputMessage.ASK_VISIT_DATE;

public class InputView {

    public static String readVisitDate() {
        System.out.println(ASK_VISIT_DATE);

        return Console.readLine();
    }

    public static String readMenu() {
        System.out.println(ASK_ORDER_MENU);

        return Console.readLine();
    }

}
