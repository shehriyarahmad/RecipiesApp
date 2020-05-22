package com.heightincreasingfood.a10heightincreasingfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.io.File;

public class Main2Activity extends AppCompatActivity {

    TextView tv2,tv3,tv4,tv5;
    ImageView pics;
    Button btn1;
    Toolbar tool1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        pics = findViewById(R.id.iv2);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        btn1 = findViewById(R.id.btn1);
        tool1 = findViewById(R.id.tb);
        setSupportActionBar(tool1);

        Intent it = getIntent();
        if(it != null){
            pics.setImageResource(it.getExtras().getInt("pic"));
            tv2.setText(it.getExtras().getString("txt1"));
            tv3.setText(it.getExtras().getString("txt2"));
            tv4.setText(it.getExtras().getString("txt3"));
            tv5.setText(it.getExtras().getString("txt4"));

        }


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
               // sendIntent.putExtra(Intent.EXTRA_TEXT, txt1);
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);

                }
            }
        });






    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sharebutton,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.sb:
                String sharebody="'Your body here";
                String sharesubject="Your subject here";
                        Intent si = new Intent(Intent.ACTION_SEND);
                                si.setType("Text/Plain");
                                si.putExtra(Intent.EXTRA_SUBJECT,sharesubject);
                                si.putExtra(Intent.EXTRA_TEXT,sharebody);
                                startActivity(Intent.createChooser(si,"share using"));

                                break;

        }
        return super.onOptionsItemSelected(item);

    }




}

