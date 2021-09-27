package com.CS.sound_ccis;

public class Mang_Info {
     String id_Question;
     String Question;
     String Answer;
     String Keyword;
    String Keyword_2;
    String Keyword_3;

    public Mang_Info() {
    }

    public Mang_Info(String id_Question, String question, String answer, String keyword, String keyword_2, String keyword_3) {
        this.id_Question = id_Question;
        Question = question;
        Answer = answer;
        Keyword = keyword;
        Keyword_2 = keyword_2;
        Keyword_3 = keyword_3;
    }

    public Mang_Info(String id_Question, String question, String answer, String keyword) {
        this.id_Question = id_Question;
        Question = question;
        Answer = answer;
        Keyword = keyword;
    }

    public String getKeyword_2() {
        return Keyword_2;
    }

    public void setKeyword_2(String keyword_2) {
        Keyword_2 = keyword_2;
    }

    public String getKeyword_3() {
        return Keyword_3;
    }

    public void setKeyword_3(String keyword_3) {
        Keyword_3 = keyword_3;
    }

    public String getId_Question() {
        return id_Question;
    }

    public void setId_Question(String id_Question) {
        this.id_Question = id_Question;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String getKeyword() {
        return Keyword;
    }

    public void setKeyword(String keyword) {
        Keyword = keyword;
    }
}
