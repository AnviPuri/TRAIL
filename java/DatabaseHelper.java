package com.anvipuri.trail;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TRAVEL.db";
    private static final String TABLE_TRAVEL = "table_tram";
    private static final String TABLE_PLACES = "table_places";
    private static final String KEY_ID = "ID";
    private static final String KEY_CITY= "City";
    private static final String KEY_STATE = "State";
    private static final String KEY_LANGUAGE = "Language";
    private static final String KEY_WEATHER = "Weather";
    private static final String KEY_CUISINE = "Cuisine";
    private static final String KEY_FANDF = "Festival_Fairs";
    private static final String KEY_TRANSPORT = "Transport";
    private static final String KEY_PLACE1 = "Place1";
    private static final String KEY_PLACE2 = "Place2";
    private static final String KEY_PLACE3 = "Place3";
    private static final String KEY_PLACE4 = "Place4";
    private static final String KEY_PLACE5 = "Place5";
    private static final String KEY_PLACE6 = "Place6";
    private static final String KEY_PLACE7 = "Place7";
    private static final String KEY_PLACE8 = "Place8";
    private static final String KEY_PLACE9 = "Place9";
    private static final String KEY_PLACE10 = "Place10";



    //Calling a constructor

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Overriding methods


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TRAVEL_TABLE = "CREATE TABLE " + TABLE_TRAVEL + "("
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_CITY + " TEXT, "
                + KEY_STATE + " TEXT, " + KEY_LANGUAGE + " TEXT, " + KEY_WEATHER + " TEXT, " + KEY_CUISINE + " TEXT, " + KEY_FANDF + " TEXT, " + KEY_TRANSPORT + " TEXT);";
        String CREATE_PLACE_TABLE = "CREATE TABLE " + TABLE_PLACES + "("
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_CITY + " TEXT, " + KEY_PLACE1 + " TEXT, " + KEY_PLACE2 + " TEXT, " + KEY_PLACE3 + " TEXT, " + KEY_PLACE4 + " TEXT, " + KEY_PLACE5 + " TEXT, " + KEY_PLACE6 + " TEXT, " + KEY_PLACE7 + " TEXT, " + KEY_PLACE8 + " TEXT, " + KEY_PLACE9 + " TEXT, " + KEY_PLACE10 + " TEXT);";

        db.execSQL(CREATE_TRAVEL_TABLE);
        db.execSQL(CREATE_PLACE_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRAVEL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLACES);
        onCreate(db);

    }

    //Adding data
    public void save(Place place){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_CITY, place.getCity());
        values.put(KEY_STATE, place.getState());
        values.put(KEY_LANGUAGE, place.getLanguage());
        values.put(KEY_WEATHER, place.getWeather());
        values.put(KEY_CUISINE, place.getCuisine());
        values.put(KEY_FANDF, place.getFandf());
        values.put(KEY_TRANSPORT, place.getTransport());

        db.insert(TABLE_TRAVEL, null, values);
        db.close();
    }

    public void save(Suggestion suggestion){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_CITY, suggestion.getCity());
        values.put(KEY_PLACE1, suggestion.getPlace1());
        values.put(KEY_PLACE2, suggestion.getPlace2());
        values.put(KEY_PLACE3, suggestion.getPlace3());
        values.put(KEY_PLACE4, suggestion.getPlace4());
        values.put(KEY_PLACE5, suggestion.getPlace5());
        values.put(KEY_PLACE6, suggestion.getPlace6());
        values.put(KEY_PLACE7, suggestion.getPlace7());
        values.put(KEY_PLACE8, suggestion.getPlace8());
        values.put(KEY_PLACE9, suggestion.getPlace9());
        values.put(KEY_PLACE10,suggestion.getPlace10());

        db.insert(TABLE_PLACES, null, values);
        db.close();
    }

    //Finding data
    public Place findOnep(String c) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor1 = db.query(TABLE_TRAVEL, null, KEY_CITY + " = '" + c + "'", null, null, null, null);
        if (cursor1 != null) {
            cursor1.moveToFirst();
        }
        db.close();
        return new Place(Integer.parseInt(cursor1.getString(0)), cursor1.getString(1), cursor1.getString(2), cursor1.getString(3), cursor1.getString(4), cursor1.getString(5), cursor1.getString(6), cursor1.getString(7));
    }

    public Suggestion findOne(String c) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor1 = db.query(TABLE_PLACES, null, KEY_CITY + " = '" + c + "'", null, null, null, null);
                /*
        Cursor cursor=db.query(TABLE_PLACE, new String[]{KEY_ID,KEY_FROM,KEY_TO},
                KEY_ID+" =? ", new String[]{String.valueOf(id)}, null, null, null);*/
        if (cursor1 != null) {
            cursor1.moveToFirst();
        }
        db.close();
        return new Suggestion(Integer.parseInt(cursor1.getString(0)), cursor1.getString(1), cursor1.getString(2), cursor1.getString(3), cursor1.getString(4), cursor1.getString(5), cursor1.getString(6), cursor1.getString(7), cursor1.getString(8), cursor1.getString(9), cursor1.getString(10), cursor1.getString(11));
    }

    //Finding all data
    public List<Place> findAllp(){
        List<Place> listplace=new ArrayList<Place>();
        String query="SELECT * FROM "+ TABLE_TRAVEL;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Place place=new Place();
                place.setId(Integer.valueOf(cursor.getString(0)));
                place.setCity(cursor.getString(1));
                place.setState(cursor.getString(2));
                place.setLanguage(cursor.getString(3));
                place.setWeather(cursor.getString(4));
                place.setCuisine(cursor.getString(5));
                place.setFandf(cursor.getString(6));
                place.setTransport(cursor.getString(7));
                listplace.add(place);
            }while(cursor.moveToNext());
        }
