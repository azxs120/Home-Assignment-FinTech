package com.af.dateparser;



import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tester {

    @Test
    public void test() {
        Parser parser = new Parser();
        Calendar calendar = Calendar.getInstance();

        List<DateGroup> parsed = parser.parse("1/1/2021");
        Date date = parsed.get(0).getDates().get(0);
        calendar.setTime(date);
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(1 - 1, calendar.get(Calendar.MONTH));
        assertEquals(2021, calendar.get(Calendar.YEAR));

        parsed = parser.parse("1-1-2021");
        date = parsed.get(0).getDates().get(0);
        calendar.setTime(date);
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(1 - 1, calendar.get(Calendar.MONTH));
        assertEquals(2021, calendar.get(Calendar.YEAR));

        parsed = parser.parse("The day after 2021/10/4");
        date = parsed.get(0).getDates().get(0);
        calendar.setTime(date);
        assertEquals(5, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(10 - 1, calendar.get(Calendar.MONTH));
        assertEquals(2021, calendar.get(Calendar.YEAR));

        parsed = parser.parse("2021/11/12");
        date = parsed.get(0).getDates().get(0);
        System.out.println(date);
    }

}
