package christmas.domain;

public class EventVerifier {

    private final Reservation reservation;

    public EventVerifier(Reservation reservation) {
        this.reservation = reservation;
    }

    public void calculateBenefit() {

    }

    private int discountChristmasDay() {
        int inviteDate = reservation.getInviteDate();

        return 1000 + (inviteDate - 1) * 100;
    }

    private int discountJudgeWeekdayOrWeekend(int inviteDate) {
        if((inviteDate - 2) % 7 == 0 || (inviteDate - 1) % 7 == 0) { // 주말
            return discountWeekend();
        }

        return discountWeekday();
    }

    private int discountWeekday() { // 평일
        return reservation.countDessertMenu() * 2023;
    }

    private int discountWeekend() { // 주말
        return reservation.countMainMenu() * 2023;
    }

    private boolean isDiscountSpecialDay(int inviteDate) {
        if((inviteDate - 3) % 7 == 0 || inviteDate == 25) {
            return true;
        }

        return false;
    }

    private boolean isGiveawayEvent(int inviteDate) {
        if(inviteDate >= 120_000) {
            return true;
        }

        return false;
    }

    private void totalBenefitAmount() {

    }

}
