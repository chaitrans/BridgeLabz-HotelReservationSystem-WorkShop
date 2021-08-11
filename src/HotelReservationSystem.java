import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ability to find the cheapest best rated hotel Hotel for a given Date Range
 * @author Chaitra.NS
 * @since  11-Aug-2021
 */

public class HotelReservationSystem {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("WELCOME TO HOTEL RESERVATION PROGRAM");
        ArrayList<Hotel> hotelList = new ArrayList<>();

        //Creating Object Of Hotel Class and Calling it by using Obj.Ref Variable and Setting it Values while.
        Hotel lakeWood = new Hotel();
        lakeWood.setHotelName("LakeWood");
        lakeWood.setForWeekDay(110);
        lakeWood.setForWeekEnd(90);
        lakeWood.setRating(3);
        hotelList.add(lakeWood);

        Hotel bridgeWood = new Hotel();
        bridgeWood.setHotelName("Bridge Wood");
        bridgeWood.setForWeekDay(160);
        bridgeWood.setForWeekEnd(50);
        bridgeWood.setRating(4);
        hotelList.add(bridgeWood);

        Hotel ridgeWood = new Hotel();
        ridgeWood.setHotelName("Ridge Wood");
        ridgeWood.setForWeekDay(220);
        ridgeWood.setForWeekEnd(150);
        ridgeWood.setRating(5);
        hotelList.add(ridgeWood);

        HotelReservationSystem hotelReservation = new HotelReservationSystem();
        hotelReservation.displayHotels(hotelList);
        hotelReservation.findCheapestHotel(hotelList);
    }

    public void displayHotels(ArrayList<Hotel> hotelList) {
        if (hotelList.size() == 0)
            System.out.println("No Hotels in the database");
        else {
            for (Hotel hotel : hotelList)
                System.out.println(hotel.toString());
        }
    }

    public void findCheapestHotel(ArrayList<Hotel> hotelList) throws DateTimeParseException{

        System.out.println("Enter start date and end date int the format (yyyy-MM-dd),(yyyy-MM-dd)");
        String line = scanner.next();
        String[] input = line.split(",");

        LocalDate startDate = LocalDate.parse(input[0]);
        LocalDate endDate = LocalDate.parse(input[1]);
        endDate = endDate.plusDays(1);

        int totalDateDifference = (int) ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("totalDateDifference  " + totalDateDifference);
        int cheapestRate = 999999999;
        String cheapestHotel = "";
        int noOfWeekdends = 0;
        int noOfWeekdays = 0;
        int maxRating=0;

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
        int choice = scanner.nextInt();
        switch (choice) {

            case 1:
                findCheapestBestRatedHotel(noOfWeekdays, noOfWeekdends, hotelList);
                break;
            case 2:
                findBestRatedHotel(noOfWeekdays, noOfWeekdends, hotelList);
                break;
            default:
                System.out.println("Invalid choice entered.");
        }
    }

    public void findCheapestBestRatedHotel(int noOfWeekdays, int noOfWeekdends, ArrayList<Hotel> hotelList) {
        String cheapestHotel = "";
        int cheapestRate = 999999999;
        int maxRating = 0;
        for (Hotel hotel : hotelList) {
            int rateForHotel = (noOfWeekdays * hotel.getForWeekDay())
                    + (noOfWeekdends * hotel.getForWeekEnd());
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

    public void findBestRatedHotel(int noOfWeekdays, int noOfWeekdends, ArrayList<Hotel> hotelList) {
        String cheapestHotel = "";
        int cheapestRate = 999999999;
        int maxRating = 0;
        for (Hotel hotel : hotelList) {
            int rateForHotel = (noOfWeekdays * hotel.getForWeekDay())
                    + (noOfWeekdends * hotel.getForWeekEnd());
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