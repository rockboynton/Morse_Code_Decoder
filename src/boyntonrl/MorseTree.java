/*
 * CS2852
 * Spring 2018
 * Lab 7 - Morse Code Decoder
 * Name: Rock Boynton
 * Created: 4/25/2018
 */

package boyntonrl;

/**
 * A binary tree for storing Morse Codes
 * @param <E> Type of date to be stored in the binary tree
 */
public class MorseTree<E>  {

    private static class Node<E> {
        E value;
        Node<E> leftChild;
        Node<E> rightChild;

        Node(E value) {
            this(value, null, null);
        }

        Node(E value, Node<E> leftChild, Node<E> rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        void set(E value) {
            this.value = value;
        }
    }

    private Node<E> root;

    /**
     * Constructor that ensures that the content in the root node is set to null.
     */
    public MorseTree() {
        root = new Node<>(null);
    }

    public void add(E symbol, String code) {
        add(symbol, code, root);
    }

    private void add(E symbol, String code, Node<E> root) throws IllegalArgumentException {
        if (code.length() > 1) {
            if (code.substring(0,1).equals(".")) {
                if (root.leftChild == null) {
                    root.leftChild = new Node<>(null);
                }
                add(symbol, code.substring(1), root.leftChild);
            } else if (code.substring(0,1).equals("-")) {
                if (root.rightChild == null) {
                    root.rightChild = new Node<>(null);
                }
                add(symbol, code.substring(1), root.rightChild);
            } else {
                throw new IllegalArgumentException("not a dot or dash \"" + code + "\"");
            }
        } else {
            if (code.equals(".")) {
                if (root.leftChild == null) {
                    root.leftChild = new Node<>(symbol);
                } else {
                    root.leftChild.set(symbol);
                }
            } else if (code.equals("-")) {
                if (root.rightChild == null) {
                    root.rightChild = new Node<>(symbol);
                } else {
                    root.rightChild.set(symbol);
                }
            } else {
                throw new IllegalArgumentException("not a dot or dash \"" + code + "\"");
            }
        }
    }

    public E decode(String code) throws IllegalArgumentException {
        return decode(code, root);
    }

    private E decode(String code, Node<E> root) throws IllegalArgumentException {
        E symbol;
        if (code.length() > 0) {
            if (code.charAt(0) == '.') {
                symbol = decode(code.substring(1), root.leftChild);
            } else if (code.charAt(0) == '-') {
                symbol = decode(code.substring(1), root.rightChild);
            } else {
                throw new IllegalArgumentException(code);
            }
        } else {
            symbol = root.value;
        }
        return symbol;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node<E> root) {
        String morseTreeStr = "";
        if (root != null) {
            if (root.leftChild != null) {
                morseTreeStr = root.value + "\n" + toString(root.leftChild) + ", " + toString
                        (root.rightChild);
            } else if (root.rightChild != null) {
                morseTreeStr = root.value + "\n" + toString(root.rightChild);
            } else {
                morseTreeStr = "" + root.value;
            }
        }
        return morseTreeStr;
    }

    public String test8() {
        return test8(root);
    }

    private String test8(Node<E> root) {
        return "" + root.rightChild.leftChild.rightChild.rightChild.value;
    }

}
