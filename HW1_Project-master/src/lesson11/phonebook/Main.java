package lesson11.phonebook;

import java.util.HashMap;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "89233445665");
        phoneBook.add("Иванов", "89232345675");
        phoneBook.add("Петров", "89131133455");
        phoneBook.add("Андреев", "89600030304");
        phoneBook.add("Иванов", "89232345676");

        try {
            System.out.println("Иванов: " + phoneBook.get("Иванов").toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            System.out.println("Иванов1: " + phoneBook.get("Иванов1").toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }


        List<String> testNumbers = List.of("89992345454", "89603334223", "1234456578", "098765432");
        phoneBook.add("Андреев", testNumbers);
        try {
            System.out.println("Андреев: " + phoneBook.get("Андреев").toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