db.close();
        return listplace;
    }

    public List<Suggestion> findAll(){
        List<Suggestion> listsuggestion=new ArrayList<Suggestion>();
        String query="SELECT * FROM "+ TABLE_PLACES;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Suggestion suggestion= new Suggestion();
                suggestion.setId(Integer.valueOf(cursor.getString(0)));
                suggestion.setCity(cursor.getString(1));
                suggestion.setPlace1(cursor.getString(2));
                suggestion.setPlace2(cursor.getString(3));
                suggestion.setPlace3(cursor.getString(4));
                suggestion.setPlace4(cursor.getString(5));
                suggestion.setPlace5(cursor.getString(6));
                suggestion.setPlace6(cursor.getString(7));
                suggestion.setPlace7(cursor.getString(8));
                suggestion.setPlace8(cursor.getString(9));
                suggestion.setPlace9(cursor.getString(10));
                suggestion.setPlace10(cursor.getString(11));
                listsuggestion.add(suggestion);
            }while(cursor.moveToNext());

        }
        db.close();
        return listsuggestion;
    }

    //to update
    public void updatep(Place place){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(KEY_CITY, place.getCity());
        values.put(KEY_STATE, place.getState());
        values.put(KEY_LANGUAGE, place.getLanguage());
        values.put(KEY_WEATHER, place.getWeather());
        values.put(KEY_CUISINE, place.getCuisine());
        values.put(KEY_FANDF, place.getFandf());
        values.put(KEY_TRANSPORT, place.getTransport());

        db.update(TABLE_TRAVEL, values, KEY_ID+" =? ", new String[]{String.valueOf(place.getId())});
        db.close();
    }

    public void update(Suggestion suggestion){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(KEY_CITY, suggestion.getCity());
        values.put(KEY_PLACE1, suggestion.getPlace1());
        values.put(KEY_PLACE2, suggestion.getPlace2());
        values.put(KEY_PLACE3, suggestion.getPlace3());
        values.put(KEY_PLACE4, suggestion.getPlace4());
        values.put(KEY_PLACE5, suggestion.getPlace5());
        values.put(KEY_PLACE6, suggestion.getPlace6());
        values.put(KEY_PLACE7, suggestion.getPlace7());
        values.put(KEY_PLACE8, suggestion.getPlace8());
        values.put(KEY_PLACE9, suggestion.getPlace9());
        values.put(KEY_PLACE10, suggestion.getPlace10());

        db.update(TABLE_TRAVEL, values, KEY_ID+" =? ", new String[]{String.valueOf(suggestion.getId())});
        db.close();
    }

    //to delete
    public void deletep(Place place){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_TRAVEL, KEY_ID + " =? ", new String[]{String.valueOf(place.getId())});
        db.close();
    }

    public void delete(Suggestion suggestion){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_PLACES, KEY_ID + " =? ", new String[]{String.valueOf(suggestion.getId())});
        db.close();
    }
}
