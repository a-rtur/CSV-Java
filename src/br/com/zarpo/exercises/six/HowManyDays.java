package br.com.zarpo.exercises.six;
import java.util.*;
import java.text.*;

/**
 *
 * @author Artur
 */
public class HowManyDays {       
    long howManyDays(int subscribeYear, int subscribeMonth, int subscribeDay, int firstVisitYear, int firstVisitMonth, int firstVisitDay) throws ParseException {
        DateFormat df = new SimpleDateFormat ("yyyy/MM/dd");
        df.setLenient(false);
        Date d1 = df.parse (subscribeYear+"/"+subscribeMonth+"/"+subscribeDay);
        Date d2 = df.parse (firstVisitYear+"/"+firstVisitMonth+"/"+firstVisitDay);
        long dt = (d2.getTime() - d1.getTime()) + 3600000;
        long result = (dt / 86400000L);
        return result;
    }
}
