import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map <String, Integer> enrollmentMap = new LinkedHashMap<>();
        List<String> checkResults = new ArrayList<>();

        int rejectedOperations = 0;

        while (read.hasNextLine()) {
            String line = read.nextLine();
            String type = line.substring(0, line.indexOf(" "));
            String details = line.substring(line.indexOf(" ") + 1);

            if (type.equals("REGISTER")){
                String code = details.substring(0, details.indexOf(" "));
                int count = Integer.parseInt(details.substring(details.indexOf(" ") + 1));

                if (count <= 0){
                    rejectedOperations++;
                } else {
                    if (enrollmentMap.containsKey(code)){
                        int currentCount = enrollmentMap.get(code);
                        enrollmentMap.put(code, currentCount + count);
                    } else {
                        enrollmentMap.put(code, count);
                    }
                }
            }
            else if (type.equals("WITHDRAW")){
                String code = details.substring(0, details.indexOf(" "));
                int count = Integer.parseInt(details.substring(details.indexOf(" ") + 1));

                if (count <= 0){
                    rejectedOperations++;
                } else {
                    if (enrollmentMap.containsKey(code) && enrollmentMap.get(code) >= count){
                        int currentCount = enrollmentMap.get(code);
                        enrollmentMap.put(code, currentCount - count);
                    } else {
                        rejectedOperations++;
                    }
                }
            }
            else if (type.equals("CHECK")){
                String code = details;
                if (enrollmentMap.containsKey(code)){
                    checkResults.add(code + ": " + enrollmentMap.get(code) + " students");
                } else {
                    checkResults.add(code + ": Not Found");
                }
            }

            System.out.println("===== Enrollment Checks =====");
            for (String check : checkResults){
                System.out.println(check);
            }

            System.out.println("===== Final Enrollment =====");
            for (String enrollment : enrollmentMap.keySet()){
                System.out.println(enrollment + ": " + enrollmentMap.get(enrollment) + " students");
            }

            System.out.println("Rejected Operations: " + rejectedOperations);
        }
    }
}