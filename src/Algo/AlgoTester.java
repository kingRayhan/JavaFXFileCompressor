package Algo;

public class AlgoTester {
    public static void main(String[] args) {
        String str = "AAABBBDDAEACAADB";

        HuffmanEncoder hf = new HuffmanEncoder();

        HuffmanEncodedResult result = hf.compress(str);

    }
}
