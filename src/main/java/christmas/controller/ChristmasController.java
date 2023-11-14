package christmas.controller;

import christmas.domain.Judgment;
import christmas.domain.Reservation;

import static christmas.view.output.OutputView.welcomeMessage;

public class ChristmasController {

    private Judgment judgment = new Judgment();

    public void run() {
        welcomeMessage();

        Reservation reservation = judgment.reserveEnrollment();

        judgment.checkEvent();
    }

}
