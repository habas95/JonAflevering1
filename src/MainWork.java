import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.*;

public class MainWork {
    public static void main(String[] args) {

        ArrayList<Integer> emptyListInt = new ArrayList<>();
        ArrayList<String> emptyListStr = new ArrayList<>();
        Set<String> emptySetStr = new HashSet();

        ArrayList<String> listStr1 = new ArrayList<>(Arrays.asList("hat", "hund", "haj", "hest", "abe", "fugl", "fugl"));
        ArrayList<String> listStr2 = new ArrayList<>(Arrays.asList("kat", "hund", "haj", "gnaver", "fisk", "laks"));
        ArrayList<Integer> listInt = new ArrayList<>(Arrays.asList(4, 3, 4, 1, 7, 6, 5, 6));

        Set<String> setStr = new HashSet();
        Map<String, String> mapStr1 = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            mapStr1.put("'" + i + "'", "'" + i + "'");
        }

        for (String string : listStr1) {
            setStr.add(string);
        }

        System.out.println(totalVowels(listStr2));
        System.out.println(totalVowels(emptyListStr) + "\n");

        System.out.println(countUnique(listInt));
        System.out.println(countUnique(emptyListInt) + "\n");

        System.out.println(minLength(setStr));
        System.out.println(minLength(emptySetStr) + "\n");

        System.out.println(contains3(listStr1));
        System.out.println(contains3(listStr2) + "\n");

    }
    // Opgave 1
    public static int totalVowels(ArrayList<String> list) {
        int totalVowels = 0;
        for (String word : list) {
            for (int i = 0; i < word.length(); i++) {
                switch (word.charAt(i)) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        totalVowels++;
                }
            }
        }
        return (int) totalVowels;

    }

    // opgave 6
    public static int countUnique(List<Integer> list) {
        Set<Integer> numSet = new HashSet<>();
        for (Integer num : list) {
            numSet.add(num);
        }
        return numSet.size();
    }

    // opgave 8
    public static int minLength(Set<String> setStr) {
        int smallestStr = 0;
        String str1;
        int cnt = 0;
        Iterator<String> iterator = setStr.iterator();

        while (iterator.hasNext()) {
            str1 = iterator.next();
            if(cnt == 0) {
                smallestStr = str1.length();
                cnt++;
            }else {
                if (str1.length() < smallestStr)
                smallestStr = str1.length();
            }
        }
        return smallestStr;

    }

    //opgave 12
    public static boolean contains3(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        int amount = 0;
        for (String str : list) {
            amount = 0;
            if (map.containsKey(str)) {
                amount = map.get(str) + 1;
            }
            map.put(str, amount);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 3) {
                return true;
            }
        }
        return false;
    }
}
