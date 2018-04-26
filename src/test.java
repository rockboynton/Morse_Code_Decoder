import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String str = "A\t.-";
        String[] words = str.split("\t");
        System.out.println(str);
        for (String word : words) {
            System.out.println(word);
        }
        String str2 = "-..-.";
        System.out.println(str2.matches("[.-]{1,5}"));
//        String[] words = str.split(" \\| ");
//        for (String word : words) {
//            System.out.println(word);
//        }
//        for (String word : words) {
//            String[] letters = word.split(Pattern.quote(" "));
//            for (String letter : letters) {
//                System.out.println(letter);
//            }
//        }
    }
}
