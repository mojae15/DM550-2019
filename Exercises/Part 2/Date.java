public class Date {

    private int year;
    private int month;
    private int date;

    private TimeStamp timestamp;
    private static int largestYear = Integer.MIN_VALUE;

    // Constructors
    public Date(int y, int m, int d) {
        this.year = y;
        this.month = m;
        this.date = d;
        this.timestamp = new TimeStamp();
        if (y > largestYear){
            largestYear = y;
        }
    }

    public Date(int y, int m, int d, TimeStamp ts) {
        this.year = y;
        this.month = m;
        this.date = d;
        this.timestamp = ts;
        if (y > largestYear){
            largestYear = y;
        }
    }

    // Getters and setters
    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDate() {
        return this.date;
    }

    public TimeStamp getTimeStamp() {
        return this.timestamp;
    }

    public void setYear(int y) {
        this.year = y;
        if (y > largestYear){
            largestYear = y;
        }
    }

    public void setMonth(int m) {
        this.month = m;
    }

    public void setDate(int d) {
        this.date = d;
    }

    public void setTimeStamp(TimeStamp ts) {
        this.timestamp = ts.copy();
    }

    private boolean isLeapYear(int year) {

        return ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)));

    }

    private int days(int month, int year) {

        switch (month) {
        case (4):
        case (6):
        case (9):
        case (11):
            return 30;

        default:
            break;
        }

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        if (month == 2) {
            return 28;
        }

        return 31;
    }

    public boolean valid(int year, int month, int day) {

        if (year == 0) {
            return false;
        }

        if ((month < 1) || (month > 12) || (day < 1)) {
            return false;
        }

        if (day > days(month, year)) {
            return false;
        }

        return true;

    }

    public void skipDay() {
        this.date = this.date + 1;
        if (this.date > days(this.month, this.year)) {
            this.date = 1;
            
            skipMonth();

        }
    }

    public void skipMonth() {
        this.month = this.month + 1;

        if (this.month > 12) {
            this.month = 1;
            
            skipYear();
        }

    }

    public void skipYear() {
        this.year = this.year + 1;

        if (this.year == 0) {
            this.year = 1;
        }

        if (this.year > largestYear){
            largestYear = this.year;
        }
    }

    public void skipTime(TimeStamp ts){

        int total = this.timestamp.getHours()*60*60 + this.timestamp.getMinutes() * 60 + this.timestamp.getSeconds() +
                    ts.getHours()*60*60 + ts.getMinutes() * 60 + ts.getSeconds();

        this.timestamp.skip(ts);

        if (total >= 24*60*60){
            skipDay();
        }


    }

    public static int largestYear(){

        return largestYear;

    }

    public boolean equals(Object other) {
        if (!(other instanceof Date)) {
            return false;
        }
        Date otherDate = (Date) other;
        return ((this.year == otherDate.year) && (this.month == otherDate.month) && (this.date == otherDate.date)
                && (this.timestamp.equals(otherDate.timestamp)));

    }

    public int hashCode() {

        return this.year + (this.month * 31) + (this.date * 31 * 31) + (this.timestamp.hashCode() * 31 * 31 * 31);

    }

    public Date copy() {
        return new Date(this.year, this.month, this.date, this.timestamp);
    }

    public String toString() {

        String res = "" + this.date + ".";

        switch (this.month) {

        case (1):
            res = res + "Jan.";
            break;

        case (2):
            res = res + "Feb.";
            break;

        case (3):
            res = res + "Mar.";
            break;

        case (4):
            res = res + "Apr.";
            break;

        case (5):
            res = res + "May.";
            break;

        case (6):
            res = res + "Jun.";
            break;

        case (7):
            res = res + "Jul.";
            break;

        case (8):
            res = res + "Aug.";
            break;

        case (9):
            res = res + "Sep.";
            break;

        case (10):
            res = res + "oct.";
            break;

        case (11):
            res = res + "Nov.";
            break;

        case (12):
            res = res + "Dec.";
            break;

        }

        res = res + this.year + ": " + this.timestamp;
        return res;

    }

    public static void main(String[] args){

        Date d = new Date(2, 3, 4);

        System.out.println(d);

    }

}