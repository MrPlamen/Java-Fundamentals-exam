package ObjectAndClassesExcercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> map = new LinkedHashMap<>();
        Map<String, Double> mapClients = new LinkedHashMap<>();

        String input = sc.nextLine();

        while (!input.equals("End")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];
            String name = commandLine[1];
            Double money = Double.parseDouble(commandLine[2]);
            if (command.equals("Deliver")) {
                if (!map.containsKey(name)) {
                    map.put(name, money);
                } else {
                    map.put(name, map.get(name) + money);
                }
            }
            if (command.equals("Return")) {
                if (map.containsKey(name)) {
                    if (map.get(name) >= money) {
                        if (money >= 0) {
                            map.put(name, map.get(name) - money);
                        }
                    }
                }
            }
            if (command.equals("Sell")) {
                if (!mapClients.containsKey(name)) {
                    mapClients.put(name, money);
                } else {
                    mapClients.put(name, mapClients.get(name) + money);
                }
            }
            input = sc.nextLine();
        }
        double totalIncome = 0;
        for (Map.Entry<String, Double> entry : mapClients.entrySet()) {
            System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
            totalIncome += entry.getValue();
        }
        System.out.println("-----------");
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
            }
        }
        System.out.println("-----------");
        System.out.printf("Total Income: %.2f", totalIncome);
    }
}
