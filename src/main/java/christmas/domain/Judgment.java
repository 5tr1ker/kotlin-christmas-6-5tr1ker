package christmas.domain;

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
    }

}
