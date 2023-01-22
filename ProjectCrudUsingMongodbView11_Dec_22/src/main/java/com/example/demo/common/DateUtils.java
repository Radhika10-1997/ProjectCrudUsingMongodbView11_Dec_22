package com.example.demo.common;


import static java.util.stream.Collectors.toList;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

/**
 * Utility class to process the dates
 * 
 * @author Amarjot Kaur
 * @author Stefan Boddy
 */
@Component
public class DateUtils {

    private static final Predicate<String> NON_SYSTEM_ZONE = candidate -> ((candidate
            .indexOf("/") != -1) && (!candidate.contains("System"))
            && (!candidate.contains("Etc")));

    private static final List<String> timeZoneIds;

    static {
        timeZoneIds = Stream.of(TimeZone.getAvailableIDs())
                .filter(NON_SYSTEM_ZONE)
                .sorted()
                .collect(toList());
    }

    public List<String> getTimeZoneIds() {

        return timeZoneIds;
    }

    public Long getStartDateOfNthWeekAfterDate(DateTime dt, int numOfWeeks) {

        // assuming week starts from Monday=1
        return dt.dayOfWeek()
                .withMinimumValue()
                .withTimeAtStartOfDay()
                .plusWeeks(numOfWeeks)
                .getMillis();
    }

    public Long getEndDateOfNthWeekAfterDate(DateTime dt, int numOfWeeks) {

        // assuming week starts from Monday=1
        return dt.dayOfWeek()
                .withMaximumValue()
                .plusWeeks(numOfWeeks)
                .getMillis();
    }

    public Long getStartDateOfNextMonthForDate(DateTime dt) {

        DateTime monthStartDate = dt.plusMonths(1)
                .dayOfMonth()
                .withMinimumValue();
        return monthStartDate.getMillis();
    }

    public Long getStartDateOfThisMonthForDate(DateTime dt) {

        DateTime monthStartDate = dt.plusMonths(0)
                .dayOfMonth()
                .withMinimumValue();
        return monthStartDate.getMillis();
    }

    public Long getStartDateOfWeekForDate(DateTime dt) {

        DateTime weekStartDate = dt.dayOfWeek()
                .withMinimumValue()
                .withTimeAtStartOfDay();
        return weekStartDate.getMillis();
    }

    public Long getEndDateOfNextNthMonthForDate(DateTime dt, int numOfMonths) {

        DateTime monthEndDate = dt.plusMonths(numOfMonths - 1)
                .dayOfMonth()
                .withMaximumValue();
        return monthEndDate.getMillis();
    }

    public Long getEndDateOfNextNthWeekForDate(DateTime dt, int numOfWeeks) {

        DateTime lastWeekEnd = dt.plusWeeks(numOfWeeks)
                .dayOfWeek()
                .withMaximumValue();
        return lastWeekEnd.getMillis();
    }

    public String getDdMmYyyyDateString(long date, DateTimeZone dateTimeZone) {

        DateTime dt = new DateTime(date, dateTimeZone);
        return dt.toString("dd/MM/yyyy");
    }

    public DateTime getDateTimeFromStringLong(String longDate, DateTimeZone timeZone) {

        return this.getDateTimeFromLong(Long.parseLong(longDate), timeZone);
    }

    public DateTime getDateTimeFromLong(Long longDate, DateTimeZone timeZone) {

        return new DateTime(longDate, timeZone);
    }

    /**
     * Compares the specified {@link DateTime} instance to todays date and
     * returns 0 if the supplied date is the same day as today, a negative
     * number if it is before today and a non-zero positive number if it is
     * after today.
     */
    public int compareDateToToday(DateTime dateIn) {

        DateTime now = DateTime.now();
        if(now.getYear() == dateIn.getYear()) {
            return Integer.compare(dateIn.getDayOfYear(), now.getDayOfYear());
        } else {
            return Integer.compare(dateIn.getYear(), now.getYear());
        }
    }

    /**
     * Compares two DateTime objects to see if they represent some point in time
     * in the same day. The comparison is assumed to take place for two DateTime
     * objects for the same locale and time zone. Returns 0 if the inputs
     * represent points in time in the same day, a negative integer if input 1
     * is before input 2 and a positive non-zero integer if input 1 is after
     * input 2.
     */
    public int compareDays(DateTime date1, DateTime date2) {

        if(date1.getYear() == date2.getYear()) {
            return Integer.compare(date1.getDayOfYear(), date2.getDayOfYear());
        } else {
            return Integer.compare(date1.getYear(), date2.getYear());
        }
    }

