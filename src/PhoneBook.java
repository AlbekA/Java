import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    Map<String, ArrayList<String>> tell= new HashMap<>();


    public PhoneBook() {

    }

    public void add(String name, String phone){
        ArrayList<String> phones = new ArrayList<>();
        phones.add(phone);
        if(!checkUnique(name)){
            tell.get(name).add(phone);
        }
        if(checkUnique(name)){
            tell.put(name, phones);
        }

    }

    public boolean checkUnique(String name) {
        if (!tell.containsKey(name)) return true;
        return false;
    }

    public void get (String name){
        System.out.print(name + " ");
        System.out.println(tell.get(name));

    }

}
