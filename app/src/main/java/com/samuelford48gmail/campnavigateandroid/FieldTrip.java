package com.samuelford48gmail.campnavigateandroid;

public class FieldTrip {
    String where;
    String day;
    String when;
    String departure;
    String bring;



    FieldTrip(String where, String day, String when, String departure, String bring){
        this.where=where;
        this.day=day;
        this.when=when;
        this.departure=departure;
        this.bring=bring;
    }
    public String getWhere() {
        return where;
    }

    public String getDay() {
        return day;
    }

    public String getWhen() {
        return when;
    }

    public String getDeparture() {
        return departure;
    }

    public String getBring() {
        return bring;
    }
}
