package ObjectAndClassesExcercise;

import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = "";
        String input = sc.nextLine();
        String[] commandLine;
        while (!input.equals("End")) {
            commandLine = input.split(" ");
            String command = commandLine[0];
            if (command.equals("Add")) {
                text = text + String.format("%s", commandLine[1]);
            }
            if (command.equals("Print")) {
                System.out.println(text);
            }
            if (command.equals("Remove")) {
                text = text.replace(commandLine[1], "");
            }
            if (command.equals("Index")) {
                if (!text.contains(commandLine[1])) {
                    System.out.println("None");
                } else {
                    System.out.println();
                    int index = text.indexOf(commandLine[1]);
                    while (index >= 0) {
                        System.out.print(index + " ");
                        index = text.indexOf(commandLine[1], index + 1);
                    }
                    System.out.println();
                }
            }
            if (command.equals("Upgrade")) {
                for (int i = 0; i < text.length(); i++) {
                    char commandChar = commandLine[1].charAt(0);
                    char current = text.charAt(i);
                    if (current == commandChar) {
                        int val = text.charAt(i);
                        int replace = val+1;
                        char newChar = (char) replace;
                        text = text.replace(commandChar, newChar);
                    }
                }
            }
            input = sc.nextLine();
        }
    }
}

