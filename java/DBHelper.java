package com.anvipuri.trail;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Task.db";
    private static final String TABLE_TASK = "table_task";
    private static final String KEY_ID = "id";
    private static final String KEY_TASK= "EnterTask";




    //Calling a constructor

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Overriding methods


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_PLACE_TABLE = "CREATE TABLE " + TABLE_TASK + "("
                + KEY_ID + " INTEGER PRIMARY KEY , " + KEY_TASK + " TEXT);";
        db.execSQL(CREATE_PLACE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        onCreate(db);

    }

    //Adding data
    public void save(Task task){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_TASK, task.getTodo());

        db.insert(TABLE_TASK, null, values);
        db.close();
    }


    //Finding all data
    public List<Task> findAll(){
        List<Task> listplace=new ArrayList<Task>();
        String query="SELECT * FROM "+ TABLE_TASK;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Task task=new Task();
                task.setId(Integer.valueOf(cursor.getString(0)));
                task.setTodo(cursor.getString(1));
                listplace.add(task);
            }while(cursor.moveToNext());
        }
db.close();
        return listplace;
    }


    //to delete
    public boolean delete(String task){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_TASK, null,KEY_TASK + " = '" + task + "'",null,null,null,null);
        if(cursor.getCount()<=0)
        {
            return false;
        }
        else {
            db.delete(TABLE_TASK, KEY_TASK + " = '" + task + "'", null);
        }
        db.close();
        return true;
    }
}
