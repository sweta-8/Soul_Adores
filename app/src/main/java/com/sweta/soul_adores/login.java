package com.sweta.soul_adores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity  implements View.OnClickListener{
    EditText uid,pass;
    Button login;
    SharedPreferences sp;
    SharedPreferences.Editor se;
    FirebaseAuth firebaseAuth;
    boolean res=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uid=findViewById(R.id.uid);
        pass=findViewById(R.id.pass);
        login=findViewById(R.id.login);
        login.setOnClickListener(this);
        firebaseAuth=FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        String id = uid.getText().toString();
        String p=pass.getText().toString();
        if(id.equals(p))
        {
            sp=getSharedPreferences("soulAdorespref",MODE_PRIVATE);
            se=sp.edit();
            se.putBoolean("isLogin",true);
            se.commit();
            Intent intent=new Intent(login.this,MenuActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"INVALID USER",Toast.LENGTH_SHORT).show();

        }

    }
      public void signUp(View view)
      {
          final ProgressDialog progressDialog=new ProgressDialog(this);
          progressDialog.setTitle("Registring..");
          progressDialog.show();
          firebaseAuth.createUserWithEmailAndPassword(uid.getText().toString(),pass.getText().
                  toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                  if (task.isSuccessful()) {
                      // Sign in success, update UI with the signed-in user's information
                      progressDialog.dismiss();
                      Toast.makeText(login.this, "SIGN UP DONE", Toast.LENGTH_SHORT).show();
                  } else {
                      // If sign in fails, display a message to the user.
                      Toast.makeText(login.this, "Authentication failed.",
                              Toast.LENGTH_SHORT).show();
                  }
              }
      });
      }
      private boolean validate(String email,String password)
      {
          firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                  if (task.isSuccessful()) {
                      // Sign in success, update UI with the signed-in user's information
                      res=true;
                  } else {
                      // If sign in fails, display a message to the user.
                      res=false;
                  }

              }
          });
          return res;
      }
}