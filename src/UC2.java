import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class UC2 {

    /**
     * Ability to find the cheapest hotel for given date range.
     * I/P – 10Sep2020, 11Sep2020 - O/P – Lakewood, Total Rates: $220
     * @author Chaitra.NS
     * @since 11-Aug-2021
     */

    public static void main(String[] args) {
        System.out.println("WELCOME TO HOTEL RESERVATION PROGRAM");
        ArrayList<Hotel> hotelList = new ArrayList<>();

        //Creating Object Of Hotel Class and Calling it by using Obj.Ref Variable and Setting it Values while.
        Hotel lakeWood = new Hotel();
        lakeWood.setHotelName("LakeWood");
        lakeWood.setForWeekDay(110);
        lakeWood.setForWeekEnd(90);
        System.out.println(lakeWood);
        hotelList.add(lakeWood);

        Hotel bridgeWood = new Hotel();
        bridgeWood.setHotelName("Bridge Wood");
        bridgeWood.setForWeekDay(160);
        bridgeWood.setForWeekEnd(60);
        System.out.println(bridgeWood);
        hotelList.add(bridgeWood);

        Hotel ridgeWood = new Hotel();
        ridgeWood.setHotelName("Ridge Wood");
        ridgeWood.setForWeekDay(220);
        ridgeWood.setForWeekEnd(150);
        System.out.println(ridgeWood);
        hotelList.add(ridgeWood);

        UC2 hotelReservation = new UC2();
        hotelReservation.findCheapestHotel(hotelList);

    }

    public void findCheapestHotel(ArrayList<Hotel> hotelList) throws DateTimeParseException {
        System.out.println();
        System.out.println("Enter start date and end date int the format (yyyy-MM-dd),(yyyy-MM-dd)");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next(); //Storing String type(scanner.next()) in String line
        String[] input = line.split(",");  //split accepts regex and separated by comma.

        //LocalDate parse() will give instance of local time.
        LocalDate startDate = LocalDate.parse(input[0]);
        LocalDate endDate = LocalDate.parse(input[1]);

        //Calculating Number of days in between
        int dateDifference=(int) ChronoUnit.DAYS.between(startDate, endDate);
        int cheapestRate=999;
        String cheapestHotel="";

        for(Hotel hotel : hotelList) {
            int rateForHotel=dateDifference*hotel.getForWeekDay();
            if(rateForHotel<cheapestRate) {
                cheapestRate=rateForHotel;
                cheapestHotel=hotel.getHotelName();
            }
        }
        if(cheapestRate!=999)
            System.out.println("Cheapest Hotel : "+cheapestHotel+", \nTotal Rates: "+cheapestRate);
    }
}