
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int t = read.nextInt();
        Rental[] rentals = new Rental[t];
        for (int i = 0; i < t; i++) {
            String type = read.next();
            String id = read.next();
            int days = read.nextInt();
            int units = read.nextInt();
            if (type.equals("LAPTOP")) {
                rentals[i] = new LaptopRental(id, days);
            } else if (type.equals("PROJECTOR")) {
                rentals[i] = new ProjectorRental(id, days);
            }
            System.out.println(rentals[i].summary() + " | " + rentals[i].calculateCharge() * units);
        }
        read.close();
    }
}