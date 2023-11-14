package christmas.domain;

import christmas.util.Menu;

import java.util.Map;

import static christmas.util.ErrorMessage.INVALID_DATE;
import static christmas.view.InputView.readVisitDate;

public class Reservation {

    private int inviteDate;
    private Map<String , Menu> orderMenu[];


    public void inputVisitDate() {
        try{
            int date = Integer.parseInt(readVisitDate());

            checkIsValidDate(date);

            this.inviteDate = date;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    private void checkIsValidDate(int date) {
        if(date < 1 || date > 31) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    public int getInviteDate() {
        return inviteDate;
    }

    

}
