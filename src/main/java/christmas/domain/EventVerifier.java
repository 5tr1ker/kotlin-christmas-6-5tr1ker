package christmas.domain;

public class EventVerifier {

    private final Reservation reservation;

    public EventVerifier(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getInviteDate() {
        return reservation.getInviteDate();
    }

    public int discountChristmasDay() {
        int inviteDate = reservation.getInviteDate();

        return 1000 + (inviteDate - 1) * 100;
    }

    public boolean isWeekdayOrWeekend() {
        int inviteDate = getInviteDate();

        return (inviteDate - 2) % 7 == 0 || (inviteDate - 1) % 7 == 0;
    }

    public int discountJudgeWeekdayOrWeekend() {
        if(isWeekdayOrWeekend()) { // 주말
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

    public boolean isDiscountSpecialDay() {
        int inviteDate = getInviteDate();

        if((inviteDate - 3) % 7 == 0 || inviteDate == 25) {
            return true;
        }

        return false;
    }

    public boolean isGiveawayEvent() {
        if(reservation.getTotalPrice() >= 120_000) {
            return true;
        }

        return false;
    }

    public int totalBenefitPrice() {
        return discountJudgeWeekdayOrWeekend();
    }

}
