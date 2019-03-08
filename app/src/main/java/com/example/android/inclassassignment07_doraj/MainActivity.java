package com.example.android.inclassassignment07_doraj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayText;
    private String showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText = (TextView) findViewById(R.id.displayText);
    }

    public void addWater(View view) {
        Intent intent = new Intent(this, InputActivity.class);
        startActivityForResult(intent, RequestCodes.ADD_WATER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RequestCodes.ADD_WATER && resultCode == RESULT_OK) {
            showResult = data.getStringExtra(Keys.WATER)+ "\n" + data.getStringExtra("WATER_TYPE") + "\n" + data.getStringExtra(Keys.MORE_INFO);
            displayText.setText(showResult);
        }

    }
}
