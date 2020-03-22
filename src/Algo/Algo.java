// Got help from: https://youtu.be/zSsTG3Flo-I

package Algo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Algo {

    private static final int ALPHABET_SIZE = 256;

    /**
     * Build freequency array of a input string
     *
     * @param data - Input String
     * @return
     */
    private static int[] buildFreequencyTable(String data) {
        final int[] freq = new int[ALPHABET_SIZE];
        for (char c : data.toCharArray()) {
            freq[c]++;
        }
        return freq;
    }

    /**
     * Build the huffman tree from freequency array
     *
     * @param freequencyArray
     * @return
     */
    private static Node buildHuffmanTree(int[] freequencyArray) {
        PriorityQueue<Node> nodeQueue = new PriorityQueue<>();

        /**
         * Add nodes to priority queue
         */
        for (char i = 0; i < ALPHABET_SIZE; i++) {
            if (i > 0) {
                Node node = new Node(i, freequencyArray[i], null, null);
                nodeQueue.add(node);
            }
        }

        if(nodeQueue.size() == 1)
        {
            nodeQueue.add(new Node('\0' , 1 , null , null));
        }

        /**
         * Combine smallest nodes to parent
         */
        while (nodeQueue.size() > 1)
        {
            Node left = nodeQueue.poll(); // Left Node
            Node right = nodeQueue.poll(); // Right Node
            Node parentNode = new Node('\0' , left.freequency + right.freequency , left , right);
            nodeQueue.add(parentNode);
        }

        return nodeQueue.poll();
    }




    public static void main(String[] mainInstance) {

        String str = "AAACBBAC";
        int[] fq = buildFreequencyTable(str);
        Node tree = buildHuffmanTree(fq);



    }


}