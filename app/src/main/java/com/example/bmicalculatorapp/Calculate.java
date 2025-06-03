package com.example.bmicalculatorapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class Calculate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculate);
        TextView theResults = (TextView)findViewById(R.id.tvBmiResult);
        ImageView image = (ImageView)findViewById(R.id.ivResults);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        float intWeight = sharedPref.getInt("key1", 0);
        float intHeight = sharedPref.getInt("key2", 0);
        float decBmiResults;
        decBmiResults = (intWeight * 703)/(intHeight * intHeight);
        DecimalFormat currency = new DecimalFormat("###,###.#");
        theResults.setText("Your Body Mass Index is " + currency.format(decBmiResults));
        image.setImageResource(R.drawable.bmi2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}