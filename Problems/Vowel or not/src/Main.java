
import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        // write your code here
        char chUpper = Character.toUpperCase(ch);
        char[] vowels = {'A', 'I', 'O', 'U', 'E'};
        boolean result = false;
        for (Character vowel :  vowels) {
            if (vowel == chUpper) {
                result = true;
                break;
            }
        }
        return result;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}