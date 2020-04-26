package com.samuelford48gmail.campnavigateandroid;

import java.util.ArrayList;

public class Staff {
    String name;
    String biography;
    String contactInfo;
   int drawable;


    public Staff(String name, String biography, int drawable, String contactInfo){
        this.name=name;
        this.biography=biography;
        this.drawable=drawable;
   this.contactInfo=contactInfo;
    }
    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public int getDrawable() {
        return drawable;
    }

}
