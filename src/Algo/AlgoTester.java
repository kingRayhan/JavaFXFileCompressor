package Algo;

public class AlgoTester {
    public static void main(String[] args) {
        String str = "AAABBBDDAEACAADB";
        HuffmanEncoder hf = new HuffmanEncoder();

        HuffmanEncodedResult encodedResult = hf.compress(str);
        System.out.println(hf.decompress(encodedResult));
    }
}