    public Long getDurationHours(Long durationMillis) {

        Duration duration = new Duration(durationMillis);
        return duration.getStandardHours();
    }

    public String formatShortTimeForTimeZoneAndLocale(Long utcMillis, DateTimeZone timeZone,
            Locale locale) {

        DateTimeFormatter dateFormat = DateTimeFormat.shortTime()
                .withLocale(locale)
                .withZone(timeZone);
        return dateFormat.print(utcMillis);
    }

    public String formatShortDateForTimeZoneAndLocale(Long utcMillis, DateTimeZone timeZone,
            Locale locale) {

        DateTimeFormatter dateFormat = DateTimeFormat.shortDate()
                .withLocale(locale)
                .withZone(timeZone);
        return dateFormat.print(utcMillis);
    }

    public String formatShortDateTimeForTimeZoneAndLocale(Long utcMillis, DateTimeZone timeZone,
            Locale locale) {

        DateTimeFormatter dateFormat = DateTimeFormat.shortDateTime()
                .withLocale(locale)
                .withZone(timeZone);
        return dateFormat.print(utcMillis);
    }

    /**
     * Gets a "best guess" time zone based on the user's locale, which comes
     * from the language http header in web requests. For the moment we just
     * handle a few we are likely to come across.
     */
    public DateTimeZone guessTimeZoneFromLocale(Locale locale) {

        if(Locale.UK.equals(locale)) {
            return DateTimeZone.forID("Europe/London");
        } else if(Locale.US.equals(locale)) {
            return DateTimeZone.forID("America/New_York"); // Defaulting to East
                                                           // coast (EST)
        } else if(Locale.FRANCE.equals(locale)) {
            return DateTimeZone.forID("Europe/Paris");
        } else if(Locale.forLanguageTag("fi")
                .equals(locale)) {
            return DateTimeZone.forID("Europe/Helsinki");
        } else {
            return DateTimeZone.getDefault();
        }
    }

    public String formatShortTimeForLocale(Long utcMillis, Locale locale) {

        DateTimeFormatter dateFormat = DateTimeFormat.shortTime()
                .withLocale(locale);
        return dateFormat.print(utcMillis);
    }

    public String formatShortDateForLocale(Long utcMillis, Locale locale) {

        DateTimeFormatter dateFormat = DateTimeFormat.shortDate()
                .withLocale(locale);
        return dateFormat.print(utcMillis);
    }

    public String formatShortDateTimeForLocale(Long utcMillis, Locale locale) {

        DateTimeFormatter dateFormat = DateTimeFormat.shortDateTime()
                .withLocale(locale);
        return dateFormat.print(utcMillis);
    }

    public long getDateTimeAsUTCLong(DateTime dateTime) {

        return dateTime.withZone(DateTimeZone.UTC)
                .getMillis();
    }

    public long getDateTimeAsUTCLong(Long dateIn, DateTimeZone timeZoneIn) {

        return new DateTime(dateIn, timeZoneIn).withZone(DateTimeZone.UTC)
                .getMillis();
    }

    public long getDateTimeWithZoneFromUTC(long dateTimeIn, DateTimeZone timeZoneOut) {

        return new DateTime(dateTimeIn, DateTimeZone.UTC).withZone(timeZoneOut)
                .getMillis();
    }

    public Boolean isDateInCurrentWeek(Long date, DateTimeZone timeZone) {

        DateTime currentDate = new DateTime(timeZone);
        Long start = this.getStartDateOfWeekForDate(currentDate);
        Long end = this.getEndDateOfNextNthWeekForDate(currentDate, 0);
        return start.compareTo(date) < 1 && end.compareTo(date) > -1;
    }

    public String formatDateTimeForDate(String format, Long date) {

        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(new Date(date));
    }

    public String formatDateTimeForPlanDate(String format, Long date) {

        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(new DateTime(date));
    }

    /* get Duration in days from actual startDate and actual endDate */
    public Integer getDurationInDaysFromActualDates(DateTime actualStartDate,
            DateTime actualEndDate) {

        return Days.daysBetween(actualStartDate, actualEndDate)
                .getDays();
    }

