package com.CS.sound_ccis;

public class chat_info {

        String text ;
        String time ;
        String chack;

    public chat_info() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getChack() {
        return chack;
    }

    public void setChack(String chack) {
        this.chack = chack;
    }

    public chat_info(String text, String time, String chack) {
        this.text = text;
        this.time = time;
        this.chack = chack;
    }
}
