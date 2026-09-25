import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();
        Queue<String[]> transactionQueue = new LinkedList<>();
        Stack<String[]> failedWithdrawals = new Stack<>();

        Scanner read = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        while (read.hasNext()) {
            String name = read.next();
            String type = read.next();
            String amount = read.next();

            transactions.add(new String[]{name, type, amount});

            boolean customerExists = false;
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i)[0].equals(name)) {
                    customerExists = true;
                    break;
                }
            }
            if (!customerExists) {
                customers.add(new String[]{name, "0"});
            }
        }
        read.close();

        transactionQueue.addAll(transactions);

        while (!transactionQueue.isEmpty()){
            String[] transaction = transactionQueue.poll();
            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            for (int i = 0; i < customers.size(); i++){
                String[] customer = customers.get(i);
                if (customer[0].equals(name)){
                    int balance = Integer.parseInt(customer[1]);

                    if (type.equals("DEPOSIT")){
                        customer[1] = String.valueOf(balance + amount);
                    } else if (type.equals("WITHDRAW")){
                        if (amount > balance){
                            failedWithdrawals.push(transaction);
                        } else {
                            customer[1] = String.valueOf(balance - amount);
                        }
                    }
                    break;
                }
            }
        } 
        
        System.out.println("=== Final Balances ===");
        for (int i = 0; i < customers.size(); i++){
            String[] customer = customers.get(i);
            System.out.println(customer[0] + ": " + customer[1]);
        }

        System.out.println("=== Failed Transactions ===");
        while (!failedWithdrawals.isEmpty()) {
            String[] failed = failedWithdrawals.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
        }
    }
}