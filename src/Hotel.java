public class Hotel {
    private String hotelName;
    private int forWeekDay;
    private int forWeekEnd;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getForWeekDay() {
        return forWeekDay;
    }

    public void setForWeekDay(int forWeekDay) {
        this.forWeekDay = forWeekDay;
    }

    public int getForWeekEnd() {
        return forWeekEnd;
    }

    public void setForWeekEnd(int forWeekEnd) {
        this.forWeekEnd = forWeekEnd;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", forWeekDay=" + forWeekDay +
                ", forWeekEnd=" + forWeekEnd +
                '}';
    }
}