import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelOperation {

    public static final Scanner SC = new Scanner(System.in);

    private List<Hotel> hotelList;

    public HotelOperation() {
        hotelList = new ArrayList<Hotel>();
    }

    public void addHotel() {
        Hotel newHotel = new Hotel();
        System.out.println("Enter hotel name : ");
        newHotel.setHotelName(SC.next());
        System.out.println("Enter Weekday rate for regular customer : ");
        newHotel.setWeekdayRateForRegularCustomer(SC.nextInt());
        System.out.println("Enter Weekend rate for regular customer : ");
        newHotel.setWeekendRateForRegularCustomer(SC.nextInt());
        System.out.println("Enter the rating(1-5) : ");
        while (true) {
            int rating = SC.nextInt();
            if (rating >= 1 && rating <= 5) {
                newHotel.setRating(rating);
                break;
            } else
                System.out.println("Invalid rating. Enter again : ");
        }
        System.out.println("Enter Weekday rate for reward customer : ");
        newHotel.setWeekdayRateForRewardCustomer(SC.nextInt());
        System.out.println("Enter Weekend rate for reward customer : ");
        newHotel.setWeekendRateForRewardCustomer(SC.nextInt());
        hotelList.add(newHotel);
    }

    public void displayHotels() {
        if (hotelList.size() == 0)
            System.out.println("No Hotels in the database");
        else {
            for (Hotel hotel : hotelList)
                System.out.println(hotel.toString());
        }
    }

    public void findCheapestHotel() throws DateTimeParseException {

        int customerType = 1;
        System.out.println("Select type of customer : ");
        System.out.println("1. Regular");
        System.out.println("2. Reward");
        while (true) {
            customerType = SC.nextInt();
            if (customerType == 1 || customerType == 2)
                break;
            else
                System.out.println("Invalid customer type selected. Select again : ");
        }

        System.out.println("Enter start date and end date int the format (yyyy-MM-dd),(yyyy-MM-dd)");
        String line = SC.next();
        String[] input = line.split(",");

        LocalDate startDate = LocalDate.parse(input[0]);
        LocalDate endDate = LocalDate.parse(input[1]);
        endDate = endDate.plusDays(1);

        int totalDateDifference = (int) ChronoUnit.DAYS.between(startDate, endDate);

        int noOfWeekdends = 0;
        int noOfWeekdays = 0;

        while (startDate.compareTo(endDate) != 0) {
            switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
                case SATURDAY:
                    ++noOfWeekdends;
                    break;
                case SUNDAY:
                    ++noOfWeekdends;
                    break;
                default:
                    break;
            }
            startDate = startDate.plusDays(1);
        }

        noOfWeekdays = totalDateDifference - noOfWeekdends;
        System.out.println("Check by:");
        System.out.println("1. Best price");
        System.out.println("2. Best rating");
        System.out.println("Enter your choice : ");
        int choice = SC.nextInt();
        switch (choice) {

            case 1:
                findCheapestBestRatedHotel(customerType, noOfWeekdays, noOfWeekdends);
                break;
            case 2:
                findBestRatedHotel(customerType, noOfWeekdays, noOfWeekdends);
                break;
            default:
                System.out.println("Invalid choide entered.");
        }
    }

    public void findCheapestBestRatedHotel(int customerType, int noOfWeekdays, int noOfWeekdends) {
        String cheapestHotel = "";
        int cheapestRate = 999999999;
        int maxRating = 0;
        for (Hotel hotel : hotelList) {

            int rateForHotel = (noOfWeekdays * hotel.getWeekdayRateForCustomer(customerType))
                    + (noOfWeekdends * hotel.getWeekendRateForCustomer(customerType));
            int ratingForHotel = hotel.getRating();

            if (rateForHotel < cheapestRate) {
                cheapestRate = rateForHotel;
                cheapestHotel = hotel.getHotelName();
                maxRating = ratingForHotel;
            } else if (rateForHotel == cheapestRate) {
                if (hotel.getRating() > maxRating) {
                    cheapestHotel = hotel.getHotelName();
                    maxRating = ratingForHotel;
                }
            }
        }
        if (cheapestRate != 999999999)
            System.out.println("Cheapest Best Rated Hotel : \n" + cheapestHotel + ", Rating: " + maxRating
                    + " and Total Rates: " + cheapestRate);
        else
            System.out.println("Total price Limit reached");
    }

    public void findBestRatedHotel(int customerType, int noOfWeekdays, int noOfWeekdends) {
        String cheapestHotel = "";
        int cheapestRate = 999999999;
        int maxRating = 0;
        for (Hotel hotel : hotelList) {

            int rateForHotel = (noOfWeekdays * hotel.getWeekdayRateForCustomer(customerType))
                    + (noOfWeekdends * hotel.getWeekendRateForCustomer(customerType));
            int ratingForHotel = hotel.getRating();

            if (ratingForHotel > maxRating) {
                cheapestRate = rateForHotel;
                cheapestHotel = hotel.getHotelName();
                maxRating = ratingForHotel;
            } else if (ratingForHotel == maxRating) {
                if (rateForHotel < cheapestRate) {
                    cheapestHotel = hotel.getHotelName();
                    cheapestRate = rateForHotel;
                }
            }
        }
        if (cheapestRate != 999999999)
            System.out.println("Best Rated Hotel : \n" + cheapestHotel + ", Rating: " + maxRating + " and Total Rates: "
                    + cheapestRate);
        else
            System.out.println("Total price Limit reached");
    }

}