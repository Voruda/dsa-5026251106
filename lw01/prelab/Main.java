import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(Main.class.getResourceAsStream("jobs.txt"));
        ArrayList<PrintJob> jobs = new ArrayList<>();

        while (read.hasNext()) {
            String type = read.next();
            String id = read.next();
            int pages = read.nextInt();

            if (type.equals("COLOUR")) {
                jobs.add(new ColourPrint(id, pages));
            } else if (type.equals("MONO")) {
                jobs.add(new MonoPrint(id, pages));
            }
        }
        read.close();
        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }

    }
}