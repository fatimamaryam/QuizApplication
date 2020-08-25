package com.example.quizapplication;

public class Question {

    public String Question[] ={
            "What is the name of our Prime Minister?",
            "What is our national Language?",
            "What is our national sport?",
            "What is our national animal?",
            "What is our national flower?"
    };



    private String Choices[][]={
            {"Nawaz Shareef","Imran Khan","Bilawal"},
            {"Punjabi","Pashto","Urdu"},
            {"Hockey","Cricket","Qabady"},
            {"Deer","lion","Markhor"},
            {"Jasmine","Motya","Almanda"}
    };
    private String CorrectAns[]={
            "Imran Khan","Urdu","Hockey","Markhor","Jasmine"
    };

    public String getQues(int a){
        String question =Question[a];
        return question;
    }
    public String getChoice(int a) {
        String choice=Choices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice=Choices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice=Choices[a][2];
        return choice;
    }

    public String getCorrectAns(int a) {
        return CorrectAns[a];
    }
}
