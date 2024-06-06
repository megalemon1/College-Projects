package edu.qc.seclass.ReminderApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class myDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Reminders.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "TheList";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_RTYPE = "_type";
    private static final String COLUMN_RREMINDER = "reminder";
    private static final String COLUMN_HOUR = "hour";
    private static final String COLUMN_MINUTE = "minute";

    public myDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_RTYPE + " TEXT, " +
                COLUMN_RREMINDER + " TEXT, " +
                COLUMN_HOUR + " TEXT, " +
                COLUMN_MINUTE + " TEXT);";


        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    void addReminder(String rtype, String reminder) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        long result;

            cv.put(COLUMN_RTYPE, rtype);
            cv.put(COLUMN_RREMINDER, reminder);
            result = db.insert(TABLE_NAME, null, cv);

        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateReminder(String id, String rtype, String reminder) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_RTYPE, rtype);
        cv.put(COLUMN_RREMINDER, reminder);
        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{id});

        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteReminder(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1) {
            Toast.makeText(context, "Could not delete", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor getreminder() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        String query = "Select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
}
