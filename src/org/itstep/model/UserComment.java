package org.itstep.model;

//Покупка
public class UserComment {
    private String date;
    private int user_id;
    private int comment_id;

    public UserComment(String date, int user_id, int comment_id) {
        this.date = date;
        this.user_id = user_id;
        this.comment_id = comment_id;
    }

    public String getDate() {
        return date;
    }


    public int getUser_id() {
        return user_id;
    }

    public int getComment_id() {
        return comment_id;
    }
}
