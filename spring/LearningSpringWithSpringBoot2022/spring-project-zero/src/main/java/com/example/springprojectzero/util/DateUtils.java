package com.example.springprojectzero.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Format the Date in String format into Date format
 */
public class DateUtils {
    public static Date createDateFromDateString(String dateString){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        if (StringUtils.hasText(dateString)) {
            try {
                date = format.parse(dateString);
            } catch (ParseException e) {
                date = new Date(); // means, today if we dont pass any date
            }
        } else
            date = new Date();      // means, today if we dont pass any date
        return date;
    }
}
