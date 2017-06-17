import java.util.*;

public class Diego {

    public static void main(String ... args) {
        String[] words = {"alan", "nala", "ana", "aan", "foo","casa","saca","asa","caas"};
        System.out.println(anagrams(words));
    }

    private static List<List<String>> anagrams(String[] words) {
        List<List<String>> anagrams = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String,List<String>>();

        for (String word : words) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            List<String> list = map.containsKey(sorted) ? list = map.get(sorted) : new ArrayList<String>();
            list.add(word);
            map.put(sorted, list);
        }

        for (String key: map.keySet())
            anagrams.add(map.get(key));

        return anagrams;
    }
}
