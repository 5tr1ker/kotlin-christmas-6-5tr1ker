package christmas.controller;

import christmas.domain.Judgment;
import christmas.domain.Reservation;
import christmas.view.OutputView;

import static christmas.util.OutputMessage.EVENT_PREVIEW;
import static christmas.view.OutputView.welcomeMessage;

public class ChristmasController {

    private Judgment judgment = new Judgment();

    public void run() {
        welcomeMessage();

        Reservation reservation = judgment.reserveEnrollment();
        System.out.printf(EVENT_PREVIEW.getMessage() , reservation.getInviteDate());
        reservation.printMenu();
        OutputView.printBeforeSaleTotalPrice(reservation.getTotalPrice());
    }

}
