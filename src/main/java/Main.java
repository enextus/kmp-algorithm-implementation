import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the main text: ");
        String text = scanner.nextLine();
        System.out.println("Enter the pattern to be searched: ");
        String pattern = scanner.nextLine();

        KMP kmp = new KMP();
        boolean result = kmp.KMPAlgorithm(text, pattern);

        if(result)
            System.out.println("Pattern found in the text");
        else
            System.out.println("Pattern not found in the text");
    }
}