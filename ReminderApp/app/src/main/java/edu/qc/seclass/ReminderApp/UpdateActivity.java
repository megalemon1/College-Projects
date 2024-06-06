package edu.qc.seclass.ReminderApp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.qc.seclass.myapplicatio.R;

public class UpdateActivity extends AppCompatActivity {

    EditText reminder_type_input, reminder_input, hour_input, minute_input;
    Button update_button, delete_button;
    String id, reminder_type, reminder, hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        reminder_type_input = findViewById(R.id.reminder_type2);
        reminder_input = findViewById(R.id.reminder2);
        update_button = findViewById(R.id.button_reminder2);
        delete_button = findViewById(R.id.delete_button);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Update");

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabaseHelper myDB = new myDatabaseHelper(UpdateActivity.this);
                myDB.updateReminder(id, reminder_type_input.getText().toString().trim(),
                        reminder_input.getText().toString().trim());
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabaseHelper myDB = new myDatabaseHelper(UpdateActivity.this);
                myDB.deleteReminder(id);
            }
        });

        getIntentData();
    }

    void getIntentData() {
        if (getIntent().hasExtra("Id") && getIntent().hasExtra("Type") && getIntent().hasExtra("Reminder")) {
            id = getIntent().getStringExtra("Id");
            reminder_type = getIntent().getStringExtra("Type");
            reminder = getIntent().getStringExtra("Reminder");

            reminder_type_input.setText(reminder_type);
            reminder_input.setText(reminder);

        }
        else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
}