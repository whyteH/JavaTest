package laosiji.tech.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

/**
 * Created by Whyte on 2017/7/7.
 */
public class DateTest {

    public static void main(String[] args) {

        System.out.println(isToDay(new Date().getTime()));

        //加一天
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        System.out.print(isToDay(calendar.getTimeInMillis()));
    }

    public static boolean isToDay(long time) {
        long now = System.currentTimeMillis();
        SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM");
        //先判断年月是否相等，再判断天
        return temp.format(new Date(time)).equals(temp.format(new Date(now))) && (getDay(now) == getDay(time));
    }

    /**
     * 获取对应是哪天
     *
     * @param time
     * @return
     */
    private static int getDay(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        Formatter ft = new Formatter(Locale.CHINA);
        String dayStr = ft.format("%1$td", calendar).toString();//取天数并格式化
        return Integer.parseInt(dayStr);
    }
}
