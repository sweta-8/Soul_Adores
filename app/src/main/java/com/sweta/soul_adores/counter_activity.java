package com.sweta.soul_adores;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class counter_activity extends Activity implements View.OnClickListener
{
   Button i,d,r;
   TextView c;
   int count=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter_activity);
        i=findViewById(R.id.inc);
        d=findViewById(R.id.dec);
        r=findViewById(R.id.res);
        c=findViewById(R.id.count);
        i.setOnClickListener(this);
        d.setOnClickListener(this);
        r.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.inc:
                count++;
                c.setText("Count : "+count+"\uD83E\uDD17");
                break;
            case R.id.dec:
                count--;
                c.setText("Count : "+count+"\uD83E\uDD17");
                break;
            case R.id.res:
                count=0;
                c.setText("Count : "+count+"\uD83E\uDD17");
                break;

        }

    }
}
