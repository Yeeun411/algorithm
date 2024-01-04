import java.util.Scanner;

public class Solution {

    public static String solution(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }

        char[] chars = string.toCharArray();
        boolean space = true;

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (space) {
                    chars[i] = Character.toUpperCase(chars[i]);
                    space = false;
                } else {
                    chars[i] = Character.toLowerCase(chars[i]);
                }
            } else if (chars[i] == ' ') {
                space = true;
            } else if (Character.isDigit(chars[i])){
                space = false;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a phrase: ");
        String input = scanner.nextLine();

        System.out.println(solution(input));
        scanner.close();
    }
}

