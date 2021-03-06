package com.pointless.spinthewheel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.pointless.spinthewheel.MainActivity.sc;


public class CrateActivity extends AppCompatActivity {
SharedPreferences mPrefs;
    int pcoins = MainActivity.pcoins;
    float v6 = MainActivity.v6;
    float sc = MainActivity.sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crate);
        TextView tv2 = findViewById(R.id.textView2);
        tv2.setText(String.valueOf(pcoins));
        if (v6 == (float)1.2) {
            ImageView iv = findViewById(R.id.imageView4);
            iv.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.v_6_engine));
            TextView tv = findViewById(R.id.textView5);
            tv.setText("V6 ENGINE - PERMANENT 20% faster spin ");
        }
    }
    public void opencrate(View view){
        if(pcoins > 0) {
            mPrefs = getSharedPreferences("data", Context.MODE_PRIVATE);
            pcoins = pcoins - 1;
            TextView tv = findViewById(R.id.textView5);
            ImageView iv = findViewById(R.id.imageView4);

            Random r = new Random();
            Integer rand = r.nextInt(2);

            if(rand == 1) {
                v6 = (float) 1.2;
                iv.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.v_6_engine));
                tv.setText("V6 ENGINE - PERMANENT 20% faster spin ");
            }else if(rand == 0){
                sc = (float)1.2;
                iv.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.scrooge1));
                tv.setText("SCROOGE - 20% CHEAPER SPEED UPGRADE");
            }
            SharedPreferences.Editor mEditor = mPrefs.edit();
            mEditor.putInt("pcoins", pcoins).apply();
            mEditor.putFloat("v6", v6).apply();
            mEditor.putFloat("sc", sc).apply();
            TextView tv2 = findViewById(R.id.textView2);
            tv2.setText(String.valueOf(pcoins));
        }else Toast.makeText(getApplicationContext(), "Not enough coins", Toast.LENGTH_LONG).show();
    }

    public void back3(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
