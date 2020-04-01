package FileStream;

import java.io.*;

public class Tester {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        var person = new Person("Rayhan" , 23);


        var in = new ObjectInputStream(new FileInputStream("person.fuck"));
        System.out.println(in.readObject());



    }
}
