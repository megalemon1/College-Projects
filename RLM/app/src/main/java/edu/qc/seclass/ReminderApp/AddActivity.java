package edu.qc.seclass.ReminderApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;

import edu.qc.seclass.myapplicatio.R;

public class AddActivity extends AppCompatActivity {

    EditText reminder_type, reminder;
    Button button_reminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reminder_type = findViewById(R.id.reminder_type);
        reminder = findViewById(R.id.reminder);
        button_reminder = findViewById(R.id.button_reminder);
        button_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabaseHelper myDB = new myDatabaseHelper(AddActivity.this);
                myDB.addReminder(reminder_type.getText().toString().trim(), 
                        reminder.getText().toString().trim());
            }
        });
    }

    public void timePicker(View view) {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int h, int m) {
            }
        };
    }
}