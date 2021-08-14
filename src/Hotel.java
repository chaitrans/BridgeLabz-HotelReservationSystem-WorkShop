public class Hotel {

    String hotelName;
    int weekdayRateForRegularCustomer;
    int weekendRateForRegularCustomer;
    int weekdayRateForRewardCustomer;
    int weekendRateForRewardCustomer;
    int rating;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekdayRateForRegularCustomer() {
        return weekdayRateForRegularCustomer;
    }

    public void setWeekdayRateForRegularCustomer(int weekdayRateForRegularCustomer) {
        this.weekdayRateForRegularCustomer = weekdayRateForRegularCustomer;
    }

    public int getWeekendRateForRegularCustomer() {
        return weekendRateForRegularCustomer;
    }

    public void setWeekendRateForRegularCustomer(int weekendRateForRegularCustomer) {
        this.weekendRateForRegularCustomer = weekendRateForRegularCustomer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getWeekdayRateForRewardCustomer() {
        return weekdayRateForRewardCustomer;
    }

    public void setWeekdayRateForRewardCustomer(int weekdayRateForRewardCustomer) {
        this.weekdayRateForRewardCustomer = weekdayRateForRewardCustomer;
    }

    public int getWeekendRateForRewardCustomer() {
        return weekendRateForRewardCustomer;
    }

    public void setWeekendRateForRewardCustomer(int weekendRateForRewardCustomer) {
        this.weekendRateForRewardCustomer = weekendRateForRewardCustomer;
    }

    @Override
    public String toString() {
        return (hotelName + "\t" + weekdayRateForRegularCustomer + "\t" + weekendRateForRegularCustomer + "\t" + rating
                + "\t" + weekdayRateForRewardCustomer + "\t" + weekendRateForRewardCustomer);

    }

}