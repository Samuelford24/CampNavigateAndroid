package com.samuelford48gmail.campnavigateandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Settings extends AppCompatActivity {
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        lv = findViewById(R.id.lvSettings);
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("Questions?");
        arrayList.add("Support");
        arrayList.add("Privacy Policy");
        arrayList.add("Version 1.0");
        arrayList.add("Terms of Service");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList);

        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                String item = ((TextView) view).getText().toString();
                if (item.equals("Questions?")) {
                    AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(Settings.this);
                    //builder.setIcon(R.drawable.open_browser);
                    builder.setTitle("Questions?");
                    builder.setMessage("Please email developer@campnavigate.org");

                    builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
                    builder.setCancelable(true);
                    builder.show();

                }
                if (item.equals("Support")) {

                    AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(Settings.this);
                    //builder.setIcon(R.drawable.open_browser);
                    builder.setTitle("          OPEN URL?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            goToUrl("https://forms.gle/HcxZPUtWSJwQJpREA");
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
                    builder.setCancelable(true);
                    builder.show();
                }
                if (item.equals("Privacy Policy")) {
                    AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(Settings.this);
                    //builder.setIcon(R.drawable.open_browser);
                    builder.setTitle("          OPEN URL?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            goToUrl("https://forms.gle/LGBmwxFdp7ngTYfA9");
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
                    builder.setCancelable(true);
                    builder.show();

                }
                if (item.equals("Terms of Service")) {
                    AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(Settings.this);
                    //builder.setIcon(R.drawable.open_browser);
                    builder.setTitle("          OPEN URL?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            goToUrl("https://forms.gle/24DXn6pkrfRH67EL6");
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
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
    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
        Toast.makeText(getApplicationContext(), "Loading...",
                Toast.LENGTH_LONG).show();
//                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

    }
}


