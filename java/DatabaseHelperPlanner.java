package com.anvipuri.trail;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperPlanner extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Plantravel.db";
    private static final String TABLE_PLANNER = "table_planner";
    private static final String KEY_ID = "ID";
    private static final String KEY_CITY= "City";
    private static final String KEY_DAY = "Day";
    private static final String KEY_ONEVIEW = "Oneview";
    private static final String KEY_TWOVIEW = "Twoview";
    private static final String KEY_THREEVIEW = "Threeview";
    private static final String KEY_FOURVIEW = "Fourview";
    private static final String KEY_FIVEVIEW = "Fiveview";
    private static final String KEY_SIXVIEW = "Sixview";
    private static final String KEY_SEVENVIEW = "Sevenview";
    private static final String KEY_EIGHTVIEW = "Eightview";
    private static final String KEY_NINEVIEW = "Nineview";
    private static final String KEY_TENVIEW = "Tenview";
    private static final String KEY_ELEVENVIEW = "Elevenview";
    private static final String KEY_TWELVEVIEW = "Twelveview";
    private static final String KEY_THIRTEENVIEW = "Thirteenview";
    private static final String KEY_FOURTEENVIEW = "Fourteenview";
    private static final String KEY_FIFTEENVIEW = "Fifteenview";



    //Calling a constructor

    public DatabaseHelperPlanner(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Overriding methods


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_PLAN_TABLE = "CREATE TABLE " + TABLE_PLANNER + "("
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_CITY + " TEXT, "
                + KEY_DAY + " TEXT, " + KEY_ONEVIEW + " TEXT, " + KEY_TWOVIEW + " TEXT, " + KEY_THREEVIEW + " TEXT, " + KEY_FOURVIEW + " TEXT, " + KEY_FIVEVIEW + " TEXT, " + KEY_SIXVIEW + " TEXT, " + KEY_SEVENVIEW + " TEXT, " + KEY_EIGHTVIEW + " TEXT, " + KEY_NINEVIEW + " TEXT, " + KEY_TENVIEW + " TEXT, " + KEY_ELEVENVIEW + " TEXT, " + KEY_TWELVEVIEW + " TEXT, " + KEY_THIRTEENVIEW + " TEXT, " + KEY_FOURTEENVIEW + " TEXT, " + KEY_FIFTEENVIEW + " TEXT);";

        db.execSQL(CREATE_PLAN_TABLE);


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANNER);
        onCreate(db);

    }

    //Adding data
    public void save(Planner planner){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_CITY, planner.getCity());
        values.put(KEY_DAY, planner.getDay());
        values.put(KEY_ONEVIEW, planner.getOne_view());
        values.put(KEY_TWOVIEW, planner.getTwo_view());
        values.put(KEY_THREEVIEW, planner.getThree_view());
        values.put(KEY_FOURVIEW,planner.getFour_view());
        values.put(KEY_FIVEVIEW,planner.getFive_view());
        values.put(KEY_SIXVIEW,planner.getSix_view());
        values.put(KEY_SEVENVIEW, planner.getSeven_view());
        values.put(KEY_EIGHTVIEW, planner.getEight_view());
        values.put(KEY_NINEVIEW, planner.getNine_view());
        values.put(KEY_TENVIEW, planner.getTen_view());
        values.put(KEY_ELEVENVIEW,planner.getEleven_view());
        values.put(KEY_TWELVEVIEW,planner.getTwelve_view());
        values.put(KEY_THIRTEENVIEW,planner.getThirteen_view());
        values.put(KEY_FOURTEENVIEW,planner.getFourteen_view());
        values.put(KEY_FIFTEENVIEW,planner.getFifteen_view());


        db.insert(TABLE_PLANNER, null, values);
        db.close();
    }


    public Planner findOne(String c,String d) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor1=db.rawQuery("SELECT * FROM " + TABLE_PLANNER + " WHERE " + KEY_CITY + " ='" + c + "' AND " + KEY_DAY + " ='" + d + "'",null);
        cursor1.moveToFirst();
        if (cursor1 != null) {
            cursor1.moveToFirst();
        }
        db.close();
        return new Planner(Integer.parseInt(cursor1.getString(0)), cursor1.getString(1), cursor1.getString(2), cursor1.getString(3), cursor1.getString(4), cursor1.getString(5), cursor1.getString(6), cursor1.getString(7), cursor1.getString(8), cursor1.getString(9), cursor1.getString(10), cursor1.getString(11),cursor1.getString(12),cursor1.getString(13),cursor1.getString(14),cursor1.getString(15),cursor1.getString(16),cursor1.getString(17));
    }

    //Finding all data
    public List<Planner> findAll(){
        List<Planner> listplanning=new ArrayList<Planner>();
        String query="SELECT * FROM "+ TABLE_PLANNER;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Planner planner= new Planner();
                planner.setId(Integer.valueOf(cursor.getString(0)));
                planner.setCity(cursor.getString(1));
                planner.setDay(cursor.getString(2));
                planner.setOne_view(cursor.getString(3));
                planner.setTwo_view(cursor.getString(4));
                planner.setThree_view(cursor.getString(5));
                planner.setFour_view(cursor.getString(6));
                planner.setFive_view(cursor.getString(7));
                planner.setSix_view(cursor.getString(8));
                planner.setSeven_view(cursor.getString(9));
                planner.setEight_view(cursor.getString(10));
                planner.setNine_view(cursor.getString(11));
                planner.setTen_view(cursor.getString(12));
                planner.setEleven_view(cursor.getString(13));
                planner.setTwelve_view(cursor.getString(14));
                planner.setThirteen_view(cursor.getString(15));
                planner.setFourteen_view(cursor.getString(16));
                planner.setFifteen_view(cursor.getString(17));
                listplanning.add(planner);
            }while(cursor.moveToNext());
        }
db.close();
        return listplanning;
    }

    //to update
    public void update(Planner planner){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(KEY_CITY, planner.getCity());
        values.put(KEY_DAY, planner.getDay());
        values.put(KEY_ONEVIEW, planner.getOne_view());
        values.put(KEY_TWOVIEW, planner.getTwo_view());
        values.put(KEY_THREEVIEW, planner.getThree_view());
        values.put(KEY_FOURVIEW, planner.getFour_view());
        values.put(KEY_FIVEVIEW, planner.getFive_view());
        values.put(KEY_SIXVIEW, planner.getSix_view());
        values.put(KEY_SEVENVIEW, planner.getSeven_view());
        values.put(KEY_EIGHTVIEW, planner.getEight_view());
        values.put(KEY_NINEVIEW, planner.getNine_view());
        values.put(KEY_TENVIEW, planner.getTen_view());
        values.put(KEY_ELEVENVIEW, planner.getEleven_view());
        values.put(KEY_TWELVEVIEW, planner.getTwelve_view());
        values.put(KEY_THIRTEENVIEW, planner.getThirteen_view());
        values.put(KEY_FOURTEENVIEW, planner.getFourteen_view());
        values.put(KEY_FIFTEENVIEW, planner.getFifteen_view());


        db.update(TABLE_PLANNER, values, KEY_ID+" =? ", new String[]{String.valueOf(planner.getId())});
        db.close();
    }

    //to delete
    public void delete(Integer id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_PLANNER, null,KEY_ID + " = '" + id + "'",null,null,null,null);
        db.delete(TABLE_PLANNER, KEY_ID + " = '" + id + "'", null);
        db.close();

    }
}
