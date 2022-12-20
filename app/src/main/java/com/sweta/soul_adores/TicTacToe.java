package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TicTacToe extends AppCompatActivity implements View.OnClickListener {
    int chance=0;
    int roundcount=0;
    String s= "❌";
    String t="🟢";
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        btn1=(Button)findViewById(R.id.B00);
        btn2=(Button)findViewById(R.id.B01);
        btn3=(Button)findViewById(R.id.B02);
        btn4=(Button)findViewById(R.id.B10);
        btn5=(Button)findViewById(R.id.B11);
        btn6=(Button)findViewById(R.id.B12);
        btn7=(Button)findViewById(R.id.B20);
        btn8=(Button)findViewById(R.id.B21);
        btn9=(Button)findViewById(R.id.B22);
        reset=(Button)findViewById(R.id.reset);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        reset.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.B00:
                if(btn1.getText().toString().equals("")){
                    if(chance==0){
                        chance=1;
                        btn1.setText(t);
                        roundcount++;
                        result();
                    }
                    else{
                        chance=0;
                        btn1.setText(s);
                        roundcount++;
                        result();
                    }
                }
                break;
            case R.id.B01:
                if(btn2.getText().toString().equals("")){
                    if(chance==0){
                        chance=1;
                        btn2.setText(t);
                        roundcount++;
                        result();
                    }
                    else{
                        chance=0;
                        btn2.setText(s);
                        roundcount++;
                        result();
                    }
                }
                break;
            case R.id.B02:
                if(btn3.getText().toString().equals("")){
                    if(chance==0){
                        chance=1;
                        btn3.setText(t);
                        roundcount++;
                        result();
                    }
                    else{
                        chance=0;
                        btn3.setText(s);
                        roundcount++;
                        result();
                    }
                }
                break;
            case R.id.B10:
                if(btn4.getText().toString().equals("")){
                    if(chance==0){
                        chance=1;
                        btn4.setText(t);
                        roundcount++;
                        result();
                    }
                    else{
                        chance=0;
                        btn4.setText(s);
                        roundcount++;
                        result();
                    }
                }
                break;
            case R.id.B11:
                if(btn5.getText().toString().equals("")){
                    if(chance==0){
                        chance=1;
                        btn5.setText(t);
                        roundcount++;
                        result();
                    }
                    else{
                        chance=0;
                        btn5.setText(s);
                        roundcount++;
                        result();
                    }
                }
                break;
            case R.id.B12:
                if(btn6.getText().toString().equals("")){
                    if(chance==0){
                        chance=1;
                        btn6.setText(t);
                        roundcount++;
                        result();
                    }
                    else{
                        chance=0;
                        btn6.setText(s);
                        roundcount++;
                        result();
                    }
                }
                break;
            case R.id.B20:
                if(btn7.getText().toString().equals("")){
                    if(chance==0){
                        chance=1;
                        btn7.setText(t);
                        roundcount++;
                        result();
                    }
                    else{
                        chance=0;
                        btn7.setText(s);
                        roundcount++;
                        result();
                    }
                }
                break;
            case R.id.B21:
                if(btn8.getText().toString().equals("")){
                    if(chance==0){
                        chance=1;
                        btn8.setText(t);
                        roundcount++;
                        result();
                    }
                    else{
                        chance=0;
                        btn8.setText(s);
                        roundcount++;
                        result();
                    }
                }
                break;
            case R.id.B22:
                if(btn9.getText().toString().equals("")){
                    if(chance==0){
                        chance=1;
                        btn9.setText(t);
                        roundcount++;
                        result();
                    }
                    else{
                        chance=0;
                        btn9.setText(s);
                        roundcount++;
                        result();
                    }
                }
                break;

            case R.id.reset:
                roundcount=0;
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
        }
    }
    public void result(){
        if(btn1.getText().toString().equals(s) && btn2.getText().toString().equals(s) && btn3.getText().toString().equals(s)){
            Toast.makeText(this, "Player X wins", Toast.LENGTH_LONG).show();

            reset.callOnClick();
        }
        else if(btn4.getText().toString().equals(s) && btn5.getText().toString().equals(s) && btn6.getText().toString().equals(s)){
            Toast.makeText(this, "Player X wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else if(btn7.getText().toString().equals(s) && btn8.getText().toString().equals(s) && btn9.getText().toString().equals(s)){
            Toast.makeText(this, "Player X wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else if(btn1.getText().toString().equals(t) && btn2.getText().toString().equals(t) && btn3.getText().toString().equals(t)){
            Toast.makeText(this, "Player O wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else if(btn4.getText().toString().equals(t) && btn5.getText().toString().equals(t) && btn6.getText().toString().equals(t)){
            Toast.makeText(this, "Player O wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else if(btn7.getText().toString().equals(t) && btn8.getText().toString().equals(t) && btn9.getText().toString().equals(t)){
            Toast.makeText(this, "Player O wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else  if(btn1.getText().toString().equals(s) && btn4.getText().toString().equals(s) && btn7.getText().toString().equals(s)){
            Toast.makeText(this, "Player X wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else if(btn2.getText().toString().equals(s) && btn5.getText().toString().equals(s) && btn8.getText().toString().equals(s)){
            Toast.makeText(this, "Player X wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else if(btn3.getText().toString().equals(s) && btn6.getText().toString().equals(s) && btn9.getText().toString().equals(s)){
            Toast.makeText(this, "Player X wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else if(btn1.getText().toString().equals(t) && btn4.getText().toString().equals(t) && btn7.getText().toString().equals(t)){
            Toast.makeText(this, "Player O wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else if(btn2.getText().toString().equals(t) && btn5.getText().toString().equals(t) && btn8.getText().toString().equals(t)){
            Toast.makeText(this, "Player O wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else if(btn3.getText().toString().equals(t) && btn6.getText().toString().equals(t) && btn9.getText().toString().equals(t)){
            Toast.makeText(this, "Player O wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }

        else if(btn1.getText().toString().equals(s) && btn5.getText().toString().equals(s) && btn9.getText().toString().equals(s)){
            Toast.makeText(this, "Player X wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else if(btn3.getText().toString().equals(s) && btn5.getText().toString().equals(s) && btn7.getText().toString().equals(s)){
            Toast.makeText(this, "Player X wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else if(btn1.getText().toString().equals(t) && btn5.getText().toString().equals(t) && btn9.getText().toString().equals(t)){
            Toast.makeText(this, "Player O wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else if(btn3.getText().toString().equals(t) && btn5.getText().toString().equals(t) && btn7.getText().toString().equals(t)){
            Toast.makeText(this, "Player O wins", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }
        else if(roundcount==9) {
            Toast.makeText(this, "It's Draw", Toast.LENGTH_SHORT).show();
            reset.callOnClick();
        }

    }

}