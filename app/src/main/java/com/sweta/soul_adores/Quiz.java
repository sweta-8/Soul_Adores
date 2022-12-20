package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity implements View.OnClickListener {
    String ques[]={"Which day is celebrated as world Computer Literacy Day?","Who is known as the Human Computer of India?",
            "Which computer engineer got Nobel Prize for literature in 2003?","Sweta loves to be "};
    String Op1[]={"December 2","Aryabhatt","Ankit Fadia","Alone"};
    String Op2[]={"July 8","Shakunthala Devi","James ","Happy"};
    String Op3[]={"April 5","Sundar Pichai","Abdul Kalam ","Quiet"};
    String Op4[]={"March 1","None","J.M. Coetzee","Sad"};
    String ans[]={"December 2","Shakunthala Devi","J.M. Coetzee","Alone"};
    RadioButton r1,r2,r3,r4;
    RadioGroup rg;
    Button next;
    TextView q;
    private int i;
    private int result=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        r4=findViewById(R.id.r4);
        rg=findViewById(R.id.rg);
        next=findViewById(R.id.next);
        q=findViewById(R.id.q);
        setQuestion();
        next.setOnClickListener(this);
    }

    private void setQuestion() {
        q.setText(ques[i]);
        r1.setText(Op1[i]);
        r2.setText(Op2[i]);
        r3.setText(Op3[i]);
        r4.setText(Op4[i]);
    }

    @Override
    public void onClick(View view) {
        if(i<=3)
        {
            RadioButton r=findViewById(rg.getCheckedRadioButtonId());
            if(r!=null)
            {
                if(r.getText().toString().equals(ans[i]))
                {
                    result+=10;
                    rg.clearCheck();
                }
            }
        }
        if(i==3)
        {
            hideview();
            Intent intent= new Intent(Quiz.this,quizResult.class);
            intent.putExtra("result",String.valueOf(result));
            startActivity(intent);
            Toast.makeText(this,""+String.valueOf(result),Toast.LENGTH_SHORT).show();
        }
        if(i<3)
        {
            i++;
            setQuestion();
        }
    }
    public void hideview()
    {
        q.setVisibility(View.GONE);
        rg.setVisibility(View.GONE);
        r1.setVisibility(View.GONE);
        r2.setVisibility(View.GONE);
        r3.setVisibility(View.GONE);
        r4.setVisibility(View.GONE);
        next.setVisibility(View.GONE);
    }
}