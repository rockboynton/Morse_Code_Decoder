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
        char[] chars = code.toCharArray();
        Node<E> currentNode = root;
        for (char character : chars) {
            if (character == '.') {
                if (currentNode.leftChild == null) {
                    currentNode.leftChild = new Node<>(null);
                }
                currentNode = currentNode.leftChild;
            } else if (character == '-') {
                if (currentNode.rightChild == null) {
                    currentNode.rightChild = new Node<>(null);
                }
                currentNode = currentNode.rightChild;
            }
        }
        currentNode.set(symbol);
    }

    public E decode(String code) {
        return decode(code, root);
    }

    private E decode(String code, Node<E> root) {
        E symbol;
        if (code.length() > 1) {
            if (code.charAt(0) == '.') {
                symbol = decode(code.substring(1), root.leftChild);
            } else if (code.charAt(0) == '-') {
                symbol = decode(code.substring(1), root.rightChild);
            } else {
                throw new IllegalArgumentException(code + " contains characters other than . or -");
            }
        } else {
            symbol = root.value;
        }
        return symbol;
    }

}
