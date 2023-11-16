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

    public void handleEvent() {
        EventVerifier eventVerifier = new EventVerifier(reservation);

        eventPreviewMessage(reservation.getInviteDate());
        printMenu(reservation.getOrderMenu());
        printBeforeSaleTotalPrice(reservation.getTotalPrice());

        if(reservation.getTotalPrice() >= 10000) {
            handleDiscountEvent(eventVerifier);
            return;
        }

        printNotDiscountEvent(reservation.getTotalPrice());
    }

    public void handleDiscountEvent(EventVerifier eventVerifier) {
        printGiveawayEvent(eventVerifier.isGiveawayEvent());
        printBenefitDetail(eventVerifier);
        printTotalBenefitPrice(eventVerifier);
        printAfterSalePrice(eventVerifier , reservation);
        printEventBadge(eventVerifier);
    }

}
