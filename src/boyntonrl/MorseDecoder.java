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
                System.out.println("Enter a file to assigning Letters to Morse Code: ");
                File morseFile = new File(stdIn.next());
                loadDecoder(morseFile);
                read = true;
            } catch (FileNotFoundException e) {
                System.err.println("File not Found ");
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getLocalizedMessage());
            }
        } while (!read);


        read = false;
        do {
            try {
                System.out.println("Enter an input filename: ");
                File morseFile = new File(stdIn.next());
                System.out.println("Enter an output filename: ");
                File textFile = new File(stdIn.next());
                decodeFile(morseFile, textFile);
                read = true;
            } catch (FileNotFoundException e) {
                System.err.println("something went wrong");
            }
        } while (!read);


    }

    private static void loadDecoder(File file) throws FileNotFoundException {
        try (Scanner fileParser = new Scanner(file)) {
            Scanner lineParser;
            while (fileParser.hasNextLine()) {
                lineParser = new Scanner(fileParser.nextLine());
                morseTree.add(lineParser.next(), lineParser.next());
            }
        }
    }

    private static void decodeFile(File morseFile, File textFile) throws FileNotFoundException {
        try (Scanner parser = new Scanner(morseFile)) {
            Scanner lineParser;
            while (parser.hasNextLine()) {
                lineParser = new Scanner(parser.nextLine());
                while (lineParser.hasNext()) {
                    String next = lineParser.next();
                    if (next.equals("|")) {
                        System.out.print(" ");
                    } else {
                        try {
                            System.out.print(morseTree.decode(next));
                        } catch (IllegalArgumentException iae) {
                            System.err.println("Warning: skipping " + iae.getLocalizedMessage());
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}
