package com.example.quizapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button ans1,ans2,ans3;
TextView question,score;

private Question ques=new Question();
private String answer;
private int scored=0;
private int queLenth =ques.Question.length;

Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r=new Random();

        ans1=findViewById(R.id.button);
        ans2=findViewById(R.id.button2);
        ans3=findViewById(R.id.button3);
        question=findViewById(R.id.Question);
        score=findViewById(R.id.score);

        score.setText("Score: "+scored);

        updateQues(r.nextInt(queLenth));


        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans1.getText()==answer){
                    scored++;
                    score.setText("Score: "+scored);
                    updateQues(r.nextInt(queLenth));
                    checkScore(scored);

                }
                else{
                    gameOver(false);
                }
            }
        });
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans2.getText()==answer){
                    scored++;
                    score.setText("Score: "+scored);
                    updateQues(r.nextInt(queLenth));
                    checkScore(scored);
                }
                else{
                    gameOver(false);
                }
            }
        });
        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans3.getText()==answer){
                    scored++;
                    score.setText("Score: "+scored);
                    updateQues(r.nextInt(queLenth));
                    checkScore(scored);
                }
                else{
                    gameOver(false);
                }
            }
        });

    }

    private void gameOver(boolean isfinish) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        String message="Wrong Answer! Play again!";
        if(isfinish){
            message="Congratulations! You have won the game!";
        }
        alertDialog.setMessage( message + " Your Score is "+scored).setCancelable(false).setPositiveButton("New Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        }).setNegativeButton("EXIT",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    finish();
            }
        });

        AlertDialog alertDialog1=alertDialog.create();
        alertDialog1.show();
    }

    private void updateQues(int num){
        question.setText(ques.getQues(num));
        ans1.setText(ques.getChoice(num));
        ans2.setText(ques.getChoice2(num));
        ans3.setText(ques.getChoice3(num));
        answer=ques.getCorrectAns(num);
    }
    private  void checkScore(int num){
        if(num==5){
            gameOver(true);

        }
    }
}
