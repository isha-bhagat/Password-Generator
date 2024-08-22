import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the desired password length:");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Include uppercase letters? (yes/no):");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.println("Include lowercase letters? (yes/no):");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.println("Include digits? (yes/no):");
        boolean includeDigits = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.println("Include special characters? (yes/no):");
        boolean includeSpecialCharacters = scanner.nextLine().equalsIgnoreCase("yes");

        if (!includeUppercase && !includeLowercase && !includeDigits && !includeSpecialCharacters) {
            System.out.println("At least one character set should be selected.");
            return;
        }

        String password = generatePassword(length, includeUppercase, includeLowercase, includeDigits, includeSpecialCharacters);
        System.out.println("Generated Password: " + password);
    }

    private static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeDigits, boolean includeSpecialCharacters) {
        StringBuilder password = new StringBuilder(length);
        SecureRandom random = new SecureRandom();
        String charPool = "";

        if (includeUppercase) {
            charPool += UPPERCASE;
        }
        if (includeLowercase) {
            charPool += LOWERCASE;
        }
        if (includeDigits) {
            charPool += DIGITS;
        }
        if (includeSpecialCharacters) {
            charPool += SPECIAL_CHARACTERS;
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charPool.length());
            password.append(charPool.charAt(randomIndex));
        }

        return password.toString();
    }
}
