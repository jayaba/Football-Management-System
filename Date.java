package sample;

public class Date {
    private int Year;
    private int Day;
    private int Month;

    Date(int Year,int Month,int Day){
        this.Year = Year;
        this.Month = Month;
        this.Day = Day;
    }

    public String toString(){
        return this.Year + "/" + this.Month + "/" + this.Day;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }
}
