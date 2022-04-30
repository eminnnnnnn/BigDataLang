package Lab42;

public class Lab42 {
    public static void lab4_2() {
        Calendar calendar = new Calendar(2022);
        Calendar.CalendarInfo calendarInfo = calendar.new CalendarInfo();
        calendarInfo.addHoliday("30 апреля - 3 мая");
        calendarInfo.addHoliday("7 мая - 10 мая");
        System.out.println(calendarInfo);
    }
}
