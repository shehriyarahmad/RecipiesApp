/*package com.heightincreasingfood.a10heightincreasingfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Main5Activity<AppCompatActivity> extends AppCompatActivity {

    TextView tvz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        tvz = findViewById(R.id.tvz);
        Intent it = getIntent();
        final String txt1 = it.getExtras().getString("pic");


    }
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.i1:
                Intent it = new Intent(Main5Activity.this,Main4Activity.class);
                startActivity(it);
                break;
            default:
                break;
        }
        return false;
    }
}
*/