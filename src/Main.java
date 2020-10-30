import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*
         *    TASK 1
         */
        List<String> array = new ArrayList<>(Arrays.asList("one","two","three","four","five","six","three","two","seven","two","three","two","six","two","five","two","three","four","nine","two","three","two","three"));
        Set<String> noDubl =new TreeSet<>(array);
        System.out.println("\n------------------------------ TASK 1 ------------------------\n");
        System.out.println("We have array: ");
        showArray(array);
        System.out.println("This is it without duplicates: ");
        showArray(noDubl);
        Map<String, Integer> countWords = new HashMap<>();
        for (String q : array){
            if (!countWords.containsKey(q)){
                countWords.put(q, 1);
                continue;
            }
            countWords.put(q, (countWords.get(q)+1));
        }
        showMap(countWords);
        System.out.println("\n------------------------------ TASK 2 ------------------------\n");


        /*
         *    TASK 2
         */
        PhoneBook ph = new PhoneBook();
        System.out.println("We have a phonebook:");
        showPhoneBook(ph.getPhoneBook());
        ph.add("+45673456000", "NotOurs");
        System.out.println("\nWe have entered the number of Mr. NotOurs in the phone book,  and now is the our phonebook:");
        showPhoneBook(ph.getPhoneBook());
        System.out.println("\nwe are looking for a Сергеев's telephone number: " + ph.get("Сергеев"));
        System.out.println("\nwe are looking for a Потапов's telephone number: " + ph.get("Потапов"));


    }

    private static void showPhoneBook(Map<String, String> phoneBook) {
        for (Map.Entry entry: phoneBook.entrySet()) {
            System.out.println("\t\t\t\t\t\t"+entry);
        }
    }

    private static void showMap(Map<String, Integer> countWords) {
        System.out.println("And at our array we have: ");
        for (Map.Entry entry : countWords.entrySet()){
            System.out.println("\t\t\t\t\t\t"+entry);
        }
    }

    private static void showArray(Collection<String> array) {
        for (String a : array) {
            System.out.print("   " + a);
        }
        System.out.println("\n\n");

    }
// for commit
}
