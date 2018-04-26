import java.util.Scanner;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String str = ".- | ... .--. .- -.-. . | ... .... --- ..- .-.. -.. | -... . | .--. .-.. .- -.-. . -.. | -... . - .-- . . -. | . .- -.-. .... | . -. -.-. --- -.. . -.. | -.-. .... .- .-. .- -.-. - . .-. .-.-.- | \n" +
                " \n" +
                ".- | * | ... .... --- ..- .-.. -.. | -... . | .--. .-.. .- -.-. . -.. | -... . - .-- . . -. | . .- -.-. .... | .-- --- .-. -.. .-.-.- | \n" +
                " \n" +
                ".-.. .. -. . | -... .-. . .- -.- ... | .. -. | - .... . | .. -. .--. ..- - | ..-" +
                ". .. .-.. . | ... .... --- ..- .-.. -.. | -... . | .-. . .--. .-.. .. -.-. .- - . -.. | .. -. | - .... . | . -. -.-. --- -.. . -.. | ..-. .. .-.. . .-.-.- |";
        try (Scanner parser = new Scanner(str)) {
            Scanner lineParser;
            while (parser.hasNextLine()) {
                lineParser = new Scanner(parser.nextLine());
                while (lineParser.hasNext()) {
                    String next = lineParser.next();
                    if (next.equals("|")) {
                        System.out.print(" ");
                    } else {
                        System.out.print(next);
                    }
                }
                System.out.println();
            }
        }
    }
}
