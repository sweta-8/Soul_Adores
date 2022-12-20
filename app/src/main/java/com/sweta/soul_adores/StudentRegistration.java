package com.sweta.soul_adores;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.sweta.soul_adores.model.Student;

public class StudentRegistration extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase fd;
    StorageReference storageReference;
    DatabaseReference dbr;
    EditText name, id, age, branch;
    Button selectpic, register;
    final static int PIC_REQ = 1001;
    Uri imageuri;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        name = findViewById(R.id.name);
        id = findViewById(R.id.id);
        branch = findViewById(R.id.branch);
        age = findViewById(R.id.age);
        selectpic = findViewById(R.id.select);
        register = findViewById(R.id.register);
        iv = findViewById(R.id.image);
        selectpic.setOnClickListener(this);
        register.setOnClickListener(this);
        storageReference = FirebaseStorage.getInstance().getReference("StudentPic");
        dbr = FirebaseDatabase.getInstance().getReference("Student");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                registerStudent();
                break;
            case R.id.select:
                openFileChooser();
                break;
        }

    }


    private void registerStudent() {
        Toast.makeText(this, "Registered 😊", Toast.LENGTH_SHORT).show();
        if(imageuri!=null)
        {
            StorageReference sr=storageReference.child(System.currentTimeMillis()+"."+getFileExtension(imageuri));
            sr.putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    },1000);
                    Task<Uri> result = taskSnapshot.getMetadata().getReference().getDownloadUrl();
                    result.addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Student s=new Student(name.getText().toString(),Integer.parseInt(id.getText().toString()),branch.getText().toString(),Integer.parseInt(age.getText().toString()),uri.toString());
                            String key = dbr.push().getKey();
                            dbr.child(key).setValue(s);
                            //dbr.child(key).removeValue();
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(StudentRegistration.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {

                }
            });
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cr=getContentResolver();
        MimeTypeMap mime=MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }

    private void openFileChooser() {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PIC_REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PIC_REQ && resultCode == RESULT_OK && data != null) {
            imageuri = data.getData();
            Picasso.get().load(imageuri).into(iv);
        }
    }
}