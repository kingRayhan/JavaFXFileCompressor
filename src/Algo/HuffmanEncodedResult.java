package Algo;

public class HuffmanEncodedResult {
    final Node root;

    public String getEncodedData() {
        return encodedData;
    }

    final String encodedData;

    @Override
    public String toString() {
        return "HuffmanEncodedResult{" +
                "root=" + root +
                ", encodedData='" + encodedData + '\'' +
                '}';
    }


    public HuffmanEncodedResult(String generateEncodedData, Node rootNode) {
        this.root = rootNode;
        this.encodedData = generateEncodedData;
    }

    public Node getRoot() {
        return this.root;
    }
}
