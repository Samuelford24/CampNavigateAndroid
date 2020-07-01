package com.samuelford48gmail.campnavigateandroid;

public class MenuItem { String breakfast;
    String lunch;
    String day;



    MenuItem(String breakfast, String lunch, String day){
        this.breakfast=breakfast;
        this.lunch=lunch;
        this.day=day;

    }
    public String getBreakfast() {
        return breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public String getDay() {
        return day;
    }


}
