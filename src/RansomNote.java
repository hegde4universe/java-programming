import java.util.HashMap;
import java.util.Map;

public class RansomNote {

   /* Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
    Each letter in magazine can only be used once in ransomNote.
    Example1
    Input: ransomNote = "aa", magazine = "ab"
    Output: false

    Example 2:

    Input: ransomNote = "image", magazine = "magazine"   Output: true
    Input: ransomNote = "imagine", magazine = "magazine"   Output: false (i cannot be used twice)

    */

    public static void main(String[] args) {

        System.out.println(isConstructable("aa", "aab"));
        System.out.println(isConstructable("aa", "ab"));
        System.out.println(isConstructable("imagine", "magazine"));
    }

    private static boolean isConstructable(String ransomNote, String magazine) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!countMap.containsKey(c) || countMap.get(c) <= 0) {
                return false;
            }
            countMap.put(c, countMap.get(c) - 1);
        }
        return true;
    }
}
