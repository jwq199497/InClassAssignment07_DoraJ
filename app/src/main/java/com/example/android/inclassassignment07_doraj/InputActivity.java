package com.example.android.inclassassignment07_doraj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class InputActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText brand;
    private EditText origin;
    private EditText moreInfo;
    private Spinner spinner;
    private static final String[] waterTypes = {"Spring Water", "Purified Water", "Alkaline Water"};
    Intent data = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        brand = (EditText) findViewById(R.id.brand);
        origin = (EditText)findViewById(R.id.origin);
        moreInfo = (EditText)findViewById(R.id.moreInfo);
        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(InputActivity.this,
                android.R.layout.simple_spinner_item,waterTypes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void submitWater(View view){
        String waterBrand = brand.getText().toString();
        String waterOrigin = origin.getText().toString();
        Water water = new Water(waterBrand, waterOrigin);
        data.putExtra(Keys.WATER, water.toString());
        data.putExtra(Keys.MORE_INFO, moreInfo.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                data.putExtra("WATER_TYPE", "Water Type: Spring Water");
                break;
            case 1:
                data.putExtra("WATER_TYPE", "Water Type: Purified Water");
                break;
            case 2:
                data.putExtra("WATER_TYPE", "Water Type: Alkaline Water");
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        data.putExtra("WATER_TYPE", "Water Type: Other");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
