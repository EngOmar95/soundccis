package com.CS.sound_ccis;

public class FeedBack_info {

    String name ;
    String Comment;
    String id ;


    public FeedBack_info() {
    }

    public FeedBack_info(String name, String comment, String id) {
        this.name = name;
      this.Comment = comment;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
