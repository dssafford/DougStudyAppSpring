package com.doug.converters;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by doug on 12/25/16.
 */
public class DateTimeTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetCurrentTimeUsingDate() throws Exception {
        DateTime.getCurrentTimeUsingDate();

    }

    @Test
    public void testGetCurrentTimeUsingCalendar() throws Exception {
        DateTime.getCurrentTimeUsingCalendar();
    }

    @Test
    public void testGetDate() throws Exception {
        DateTime.getCurrentDate();
    }

    @Test
    public void testCompareDates() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date date1 = sdf.parse("12-31-2019");
        Date date2 = sdf.parse("01-31-2010");

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        if (date1.compareTo(date2) > 0) {
            System.out.println("Date1 is after Date2");
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Date1 is before Date2");
        } else if (date1.compareTo(date2) == 0) {
            System.out.println("Date1 is equal to Date2");
        } else {
            System.out.println("How to get here?");
        }

    }

    @Test
    public void testDateBeforeAfter() throws Exception{

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date date1 = sdf.parse("12-31-2009");
        Date date2 = sdf.parse("01-31-2010");

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        if (date1.after(date2)) {
            System.out.println("Date1 is after Date2");
        }

        if (date1.before(date2)) {
            System.out.println("Date1 is before Date2");
        }

        if (date1.equals(date2)) {
            System.out.println("Date1 is equal Date2");
        }
    }

    @Test
    public void testSettingDateWithLocalDateTime() throws Exception {

        LocalDateTime rightNow = LocalDateTime.now();
        LocalDateTime date2 = rightNow.withDayOfMonth(10).withYear(2012).withDayOfYear(01);

        System.out.println("date=" + date2.getMonthValue() + "/" + date2.getDayOfMonth() + "/" + date2.getYear());
    }


    @Test
    public void testSettingDateWithCalendar() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy");

        Calendar calendar = new GregorianCalendar(2016,11,28,13,24,56);
        System.out.println("#1. " + sdf.format(calendar.getTime()));

//update a date
        calendar.set(Calendar.YEAR, 2018);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.MINUTE, 33);

        System.out.println("#2. " + sdf.format(calendar.getTime()));
    }

    @Test
    public void testSettingDateWithDate() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "22-01-2015 10:20:56";
        Date date = sdf.parse(dateInString);

        System.out.println(date);
    }


}