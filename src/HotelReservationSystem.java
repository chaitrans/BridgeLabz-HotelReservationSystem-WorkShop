import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ability to find the cheapest hotel for given date range
 * @author Chaitra.NS
 * @since  11-Aug-2021
 */

public class HotelReservationSystem {

    public static void main(String[] args) {
        System.out.println("WELCOME TO HOTEL RESERVATION PROGRAM");
        ArrayList<Hotel> hotelList = new ArrayList<>();

        //Creating Object Of Hotel Class and Calling it by using Obj.Ref Variable and Setting it Values while.
        Hotel lakeWood = new Hotel();
        lakeWood.setHotelName("LakeWood");
        lakeWood.setForWeekDay(110);
        lakeWood.setForWeekEnd(90);
        hotelList.add(lakeWood);

        Hotel bridgeWood = new Hotel();
        bridgeWood.setHotelName("Bridge Wood");
        bridgeWood.setForWeekDay(160);
        bridgeWood.setForWeekEnd(50);
        hotelList.add(bridgeWood);

        Hotel ridgeWood = new Hotel();
        ridgeWood.setHotelName("Ridge Wood");
        ridgeWood.setForWeekDay(220);
        ridgeWood.setForWeekEnd(150);
        hotelList.add(ridgeWood);

        HotelReservationSystem hotelReservation = new HotelReservationSystem();
        hotelReservation.findCheapestHotel(hotelList);
        hotelReservation.displayHotels(hotelList);
    }

    public void displayHotels(ArrayList<Hotel> hotelList) {
        if (hotelList.size() == 0)
            System.out.println("No Hotels in the database");
        else {
            for (Hotel hotel : hotelList)
                System.out.println(hotel.toString());
        }
    }

    public void findCheapestHotel(ArrayList<Hotel> hotelList) throws DateTimeParseException {
        Scanner scanner = new Scanner(System.in);

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
        int noOfWeekends = 0;
        int noOfWeekdays = 0;

        while (startDate.compareTo(endDate) != 0) {
            switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
                case SATURDAY:
                    ++noOfWeekends;
                    break;
                case SUNDAY:
                    ++noOfWeekends;
                    break;
            }
            startDate = startDate.plusDays(1);
        }

        noOfWeekdays = totalDateDifference - noOfWeekends;
        for (Hotel hotel : hotelList) {
            int rateForHotel = (noOfWeekdays * hotel.getForWeekDay())
                    + (noOfWeekends * hotel.getForWeekEnd());
            if (rateForHotel < cheapestRate) {
                cheapestRate = rateForHotel;
                cheapestHotel = hotel.getHotelName();
            }
        }
        if (cheapestRate != 999999999)
            System.out.println("Cheapest Hotel : \n" + cheapestHotel + ", Total Rates: " + cheapestRate);
    }
}