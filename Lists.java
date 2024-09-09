import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lists {

    public static void printList(List<?> mylist)
    {
        for (Object obj : mylist)
        {
            System.out.println(obj);
        }
    }
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
        list.addAll(Arrays.asList("Pico", "PAco","Poco"));

        Map <Integer,List<Integer>> myList = new HashMap<>();
        myList.put(0, Arrays.asList(1,2,3));
        myList.put(1, Arrays.asList(0,2,3,8));
        myList.put(2, Arrays.asList(0,1,4,5,6));
        System.out.println(myList);

        for(Integer i : myList.keySet())
        {
            System.out.println("Key: " + i + " value: "+ myList.get(i));
        }
        
        
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(3));

        list.addAll(2,Arrays.asList("BAng","Boong","Kaboom"));
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(3));

        list.remove(3);
        System.out.println(list);
        System.out.println(list.get(3)); 
    }

    
    
}
