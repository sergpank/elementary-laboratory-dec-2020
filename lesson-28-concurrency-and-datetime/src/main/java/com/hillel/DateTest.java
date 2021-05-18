package com.hillel;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateTest
{
    public static void main(String[] args)
    {
//        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        final long time = new Date().getTime();
//
//        long days = Long.MAX_VALUE / 1000 / 60 / 60 / 24 / 365;
//
//        System.out.println("days in Date = " + days);
//        System.out.println(new Date(Long.MAX_VALUE));
//        System.out.println(df.format(new Date(Long.MAX_VALUE)));
//        System.out.println("Current date = " + new Date());
//        System.out.println("Current date = " + df.format(new Date()));

        final LocalDateTime odessa = LocalDateTime.now();
        final LocalDateTime tokyo = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        final LocalDateTime singapore = LocalDateTime.now(ZoneId.of("Asia/Singapore"));

        System.out.println("Odessa : " + odessa);
        System.out.println("Tokyo  : " + tokyo);
        System.out.println("Singa  : " + singapore);

        final Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, Calendar.SEPTEMBER);
        c.get(Calendar.YEAR);


    }
}
