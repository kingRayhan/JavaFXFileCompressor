package FileStream;

import java.io.*;

public class Person implements Serializable  {
    private String name;
    private Integer age;

    Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
