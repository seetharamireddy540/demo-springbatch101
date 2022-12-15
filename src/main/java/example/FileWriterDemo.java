package example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class FileWriterDemo {
    public static void main(String[] args) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
            bufferedWriter.write("Hi hellow world.");
            bufferedWriter.close();

            String name = new  StringBuilder().append("Ram").append(540).append(2.4).toString();


            System.out.println("Name - " + name);
            System.out.println("Name - " + name.length());
            System.out.println("Name - " + name.charAt(2));
            System.out.println("Name - " + name.toLowerCase(Locale.ROOT));
            System.out.println("Name - " + name.toUpperCase(Locale.ROOT));
            System.out.println("GetBytes - " + name.getBytes());
            System.out.println("GetBytes - " + name.getClass());
            System.out.println("Intern - " + name.intern());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
