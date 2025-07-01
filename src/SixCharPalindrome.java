import java.util.ArrayList;
import java.util.List;

public class SixCharPalindrome {
    public static List<String> findSixCharPalindrome (List<String> input) {
        List<String> result = new ArrayList<>();
        for(String element : input) {
            if(isSixCharPalindrome(element)) {
                result.add(element);
            }
        }

        return result;
    }

    private static boolean isSixCharPalindrome(String element) {
        if(element.length() != 6) {
            return false;
        }

        return element.charAt(0) == element.charAt(5) &&
                element.charAt(1) == element.charAt(4) &&
                element.charAt(2) == element.charAt(3);
    }
}
