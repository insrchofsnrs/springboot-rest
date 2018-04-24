package by.insrch.sdrw.lesson;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        int a = 5;
        a = a++ + ++a;
        System.out.println(a);
    }
}
