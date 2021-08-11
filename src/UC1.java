import java.util.ArrayList;

/**
 * Ability to add Hotel in a Hotel Reservation System.
 * @author Chaitra.NS
 * @since  11-Aug-2021
 */

public class UC1 {

    public static void main(String[] args) {
        System.out.println("WELCOME TO HOTEL RESERVATION PROGRAM");

        //Creating Object Of Hotel Class and Calling it by using Obj.Ref Variable and Setting it Values while.
        Hotel lakeWood = new Hotel();
        lakeWood.setHotelName("LakeWood");
        lakeWood.setForWeekDay(110);
        lakeWood.setForWeekEnd(90);
        System.out.println(lakeWood);

        Hotel bridgeWood = new Hotel();
        bridgeWood.setHotelName("Bridge Wood");
        bridgeWood.setForWeekDay(160);
        bridgeWood.setForWeekEnd(60);
        System.out.println(bridgeWood);

        Hotel ridgeWood = new Hotel();
        ridgeWood.setHotelName("Ridge Wood");
        ridgeWood.setForWeekDay(220);
        ridgeWood.setForWeekEnd(150);
        System.out.println(ridgeWood);
    }
}