    public static int getDaysCountBetweenDays(DateTime startDate, DateTime endDate, int day) {

        DateTime thisMonday = startDate.withDayOfWeek(day);
        if(startDate.isAfter(thisMonday)) {
            startDate = thisMonday.plusWeeks(1); // start on next monday
        } else {
            startDate = thisMonday; // start on this monday
        }
        int count = 0;
        while(startDate.isBefore(endDate)) {
            // System.out.println(startDate);
            count++;
            startDate = startDate.plusWeeks(1);
        }
        return count;
    }

    /**
     * @author Shivani Kashyap
     */
    /** convert project date format to simpleDateFormat */
    public String getDateFormatForSimpleDateFormat(String projectDateFormat) {

        String dateFormat;

        if(Objects.isNull(projectDateFormat)) {
            dateFormat = "dd/MM/yyyy";
        } else {

            if(projectDateFormat.equalsIgnoreCase("DD/MM/YY")) {
                dateFormat = "dd/MM/yy";
            } else if(projectDateFormat.equalsIgnoreCase("DD/MM/YYYY")) {
                dateFormat = "dd/MM/yyyy";
            } else if(projectDateFormat.equalsIgnoreCase("DD.MM.YYYY")) {
                dateFormat = "dd.MM.yyyy";
            } else if(projectDateFormat.equalsIgnoreCase("MM/DD/YYYY")) {
                dateFormat = "MM/dd/yyyy";
            } else if(projectDateFormat.equalsIgnoreCase("YYYY/MM/DD")) {
                dateFormat = "yyyy/MM/dd";
            } else if(projectDateFormat.equalsIgnoreCase("YYYY-MM-DD")) {
                dateFormat = "yyyy-MM-dd";
            } else if(projectDateFormat.equalsIgnoreCase("DD-MMM-YY")) {
                dateFormat = "dd-MMM-yy";
            } else if(projectDateFormat.equalsIgnoreCase("DD-MMM-YYYY")) {
                dateFormat = "dd-MMM-yyyy";
            } else {
                dateFormat = "dd/MM/yyyy";
            }
        }
        return dateFormat;
    }

    /** default date format of project */
    public String getDefaultDateFormat() {

        return "DD/MM/YYYY";
    }

    /** get calendar day ordinal from day string */
    public int getDayOrdinalFromDayName(String dayName) {

        switch(dayName.toUpperCase()) {
            case "SUNDAY":
                return Calendar.SUNDAY; /* value: 1 */
            case "MONDAY":
                return Calendar.MONDAY;/* value: 2 */
            case "TUESDAY":
                return Calendar.TUESDAY;/* value: 3 */
            case "WEDNESDAY":
                return Calendar.WEDNESDAY;/* value: 4 */
            case "THURSDAY":
                return Calendar.THURSDAY;/* value: 5 */
            case "FRIDAY":
                return Calendar.FRIDAY;/* value: 6 */
            case "SATURDAY":
                return Calendar.SATURDAY;/* value: 7 */
            default:
                return Calendar.MONDAY;/* value: 2 */

        }

    }

