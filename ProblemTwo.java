package ObjectAndClassesExcercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfLines = Integer.parseInt(sc.nextLine());
        Pattern pattern = Pattern.compile("U\\$(?<user>[A-Z]{1}[a-z]{2,})U\\$P@\\$(?<pass>[a-zA-Z]{5,}[0-9]{1,})P@\\$");

        int regsCounter = 0;
        for(int i = 0; i<numOfLines; i++) {
            String text = sc.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                System.out.println("Registration was successful");
                String username = matcher.group("user");
                String password = matcher.group("pass");
                System.out.printf("Username: %s, Password: %s%n", username, password);
                regsCounter++;
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.printf("Successful registrations: %d", regsCounter);
    }
}
