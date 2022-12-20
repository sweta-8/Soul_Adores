package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class quizResult extends AppCompatActivity {
    TextView result,s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        result=findViewById(R.id.result);
        s=findViewById(R.id.s);
        Bundle B=getIntent().getExtras();
        result.setText("Result : "+B.getString("result")+"/40  🤗");
        if(B.getString("result").equals("40"))
            s.setText("Congrats!! You answered all the Questions Correctly.😎 ");
        else
            s.setText("Keep Trying 🙃 ");


    }
}