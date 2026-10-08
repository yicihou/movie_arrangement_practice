package cinema.sys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /*
    *日期工具类
     */
    public static Date StringToDate(String datestr) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return sdf.parse(datestr);
    }

    public static String DateToString(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return sdf.format(date);
    }
}
