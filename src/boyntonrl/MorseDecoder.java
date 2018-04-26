/*
 * CS2852
 * Spring 2018
 * Lab 7 - Morse Code Decoder
 * Name: Rock Boynton
 * Created: 4/25/2018
 */

package boyntonrl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Read an encoded file and writes the decoded result to an output file.
 */
public class MorseDecoder {

    private static MorseTree<String> morseTree = new MorseTree<>();

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        boolean read = false;
        do {
            try {
                System.out.println("Please enter a text file to load in Morse Code: ");
                File morseFile = new File(stdIn.next());
                loadDecoder(morseFile);
                read = true;
            } catch (FileNotFoundException e) {
                System.err.println("File not Found ");
            }
        } while (!read);
    }

    private static void loadDecoder(File file) throws FileNotFoundException {
        try (Scanner parser = new Scanner(file)) {
            while (parser.hasNextLine()) {
                String[] letters = parser.nextLine().split("\t");
                morseTree.add(letters[0], letters[1]);
            }
        }
    }

    private static void decodeFile(File file) throws FileNotFoundException {
        try (Scanner parser = new Scanner(file)) {
            while (parser.hasNext()) {
                String[] words = parser.next().split(" \\| ");
                for (String word : words) {
                    String[] letters = word.split(" ");
                    for (String letter : letters) {
                        System.out.println(letter);
                    }
                }
            }
        }
    }
}
