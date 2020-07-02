package com.samuelford48gmail.campnavigateandroid;

public class Announcement  {
    String announcement;
    String timestamp;


    public Announcement(String announcement, String timestamp){
        this.announcement=announcement;
        this.timestamp=timestamp;
    }
    public String getAnnouncement() {
        return announcement;
    }

    public String getTimestamp() {
        return timestamp;
    }


}
