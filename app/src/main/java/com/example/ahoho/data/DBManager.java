package com.example.ahoho.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.ahoho.model.Student;

public class DBManager extends SQLiteOpenHelper {
    private final String TAG ="DBManager";
      private static final String DATABASE_NAME ="students_manager";
        private static final String TABLE_NAME ="students";
        private static final String ID ="students";
        private static final String NAME ="name";
        private static final String ADDRESS ="address";
        private static final String PHONE_NUMBER ="phone";
        private static final String EMAIL="email";
        private static int VERSION=1;
        private Context context;
        private String  SQLQuery ="CREATE TABLE "+TABLE_NAME+"("+
                ID +"integer primary key,"+
                NAME+"TEXT, "+
                EMAIL+"TEXT, "+
                PHONE_NUMBER+"TEXT,"+
                ADDRESS+"TEXT)";



    public DBManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context=context;

        Log.d(TAG,"DBManager:");
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG,"onUpgrade");
    }

    public void addStudent(Student student) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values     =new ContentValues();

        values.put(NAME,student.getmName());
        values.put(ADDRESS,student.getmAddress());
        values.put(PHONE_NUMBER,student.getmPhoneNumber());
        values.put(EMAIL,student.getEmail());
        db.insert(TABLE_NAME,null,values);
        db.close();
        Log.d(TAG,"addStudent Successfuly:");
    }
}
