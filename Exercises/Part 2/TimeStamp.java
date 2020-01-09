
public class TimeStamp{

    //Class attributes
    private int hours;
    private int minutes;
    private int seconds;

    //Constructors
    public TimeStamp(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public TimeStamp(int h){
        this.hours = h;
        this.minutes = 0;
        this.seconds = 0;
    }

    public TimeStamp(int h, int m){
        this.hours = h;
        this.minutes = m;
        this.seconds = 0;
    }

    public TimeStamp(int h, int m, int s){
        this.hours = h;
        this.minutes = m;
        this.seconds = s;
    }

    //Getters
    public int getHours(){
        return this.hours;
    }

    public int getMinutes(){
        return this.minutes;
    }

    public int getSeconds(){
        return this.seconds;
    }

    //Setters
    public void setHours(int h){
        this.hours = h;
    }

    public void setMinutes(int m){
        this.minutes = m;
    }

    public void setSeconds(int s){
        this.seconds = s;
    }

    public static boolean valid(int h, int m, int s){
        return (((0 <= h) && (h <= 23)) && ((0 <= m) && (m <= 59)) && ((0 <= s) && (s <= 59)));
    }

    public void skipSecond(){
        this.seconds++;
        if (this.seconds >= 60){
            this.seconds = 0;
            skipMinute();
        }
    }

    public void skipMinute(){
        this.minutes++;
        if (this.minutes >= 60){
            this.minutes = 0;
            skipHour();
        }
    }
    
    public void skipHour(){
        this.hours = (this.hours + 1) % 24;
    }

    public void skip(TimeStamp ts){

        this.seconds = this.seconds + ts.seconds;
        this.minutes = this.minutes + ts.minutes;
        this.hours = this.hours + ts.hours;

        //Fix result
        this.minutes = this.minutes + (this.seconds/60);
        this.seconds = this.seconds%60;
        this.hours = (this.hours + this.minutes/60)%24;
        this.minutes = this.minutes%60;
        
    }

    public boolean equals(Object other){
        if (!(other instanceof TimeStamp)){
            return false;
        }
        TimeStamp ts = (TimeStamp) other;
        //Could probably also use the hashcode?
        return ((this.hours == ts.hours) && (this.minutes == ts.minutes) && (this.seconds == ts.seconds));

    }

    public int hashCode(){
        return this.hours + (this.minutes*31) + (this.seconds*31*31);
    }

    public TimeStamp copy(){

        return new TimeStamp(this.hours, this.minutes, this.seconds);

    }

    public String toString(){
        String res = ""+this.hours+":";

        //If minutes are lower than 10, we want a "0" in front of it
        if (this.minutes < 10){
            res = res + "0"+this.minutes;
        } else {
            res = res + this.minutes;
        }

        res = res + ":";

        //If seconds are lower than 10, we want a "0" in front of it
        if (this.seconds < 10){
            res = res + "0"+this.seconds;
        } else {
            res = res + this.seconds;
        }
        return res;
    }


}