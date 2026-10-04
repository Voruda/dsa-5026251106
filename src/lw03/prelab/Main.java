import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        problem1();
        problem2();
        problem3();
    }

    static void problem1() throws Exception {
        System.out.println("===== Problem 1 =====");
        List<String> playlist = new ArrayList<>();
        
        Scanner read = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        while (read.hasNextLine()) {
            String line = read.nextLine().trim();
            if (line.isEmpty()) continue;
            
            String[] parts = line.split(" ", 2);
            String cmd = parts[0];
            
            if (cmd.equals("ADD")) {
                playlist.add(parts[1]);
            } else if (cmd.equals("INSERT")) {
                String[] sub = parts[1].split(" ", 2);
                int index = Integer.parseInt(sub[0]);
                playlist.add(index, sub[1]);
            } else if (cmd.equals("REMOVE")) {
                playlist.remove(parts[1]);
            }
        }
        read.close();

        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
    }

    static void problem2() throws Exception {
        System.out.println("\n===== Problem 2 =====");
        Set<String> participants = new LinkedHashSet<>();
        int duplicates = 0;
        
        Scanner read = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        while (read.hasNextLine()) {
            String name = read.nextLine().trim();
            if (name.isEmpty()) continue;
            
            if (!participants.add(name)) {
                duplicates++;
            }
        }
        read.close();

        System.out.println("Unique participants: " + participants.size());
        int rank = 1;
        for (String p : participants) {
            System.out.println(rank + ". " + p);
            rank++;
        }
        System.out.println("Duplicate registrations: " + duplicates);
    }

    static void problem3() throws Exception {
        System.out.println("\n===== Problem 3 =====");
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;
        
        Scanner read = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        while (read.hasNextLine()) {
            String line = read.nextLine().trim();
            if (line.isEmpty()) continue;
            
            String[] parts = line.split(" ");
            String cmd = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (cmd.equals("ADD")) {
                inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
            } else if (cmd.equals("SELL")) {
                int currentStock = inventory.getOrDefault(product, 0);
                if (currentStock >= quantity) {
                    inventory.put(product, currentStock - quantity);
                } else {
                    failedSales++;
                }
            }
        }
        read.close();

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + failedSales);
    }
}