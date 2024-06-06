package edu.qc.seclass.ReminderApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import edu.qc.seclass.myapplicatio.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    myDatabaseHelper myDB;
    ArrayList<String> id, reminder_type, reminder, hour, minute;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new myDatabaseHelper(MainActivity.this);
        id = new ArrayList<>();
        reminder_type = new ArrayList<>();
        reminder = new ArrayList<>();
        hour = new ArrayList<>();
        minute = new ArrayList<>();

        storeData();

        customAdapter = new CustomAdapter(MainActivity.this, id, reminder_type, reminder, hour, minute);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void storeData() {
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
        else {
            while(cursor.moveToNext()) {
                id.add(cursor.getString(0));
                reminder_type.add(cursor.getString(1));
                reminder.add(cursor.getString(2));
                hour.add(cursor.getString(3));
                minute.add(cursor.getString(4));
                //Toast.makeText(this, "Inside Store" + cursor.getString(0) + cursor.getString(1) + cursor.getString(2) + cursor.getString(3), Toast.LENGTH_SHORT).show();
            }
        }
    }
}