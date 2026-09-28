import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList<String[]> requests = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();
        Queue<String[]> requestQueue = new LinkedList<>();
        Stack<String[]> failedRequests = new Stack<>();

        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Statistika", "2"});

        Scanner read = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        while (read.hasNext()) {
            String name = read.next();
            String book = read.next();
            requests.add(new String[]{name, book});
        }
        read.close();

        requestQueue.addAll(requests);
        while (!requestQueue.isEmpty()) {
            String[] request = requestQueue.poll();
            String[] stock = null;
            for (String[] book : books) {
                if (book[0].equals(request[1])) {
                    stock = book;
                    break;
                }
            }

            int borrowed = 0;
            for (String[] customer : customers) {
                if (customer[0].equals(request[0])) {
                    borrowed++;
                }
            }

            if (stock != null && Integer.parseInt(stock[1]) > 0 && borrowed < 2) {
                customers.add(request);
                stock[1] = String.valueOf(Integer.parseInt(stock[1]) - 1);
            } else {
                failedRequests.push(request);
            }
        }

        System.out.println("=== Successfully Processed Requests ===");
        for (String[] customer : customers) {
            System.out.println(customer[0] + ": " + customer[1]);
        }

        System.out.println("=== Remaining Book Stock ===");
        for (String[] book : books) {
            System.out.println(book[0] + ": " + book[1]);
        }

        System.out.println("=== Failed Requests ===");
        while (!failedRequests.isEmpty()) {
            String[] failed = failedRequests.pop();
            System.out.println(failed[0] + " " + failed[1]);
        }
    }
}