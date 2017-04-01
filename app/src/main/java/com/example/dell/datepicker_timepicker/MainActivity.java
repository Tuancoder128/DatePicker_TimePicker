package com.example.dell.datepicker_timepicker;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private TimePicker timePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = (DatePicker) findViewById(R.id.datepicker);
        timePicker = (TimePicker) findViewById(R.id.timepicker);
        initDatePicker();
        initTimePicker();

    }
    public  void initDatePicker(){
        Calendar calendar =  Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        int month = calendar.get(calendar.MONTH);
        int date = calendar.get(calendar.DAY_OF_MONTH);


        datePicker.init(year , month,date ,new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(MainActivity.this ,dayOfMonth + "_" + (monthOfYear+1) + year , Toast.LENGTH_SHORT).show();

            }
        });
    }

    public  void initTimePicker(){
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this ,hourOfDay + "_" +minute,Toast.LENGTH_SHORT).show();
            }
        });
    }
}