package christmas.domain;

import christmas.view.InputView;

public class Judgment {

    public Reservation newReservation() {
        Reservation reservation = new Reservation();

        reservation.inputVisitDate();
        reservation.inputOrderMenu();

        return null;
    }

}
