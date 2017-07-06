package laosiji.tech.regular;

import java.util.regex.Pattern;

/**
 * Created by whyte on 2017/7/2.
 */
public class PatternTest {
    public static void main(String[] args) {

        System.out.println(isMatch("*", "21*4124"));

    }

    public static boolean isMatch(String key, String content) {
        String quote = Pattern.quote(key);
        System.out.println(quote);
        String pattern = ".*" + quote + ".*";
        return Pattern.matches(pattern, content);
    }

}
