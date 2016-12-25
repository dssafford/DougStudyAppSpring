package com.doug.converters;

/**
 * Created by doug on 12/25/16.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
    public static void getCurrentTimeUsingDate() {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);
        System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
    }

    public static void getCurrentTimeUsingCalendar() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        System.out.println("Current time of the day using Calendar - 24 hour format: " + formattedDate);
    }

    public static void getCurrentDate() {
        Date date = new Date();
//        String strDateFormat = "mm" + "/" + "dd" + "/" + "yyyy";
        String strDateFormat = "MM-dd-yyyy";

        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);
        System.out.println("Current day using Date : " + formattedDate);
    }
}