    public Long getUTCTime(Long time) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return this.getDateTimeAsUTCLong(new DateTime().withDate(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)));
    }

    public Long calculateWorkingDateAccordingToDuration(Long date, int duration,
            DateTimeZone projectTimeZone, Set<String> weekOffDay, Set<Long> holidayDates,
            Boolean isEnableNonWorkingCal) {

        if(Objects.nonNull(isEnableNonWorkingCal) && Boolean.TRUE.equals(isEnableNonWorkingCal)) {

            List<Long> timeline = new ArrayList<Long>();

            Long workingDate;
            boolean isNegativeReschedul = false;

            DateTime formatedDate = (new DateTime(date)).withZone(projectTimeZone)
                    .withTimeAtStartOfDay();

            DateTime newDate = formatedDate.plusDays(duration)
                    .withZone(projectTimeZone)
                    .withTimeAtStartOfDay();

            DateTime parsingDate = formatedDate;
            DateTime parsingNewDate = newDate;

            if(parsingDate.isAfter(parsingNewDate)) {
                isNegativeReschedul = true;
                while(parsingDate.isAfter(parsingNewDate) || parsingDate.isEqual(parsingNewDate)) {
                    if(holidayDates.contains(parsingDate.getMillis())
                            || weekOffDay.contains(parsingDate.dayOfWeek()
                                    .getAsText(Locale.ENGLISH)
                                    .toUpperCase()) && !formatedDate.equals(parsingDate)) {

                        parsingNewDate = parsingNewDate.minusDays(1);
                    } else {
                        if(!timeline.contains(parsingDate.getMillis())
                                && !formatedDate.equals(parsingDate)) {
                            timeline.add(parsingDate.withZone(projectTimeZone)
                                    .withTimeAtStartOfDay()
                                    .getMillis());
                        }
                    }
                    parsingDate = parsingDate.minusDays(1)
                            .withZone(projectTimeZone)
                            .withTimeAtStartOfDay();
                }
            } else {
                while(parsingDate.isBefore(parsingNewDate) || parsingDate.isEqual(parsingNewDate)) {
                    if(holidayDates.contains(parsingDate.getMillis())
                            || weekOffDay.contains(parsingDate.dayOfWeek()
                                    .getAsText(Locale.ENGLISH)
                                    .toUpperCase()) && !formatedDate.equals(parsingDate)) {

                        parsingNewDate = parsingNewDate.plusDays(1);
                    } else {
                        if(!timeline.contains(parsingDate.getMillis())
                                && !formatedDate.equals(parsingDate)) {
                            timeline.add(parsingDate.withZone(projectTimeZone)
                                    .withTimeAtStartOfDay()
                                    .getMillis());
                        }
                    }
                    parsingDate = parsingDate.plusDays(1)
                            .withZone(projectTimeZone)
                            .withTimeAtStartOfDay();
                }
            }

            workingDate = newDate.getMillis();

            if(isNegativeReschedul && timeline.size() == Math.abs(duration)) {
                workingDate = timeline.get(timeline.size() - 1);
            }

            if(!isNegativeReschedul && timeline.size() == duration) {
                workingDate = timeline.get(timeline.size() - 1);
            }

            return workingDate;
        } else {
            return new DateTime(date).withZone(projectTimeZone)
                    .plusDays(duration)
                    .withTimeAtStartOfDay()
                    .getMillis();
        }
    }

    public Integer getDateRangeBetweenTwoDatesExcludeHolidayAndWeekOff(Long startDate, Long endDate,
            Set<Long> holidayDate, Set<String> weekOffDay, DateTimeZone projectZone) {

        DateTime dateTime1 = new DateTime(startDate).withZone(projectZone)
                .withTimeAtStartOfDay();
        DateTime dateTime2 = new DateTime(endDate).withZone(projectZone)
                .withTimeAtStartOfDay();

        int dayCount = 0;
        if(startDate.equals(endDate)) {
            DateTimeFormatter fmt = DateTimeFormat.forPattern("EEEE");
            String dayName = fmt.print(dateTime1);

            if(!holidayDate.contains(startDate) && !weekOffDay.contains(dayName.toUpperCase())) {
                dayCount++;
            }

        } else {

            while(dateTime1.isBefore(dateTime2) || dateTime1.equals(dateTime2)) {

                DateTimeFormatter fmt = DateTimeFormat.forPattern("EEEE");
                String dayName = fmt.print(dateTime1);
                if(!holidayDate.contains(dateTime1.getMillis())
                        && !weekOffDay.contains(dayName.toUpperCase())) {
                    dayCount++;
                }

                dateTime1 = dateTime1.plusDays(1);
            }
        }

        return dayCount;

    }

    public Long getEstimatedEndDate(Long actualStartDate, Long startDate, Long endDate,
            DateTimeZone projectZone) {

        DateTime startDateTime = new DateTime(startDate).withZone(projectZone)
                .withTimeAtStartOfDay();
        DateTime endDateTime = new DateTime(endDate).withZone(projectZone)
                .withTimeAtStartOfDay();
        Integer plannedDuration = Days.daysBetween(startDateTime, endDateTime)
                .getDays();
        DateTime actualstartDateTime = new DateTime(actualStartDate).withZone(projectZone)
                .withTimeAtStartOfDay();
        DateTime estimateEndDate = actualstartDateTime.plusDays(plannedDuration);
        return estimateEndDate.getMillis();
    }
}
