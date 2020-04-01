package Algo;

import java.io.Serializable;

public class HuffmanEncodedResult implements Serializable {
    final Node root;

    public String getEncodedData() {
        return encodedData;
    }

    final String encodedData;

    @Override
    public String toString() {
        return encodedData;
    }


    public HuffmanEncodedResult(String generateEncodedData, Node rootNode) {
        this.root = rootNode;
        this.encodedData = generateEncodedData;
    }

    public Node getRoot() {
        return this.root;
    }
}
