package lesson11.phonebook;

import java.util.*;

public class PhoneBook {
    Map<String, List<String>> phoneBook = new TreeMap<>();

    public boolean add(String clientName, String phoneNumber) {
        if (clientName == null) {
            return false;
        }
        List<String> listNumber = phoneBook.get(clientName);

        if (listNumber == null) {
            List<String> list = new ArrayList<>();
            list.add(phoneNumber);
            phoneBook.put(clientName, list);
            return true;
        } else {
            return (listNumber.add(phoneNumber));
        }
    }

    public boolean add(String clientName, List<String> listNumber){
        if (clientName == null) {
            return false;
        }

        return phoneBook.get(clientName).addAll(listNumber);
    }

    public List<String> get(String clientName) throws Exception {
        if (clientName == null || !phoneBook.containsKey(clientName)) {
            throw new Exception("Несуществующий контакт");
//            return new ArrayList<>();
        }

        return phoneBook.get(clientName);
    }

}
