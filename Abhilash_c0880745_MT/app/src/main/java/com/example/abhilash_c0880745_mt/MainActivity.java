package com.example.abhilash_c0880745_mt;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener , View.OnClickListener {

    Spinner spinnerlist;
    EditText pricevalue;
    SeekBar seekbar1;
    int days = 1;
    TextView amount;
    RadioGroup radio_group1;
    RadioButton radioButton;
    CheckBox gps;
    CheckBox childSeat;
    CheckBox unlimitedMillage;
    int age;
    final int Tax = 13;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerlist = findViewById(R.id.spinner_car);
        pricevalue = findViewById(R.id.et_dailyrent);
        seekbar1 = findViewById(R.id.seekbarday);
        amount = findViewById(R.id.daysText);
        radio_group1 = findViewById(R.id.radio_but);
        gps = findViewById(R.id.checkbox_gps);
        childSeat = findViewById(R.id.chkbox_childseat);
        unlimitedMillage = findViewById(R.id.chkbox_mileage);

        spinnerlist.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cars, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerlist.setAdapter(adapter);

        seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                days = progressChangedValue;
              //  seekbar1.setText(String.valueOf(days));
//                Toast.makeText(MainActivity.this, "Seek bar progress is :" + progressChangedValue,
//                        Toast.LENGTH_SHORT).show();
            }
        });


        findViewById(R.id.radio_but).setOnClickListener(this);
        findViewById(R.id.radio_old).setOnClickListener(this);
        findViewById(R.id.radio_young).setOnClickListener(this);

        radio_group1.setOnClickListener(
                v->{
                    int selectedId= radio_group1.getCheckedRadioButtonId();
                    radioButton= findViewById(selectedId);
                    age = Integer.parseInt(String.valueOf(radioButton.getText()));
                    //Toast.makeText(MainActivity.this,radioBtn.getText(),Toast.LENGTH_SHORT).show();
                }
        );
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        String selectedItem = String.valueOf(adapterView.getItemAtPosition(pos));
        String priceVal = "";
        switch (selectedItem){
            case "Toyorasupra":
                priceVal = "4000";
                break;
            case "Mustang":
                priceVal = "6000";
                break;
            case "HondaCivic":
                priceVal = "4500";
                break;
            case "Lamborghini":
                priceVal = "15000";
                break;
            case "BMW":
                priceVal = "8000";
                break;
            case "Audi":
                priceVal = "9000";
                break;
            case "Benz":
                priceVal = "10000";
            case "GTR":
                priceVal = "9500";
            case "Buggati":
                priceVal = "30000";

        }
        pricevalue.setText(priceVal);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

    }
}
