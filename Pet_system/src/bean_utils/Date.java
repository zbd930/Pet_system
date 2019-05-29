package bean_utils;

import java.text.SimpleDateFormat;

public class Date {
    public static java.sql.Timestamp StrTransSqlDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        java.util.Date nowDate;
        java.sql.Timestamp transdate = null;
        try {
            nowDate = simpleDateFormat.parse(date);
            transdate = new java.sql.Timestamp(nowDate.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transdate;
    }
}
