package com.samuelford48gmail.campnavigateandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class AccessCode extends AppCompatActivity {
    EditText et;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_code);
        et = findViewById(R.id.editText);
        b = findViewById(R.id.verifyCode);
        final SharedPreferences mySharedPreferences = getApplicationContext().getSharedPreferences("Code", Context.MODE_PRIVATE);

     String code = mySharedPreferences.getString("Code","");
        System.out.println("String" + code);
        if (!code.equals("")) {
            startActivity(new Intent(AccessCode.this, MainActivity.class));
        }
        else {

        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FirebaseFirestore.getInstance().collection("AccessCode").document("Code").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        String ActualCode = "";

                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                ActualCode = (String) document.get("code");
System.out.println(ActualCode);
                                if (et.getText().toString().trim().equals(ActualCode)) {
                                    SharedPreferences.Editor editor = mySharedPreferences.edit();

                                    editor.putString("Code", ActualCode).commit();

                                    startActivity(new Intent(AccessCode.this, MainActivity.class));
                                } else {
                                    AlertDialog.Builder builder;
                                    builder = new AlertDialog.Builder(AccessCode.this);
                                    //builder.setIcon(R.drawable.open_browser);
                                    builder.setTitle("     Incorrect Code");
                                    builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.dismiss();
                                        }
                                    });
                                    builder.setCancelable(true);
                                    builder.show();
                                }
                            }


                        } else {
                            AlertDialog.Builder builder;
                            builder = new AlertDialog.Builder(getApplicationContext());
                            //builder.setIcon(R.drawable.open_browser);
                            builder.setTitle("Please check your wifi/cellular connection and try again");
                            builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
                            builder.setCancelable(true);
                            builder.show();
                        }
                    }
                });
            }

        });
    }
}
