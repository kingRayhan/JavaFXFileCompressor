// Got help from: https://youtu.be/zSsTG3Flo-I
//https://youtu.be/zSsTG3Flo-I?t=1623
package Algo;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanEncoder {

    private static final int ALPHABET_SIZE = 256;

    public HuffmanEncodedResult compress(String data) {
        int[] frequency = this.buildFrequencyTable(data);
        Node rootNode = this.buildHuffmanTree(frequency);
        Map<Character, String> lookupTable = this.buildLookupTable(rootNode);

        return new HuffmanEncodedResult(generateEncodedData(data, lookupTable), rootNode);
    }

    public String decompress(final HuffmanEncodedResult result) {
        final StringBuilder resultBuilder = new StringBuilder();
        Node current = result.getRoot();

        int i = 0;
        while (i < result.getEncodedData().length()) {
            while (!current.isLeaf()) {
                char bit = result.getEncodedData().charAt(i);
                if (bit == '1') {
                    current = current.rightChild;
                } else if (bit == '0') {
                    current = current.leftChild;
                } else {
                    throw new IllegalArgumentException("Invalid bit!" + bit);
                }
                i++;
            }
            resultBuilder.append(current.character);
            current = result.getRoot();
        }

        return resultBuilder.toString();
    }

    private String generateEncodedData(String data, Map<Character, String> lookupTable) {
        final StringBuilder builder = new StringBuilder();
        for (final char character : data.toCharArray()) {
            builder.append(lookupTable.get(character));
        }

        return builder.toString();
    }

    /**
     * Build freequency array of a input string
     *
     * @param data - Input String
     * @return
     */
    public int[] buildFrequencyTable(String data) {
        final int[] freq = new int[ALPHABET_SIZE];
        for (char c : data.toCharArray()) {
            freq[c]++;
        }
        return freq;
    }

    /**
     * Build the huffman tree from freequency array
     *
     * @param frequencyArray
     * @return
     */
    public Node buildHuffmanTree(int[] frequencyArray) {
        final PriorityQueue<Node> nodeQueue = new PriorityQueue<>();

        /**
         * Add nodes to priority queue
         */
        for (char i = 0; i < ALPHABET_SIZE; i++) {
            if (frequencyArray[i] > 0) {
                Node node = new Node(i, frequencyArray[i], null, null);
                nodeQueue.add(node);
            }
        }

        if (nodeQueue.size() == 1) {
            nodeQueue.add(new Node('\0', 1, null, null));
        }

        /**
         * Combine smallest nodes to parent
         */
        while (nodeQueue.size() > 1) {
            Node left = nodeQueue.poll(); // Left Node
            Node right = nodeQueue.poll(); // Right Node
            Node parentNode = new Node('\0', left.freequency + right.freequency, left, right);
            nodeQueue.add(parentNode);
        }

        return nodeQueue.poll();
    }

    public Map<Character, String> buildLookupTable(Node root) {
        final Map<Character, String> lookupTable = new HashMap<>();

        buildLookupTableRecursively(root, "", lookupTable);
        return lookupTable;
    }


    private void buildLookupTableRecursively(
            Node node,
            String str,
            Map<Character, String> lookupTable) {
        if (!node.isLeaf()) {
            buildLookupTableRecursively(node.leftChild, str + '0', lookupTable);
            buildLookupTableRecursively(node.rightChild, str + '1', lookupTable);
        } else {
            lookupTable.put(node.character, str);
        }
    }


}