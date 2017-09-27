package laosiji.tech.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by whyte on 2017/7/2.
 */
public class PatternTest {

//    public static final String LANDLINES_NUMBER = "(?<![\\d])(\\(\\d{3,4}\\)|\\d{3,4}-|\\s)?\\d{7,14}(?!\\d)";

    public static final String PHONE_NUMBER = "(?<![\\d])1[3|4|5|7|8][0-9]{9}(?!\\d)";

    public static final String URL_SIGNATURE = "^http://115r?c?.com/\\?nav=account&child=qsetting&mode=my_set$";

    /**
     * 座机号码或手机号码或400等的正则
     */
//    public static final String PHONE_REGEX = LANDLINES_NUMBER + "|" + PHONE_NUMBER + "|" + "(?<![\\d])\\d{3,4}-\\d{3,4}-\\d{3,4}(?!\\d)";
    public static void main(String[] args) {

        System.out.println(isMatch("*", "21*4124"));

        System.out.println(isMatchPhone("hhh18888888888j"));

        matchWeb("\u0002https:\\/\\/view.inews.qq.com\\/w\\/WXN20170726003179060?refer=nwx&cur_pos=3&_rp=2&bkt=0&openid=o04IBAFCsb4fcozZEWuaviZq1-T4&tbkt=J&groupid=1501038068&msgid=3&from=message&isappinstalled=0\u0003#内涵段子#你就能把一翻翻\u0002http:\\/\\/mp.weixin.qq.com\\/s\\/yP4xT5WaKzYqyfnuzp5ixQ\u0003？我是一个人的话\u0002http:\\/\\/www.psugar.cn\\/abc681c5-52f2-474c-a4ac-c98bce2a913e\\/46672oacdle742fl8de7f7d19a1ec\\/deal\\/3806\\/flkut.html\u0003？我在你心里我的心情图中是有原因");

        System.out.println("sss:" + isMatchUrl("http://115.com/?nav=account&child=qsetting&mode=my_set"));
    }

    public static boolean isMatchUrl(String source) {
        Pattern p = Pattern.compile(URL_SIGNATURE);
        return p.matcher(source).find();
    }

    /**
     * 零宽度负预测先行断言 (?!exp)
     * 零宽度负回顾后发断言 (?\<!exp)
     * 匹配手机号码的前面和后面都不能为数字
     *
     * @param source 传入的文本
     * @return
     */
    public static boolean isMatchPhone(String source) {
        Pattern p = Pattern.compile("(?<![\\d])1[3|4|5|7|8][0-9]{9}(?!\\d)");
        Matcher matcher = p.matcher(source);
        return matcher.find();
    }

    public static void matchWeb(String source) {
        Pattern p = Pattern.compile("\u0002(.*?)\u0003");
        Matcher matcher = p.matcher(source);
        while (matcher.find()) {
            String find = matcher.group(1);
            System.out.println(find);
        }
    }

    public static boolean isMatch(String key, String content) {
        String quote = Pattern.quote(key);
        System.out.println(quote);
        String pattern = ".*" + quote + ".*";
        return Pattern.matches(pattern, content);
    }

}
