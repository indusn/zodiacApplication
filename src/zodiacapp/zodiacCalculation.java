package zodiacapp;

import static zodiacapp.ZodiacApp.zodiacSigns; 
 
public class zodiacCalculation {
    public static String getHoroscope(int userMonth, int userDate) {
        return getZodiac(userMonth,userDate);//Returns corresponding zodiac
    }
    
    public static String getZodiac(int month, int day){
        if((month == 12) && ( day>= 22) || (month == 01) && (day <= 19)){
            return zodiacSigns[0];
        }
        else if((month == 01) && (day >= 20)  || (month == 02) && (day <= 18)){
            return zodiacSigns[1];
        }
        else if((month == 02) && (day >= 19)  || (month == 03) && (day <= 20)) {
            return zodiacSigns[2];
        } 
        else if((month == 03) && (day >= 21)  || (month == 04) && (day <= 19)) {
            return zodiacSigns[3];
        } 
        else if((month == 04) && (day >= 20)  || (month == 05) && (day <= 20)) {
            return zodiacSigns[4];
        } 
        else if((month == 05) && (day >= 21)  || (month == 06) && (day <= 20)) {
            return zodiacSigns[5];
        } 
        else if((month == 06) && (day >= 21)  || (month == 07) && (day <= 22)) {
            return zodiacSigns[6];
        } 
        else if((month == 07) && (day >= 23)  || (month == 8) && (day <= 22)) {
            return zodiacSigns[7];
        } 
        else if((month == 8) && (day >= 23)  || (month == 9) && (day <= 21)) {
            return zodiacSigns[8];
        } 
        else if((month == 9) && (day >= 22) || (month == 10) && (day <= 21)) {
            return zodiacSigns[9];
        } 
        else if((month == 10) && (day >= 24)  || (month == 11) && (day <= 22)) {
            return zodiacSigns[10];
        } 
        else if((month == 11) && (day >= 23)  || (month == 12) && (day <= 21)) {
            return zodiacSigns[11];  
        } 
        else {
            return null; 
        }      
    }
}