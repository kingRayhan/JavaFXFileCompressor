package FileStream;

import Algo.HuffmanEncodedResult;
import Algo.HuffmanEncoder;

import java.io.*;

public class Tester {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HuffmanEncoder hf = new HuffmanEncoder();

        HuffmanEncodedResult compressed = hf.compress("sdkjfsdksdkfhasdkj");


        System.out.println(hf.decompress(compressed));


    }
}
