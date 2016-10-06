
package zodiacapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dayCalculation {
    
    public static String findDayOfTheWeek(String month, String date, String year) {
        String dob=month+"/"+date+"/"+year;  
        if(Integer.parseInt(year)%4!=0 && month.equals("2") && date.equals("29")){
            return "Invalid Date";   
        }
        else{
            SimpleDateFormat newDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date MyDate = null;
            try {
                MyDate = newDateFormat.parse(dob);
                newDateFormat.applyPattern("EEEE");
                String myDate =newDateFormat.format(MyDate);
                return myDate;
            }
            catch (ParseException ex) {
                Logger.getLogger(ZodiacApp.class.getName()).log(Level.SEVERE, null, ex);
                return "Invalid Date";
            }
        }
    }    
}
