package christmas.domain;

import christmas.view.output.OutputView;

import static christmas.view.output.EventOutputView.*;
import static christmas.view.output.OutputView.*;

public class Judgment {

    private Reservation reservation;

    public Reservation reserveEnrollment() {
        reservation = new Reservation();

        reservation.inputVisitDate();
        reservation.inputOrderMenu();

        return reservation;
    }

    public void checkEvent() {
        EventVerifier eventVerifier = new EventVerifier(reservation);

        eventPreviewMessage(reservation.getInviteDate());
        printMenu(reservation.getOrderMenu());
        OutputView.printBeforeSaleTotalPrice(reservation.getTotalPrice());

        printGiveawayEvent(eventVerifier.isGiveawayEvent());
        printBenefitDetail(eventVerifier);
        printEventBadge("wad");
    }

}
