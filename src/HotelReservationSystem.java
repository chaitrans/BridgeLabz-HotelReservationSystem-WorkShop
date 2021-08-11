import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ability to add weekday and weekend rates for each Hotel
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

    public void findCheapestHotel(ArrayList<Hotel> hotelList) throws DateTimeParseException {
        System.out.println();
        System.out.println("Enter start date and end date int the format (yyyy-MM-dd),(yyyy-MM-dd)");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next(); //Storing String type(scanner.next()) in String line
        String[] input = line.split(","); 

        //LocalDate parse() will give instance of local time.
        LocalDate startDate = LocalDate.parse(input[0]);
        LocalDate endDate = LocalDate.parse(input[1]);

        //Calculating Number of days in between
        int dateDifference=(int) ChronoUnit.DAYS.between(startDate, endDate);
        int cheapestRate= Integer.MAX_VALUE;
        String cheapestHotel="";

        for(Hotel hotel : hotelList) {
            int rateForHotel=dateDifference*hotel.getForWeekDay();
            if(rateForHotel<cheapestRate) {
                cheapestRate=rateForHotel;
                cheapestHotel=hotel.getHotelName();
            }
        }
        if(cheapestRate!=Integer.MAX_VALUE)
            System.out.println("Cheapest Hotel : \n"+cheapestHotel+", Total Rates: "+cheapestRate);
    }

    public void displayHotels(ArrayList<Hotel> hotelList) {
        if (hotelList.size() == 0)
            System.out.println("No Hotels in the database");
        else {
            for (Hotel hotel : hotelList)
                System.out.println(hotel.toString());
        }
    }
}