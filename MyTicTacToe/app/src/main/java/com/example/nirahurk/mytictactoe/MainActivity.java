package com.example.nirahurk.mytictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button a1,a2,a3,b1,b2,b3,c1,c2,c3,reset;
    boolean statusFlag= true;
    Button []bArray;
    int turnCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        statusFlag= true;
        a1= (Button)findViewById(R.id.btnA1);
        a2= (Button)findViewById(R.id.btnA2);
        a3= (Button)findViewById(R.id.btnA3);
        b1= (Button)findViewById(R.id.btnB1);
        b2= (Button)findViewById(R.id.btnB2);
        b3= (Button)findViewById(R.id.btnB3);
        c1= (Button)findViewById(R.id.btnC1);
        c2= (Button)findViewById(R.id.btnC2);
        c3= (Button)findViewById(R.id.btnC3);
        reset = (Button)findViewById(R.id.btnRst);
        bArray= new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};
        for(Button b:bArray){
            b.setOnClickListener(this);
        }
        reset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Button b:bArray){
                    b.setClickable(true);
                    b.setBackgroundColor(Color.parseColor("#33b5e5"));
                    b.setText("");
                }
                statusFlag=true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        if(statusFlag){
            btn.setText("X");
        }
        else{
            btn.setText("0");
        }
        btn.setBackgroundColor(Color.LTGRAY);
        btn.setClickable(false);
        statusFlag=!statusFlag;
        turnCount++;
        if (checkforWinner()){
            for(Button b:bArray){
                if(b.isClickable()) {
                    b.setClickable(false);
                    b.setBackgroundColor(Color.LTGRAY);
                }
            }
        }

    }
    private boolean checkforWinner(){
        boolean isWinner= false;
        if(a1.getText()==a2.getText() && a1.getText()==a3.getText() && !a1.isClickable())
            isWinner=true;
        else if(b1.getText()==b2.getText() && b1.getText()==b3.getText() && !b1.isClickable())
            isWinner=true;
        else if(c1.getText()==c2.getText() && c1.getText()==c3.getText() && !c1.isClickable())
            isWinner=true;

        //vertical
        else if(a1.getText()==b1.getText() && a1.getText()==c1.getText() && !a1.isClickable())
            isWinner=true;
        else if(a2.getText()==b2.getText() && a2.getText()==c2.getText() && !a2.isClickable())
            isWinner=true;
        else if(a3.getText()==b3.getText() && a3.getText()==c3.getText() && !a3.isClickable())
            isWinner=true;
        //diagonal
        else if(a1.getText()==b2.getText() && a1.getText()==c3.getText() && !a1.isClickable())
            isWinner=true;
        else if(a3.getText()==b2.getText() && a3.getText()==c1.getText() && !a3.isClickable())
            isWinner=true;
        if(isWinner){
            if(statusFlag){
                toast("0 wins!!");
            }
            else toast("X wins!!");
        }
        else if(turnCount==9){
            toast("Draw");
        }
        return isWinner;
    }
    private void toast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }



}
