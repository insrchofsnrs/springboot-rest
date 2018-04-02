package by.insrch.sdrw.lesson;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

    try {
        FileReader reader = new FileReader("/home/milk/Downloads/words.txt");
        FileWriter writer = new FileWriter("/home/milk/Downloads/words2.txt");
        String text = "";
        writer.write(text);
        int c;
        while((c=reader.read())!=-1){


            writer.append((char)c);
            writer.flush();
        }

    } catch (IOException e){

        System.out.println(e.getMessage());
    }
    }
}
