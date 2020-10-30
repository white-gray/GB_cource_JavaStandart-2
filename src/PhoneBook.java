import java.util.*;

public class PhoneBook {

    private Map <String, String> phoneBook = new TreeMap<>();
    private List<String> names = new ArrayList<>(Arrays.asList("Галькина","Потапов","Сергеев","Никол","Горек","Машаненашева","Бобдилов","Сергеев","Сергеев","Сашева","Колянкин"));
    private List<String> phoneNumber = new ArrayList<>(Arrays.asList("+74333452345", "+7466282345", "+73333333333", "+74637552345", "+74578452345", "+74653452345", "+7463455345", "+72222222222", "+71111111111", "+70003452345", "+71234452345"));

    public PhoneBook() {
        makeMap();
    }

    public Map<String, String> getPhoneBook() {
        return phoneBook;
    }

    public Set<String> get (String family){
        Set <String> familyPhone = new HashSet<>();
        for (Map.Entry entry: phoneBook.entrySet()) {
            if (entry.getValue()==family){
                familyPhone.add((String) entry.getKey());
            }
        }
        return familyPhone;
    }


    public void add(String phone, String name) {
        phoneBook.put(phone, name);
    }



    private void makeMap() {
        Iterator<String> i = names.iterator();
        Iterator<String> j = phoneNumber.iterator();
        while (i.hasNext() && j.hasNext()) {
            phoneBook.put(j.next(), i.next());
        }

    }

}
