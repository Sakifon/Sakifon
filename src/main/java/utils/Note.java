package utils;

public class Note {
    private int id;
    private int user_id;
    private String username;

    private int cours_id;
    private String cours_name;
    private int note1;
    private int note2;
    private int note3;
    private int note4;

    public Note() {
    }

    public Note(int id, int user_id, int cours_id, int note1, int note2, int note3, int note4) {
        this.id = id;
        this.user_id = user_id;
        this.cours_id = cours_id;
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
        this.note4 = note4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCours_id() {
        return cours_id;
    }

    public void setCours_id(int cours_id) {
        this.cours_id = cours_id;
    }

    public String getCours_name() {
        return cours_name;
    }

    public void setCours_name(String cours_name) {
        this.cours_name = cours_name;
    }
    public int getNote1() {
        return note1;
    }

    public void setNote1(int note1) {
        this.note1 = note1;
    }

    public int getNote2() {
        return note2;
    }

    public void setNote2(int note2) {
        this.note2 = note2;
    }

    public int getNote3() {
        return note3;
    }

    public void setNote3(int note3) {
        this.note3 = note3;
    }

    public int getNote4() {
        return note4;
    }

    public void setNote4(int note4) {
        this.note4 = note4;
    }



}