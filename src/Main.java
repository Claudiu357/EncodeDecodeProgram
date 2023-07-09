import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Character> alphabet = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type 'encode' to encrypt, type 'decode' to decrypt");
        String position = scanner.nextLine();

        System.out.println("Type your message");
        String text = scanner.nextLine();

        System.out.println("Type your shift number");
        int shift = scanner.nextInt();

        if(position.equals("encode")){
            System.out.println("Your encoded text is :" + encrypt(text, shift));
        } else if (position.equals("decode")) {
            System.out.println("Your decoded text is :" + decrypt(text, shift));
        }
    }

    public static StringBuilder encrypt(String planText, int shiftNumber){
        StringBuilder enc = new StringBuilder();
        char[] charText = planText.toCharArray();
        for(char letter : charText){
            if(letter != ' '){
                int position = alphabet.indexOf(letter);
                int newPosition = position + shiftNumber;
                if (newPosition > 25){
                    newPosition = newPosition - 26;
                }
                char newLetter = alphabet.get(newPosition);
                enc.append(newLetter);
            } else {
                enc.append(' ');
            }
        }
        return enc;
    }

    public static StringBuilder decrypt(String planText, int shiftNumber){
        StringBuilder dec = new StringBuilder();
        char[] charText = planText.toCharArray();
        for(char letter : charText){
            if(letter != ' '){
                int position = alphabet.indexOf(letter);
                int newPosition = position - shiftNumber;
                if (newPosition < 0){
                    newPosition = newPosition + 26;
                }
                char newLetter = alphabet.get(newPosition);
                dec.append(newLetter);
            } else {
                dec.append(' ');
            }
        }
        return dec;
    }
}

