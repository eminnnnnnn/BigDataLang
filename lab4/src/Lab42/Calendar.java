package Lab42;

import java.util.ArrayList;

public class Calendar {
    private int year;

    public Calendar(int year) {
        this.year = year;
    }

    public class CalendarInfo {
        ArrayList<String> holidaysStrings;

        public CalendarInfo() {
            holidaysStrings = new ArrayList<String>();
        }

        public void addHoliday(String dayString) {
            holidaysStrings.add(dayString);
        }

        public ArrayList<String> getHolidaysStrings() {
            return holidaysStrings;
        }

        @Override
        public String toString() {
            return ("Праздничные и выходные дни в " + year + " году: " + holidaysStrings.toString());
        }
    }
}
