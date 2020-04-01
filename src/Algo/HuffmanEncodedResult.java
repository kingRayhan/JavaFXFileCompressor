package Algo;

import java.io.*;

public class HuffmanEncodedResult implements Serializable {
    final Node root;
    final String encodedData;


    public String getEncodedData() {
        return encodedData;
    }

    public HuffmanEncodedResult(String generateEncodedData, Node rootNode) {
        this.root = rootNode;
        this.encodedData = generateEncodedData;
    }

    public Node getRoot() {
        return this.root;
    }


    @Override
    public String toString() {
        return "HuffmanEncodedResult{" +
                "root=" + root +
                ", encodedData='" + encodedData + '\'' +
                '}';
    }
}
