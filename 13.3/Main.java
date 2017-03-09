import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[][] testCases = {
            {"hi this is the magazine text", "anonymus letter text"},
            {"This is the magazine text, hello world it is a simple test not letter text", "letter text"},
            {"This is the magazine text, hello world it is a simple test", "This is the magazine text, hello world it is a simple test"},
            {"This is the magazine text, hello world it is a simple test", "some text"},
            {"short text", "larger text"}
        };
        boolean[] expected = {false, true, true, true, false};
        boolean resutl;
        for (int i = 0; i < expected.length; i++) {
           resutl = canBeWritten(testCases[i][0], testCases[i][1]);
           System.out.printf("Case %d: %b\n", (i+1), (resutl == expected[i]) );
        }
    }

    public static boolean canBeWritten(String magazineText, String letterText) {
        if ( letterText.length() > magazineText.length() ) {
            return false;
        }
        Map<Character, Integer> mapMagazine = extractCharMap(magazineText);
        Map<Character, Integer> mapLetter = extractCharMap(letterText);
        for (Character c : mapLetter.keySet() ) {
            if ( !mapMagazine.containsKey(c) || mapMagazine.get(c) < mapLetter.get(c) ) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> extractCharMap(String text) {
        Map<Character, Integer> resultMap = new HashMap<Character, Integer>();
        for( char c : text.toCharArray() ) {
            if ( c == ' ') continue;
            if ( !resultMap.containsKey(c) ) {
                resultMap.put(c, 0);
            }
            resultMap.put(c, resultMap.get(c) + 1);
        }
        return resultMap;
    }
}
