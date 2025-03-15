import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Judul Film : ");
        String sentence = scanner.nextLine();

        String result = toTitleCase(sentence);

        System.out.println(result);

        scanner.close();
    }

    public static String toTitleCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;
        

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
                titleCase.append(c);
            } else if (nextTitleCase) {
                titleCase.append(Character.toTitleCase(c));
                nextTitleCase = false;
            } else {
                titleCase.append(Character.toLowerCase(c));
            }
        }

        return titleCase.toString();
    }
}