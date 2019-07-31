package test.com.sysware.test;

import java.util.Calendar;
import java.util.Date;

public class TCalendar {

    public static void main(String[] args) {
        long ds=1530633608007l;
        Date d1=new Date(ds);
        System.out.println(d1);
        Date d=new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -3);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        // 分
        cal.set(Calendar.MINUTE, 0);
        // 秒
        cal.set(Calendar.SECOND, 0);
        // 毫秒
        cal.set(Calendar.MILLISECOND, 0);
        
        
      
        Date time2 = cal.getTime();
        System.out.println(time2);
        cal.add(Calendar.DAY_OF_MONTH, 3);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date time3 = cal.getTime();
        System.out.println(time3);
        
      
        System.out.println(time2.before(d)&&time3.after(d));
        System.out.println();
        
        
    }

}
