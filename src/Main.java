import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String[] arr = {"Стул","Лето","Небо","Пол","Крыша","Стена","Окно","Кружка","Чай","Лето","Солнце","Трава","Лето","Пол","Стол"};

        Map<String, Integer> hm= new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int counter = 0;
            for(int j = 0; j < arr.length; j++) {
                if(arr[i].equals(arr[j])) counter++;
            }
            hm.put(arr[i], counter);
        }
        System.out.println(hm);

        PhoneBook book = new PhoneBook();
        book.add("Иванов", "89889898787");
        book.add("Петров", "57575745343");
        book.add("Петров", "89394242334");
        book.add("Антонов", "89391237034");
        book.add("Сидоров", "896523248989");

        book.get("Петров");

    }








}
