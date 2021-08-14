import java.util.Scanner;

public class HotelReservationSystem {

    public static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        HotelOperation operationObject = new HotelOperation();

        do {
            System.out.println("1. Add Hotel");
            System.out.println("2. Display Hotels");
            System.out.println("3. Find Cheapest Hotel for given Date Range");
            System.out.println("4. Exit");
            System.out.println("Enter your choice : ");
            int choice = SC.nextInt();
            if (choice == 4)
                break;
            switch (choice) {
                case 1:
                    operationObject.addHotel();
                    break;
                case 2:
                    operationObject.displayHotels();
                    break;
                case 3:
                    operationObject.findCheapestHotel();
                    break;
                default:
                    System.out.println("Invalid option selected");
            }
        } while (true);

    }

}