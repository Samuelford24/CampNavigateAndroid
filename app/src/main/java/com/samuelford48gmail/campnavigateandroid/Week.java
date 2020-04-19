package com.samuelford48gmail.campnavigateandroid;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class Week {
    String week;
    String theme;
    int drawable;

    public Week(String week, String theme, int drawable){
        this.drawable=drawable;
        this.week=week;
        this.theme=theme;
    }

    public String getWeek() {
        return week;
    }

    public String getTheme() {
        return theme;
    }

    public int getDrawable() {
        return drawable;
    }
}
